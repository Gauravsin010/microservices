package com.micro.accounts.service.impl;

import com.micro.accounts.AccountsConstants;
import com.micro.accounts.dto.AccountsDTO;
import com.micro.accounts.dto.CustomerDTO;
import com.micro.accounts.entity.Accounts;
import com.micro.accounts.entity.Customer;
import com.micro.accounts.exception.CustomerAlreadyExistsException;
import com.micro.accounts.exception.ResourceNotFoundException;
import com.micro.accounts.mapper.AccountsMapper;
import com.micro.accounts.mapper.CustomerMapper;
import com.micro.accounts.repo.AccountsRepo;
import com.micro.accounts.repo.CustomerRepo;
import com.micro.accounts.service.IAccountsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl  implements IAccountsService {

    private AccountsRepo accountsRepo;
    private CustomerRepo customerRepo;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        Optional<Customer> customerMobile = customerRepo.findByMobileNumber(customerDTO.getMobileNumber());
        if(customerMobile.isPresent()){
            throw new CustomerAlreadyExistsException("Customer Mobile Number Already Registered.");
        }
        Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());

//        customer.setCreatedAt(LocalDateTime.now());
//        customer.setCreatedBy("ADMIN");
        System.out.println("Customer " + customer.toString());
        Customer response = customerRepo.save(customer);
        Accounts accounts = accountsRepo.save(createNewAccount(response));
    }

    @Override
    public CustomerDTO fetchAccountDetails(String number) {
        Customer customer = customerRepo.findByMobileNumber(number).orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", number));
        Accounts accounts = accountsRepo.findByCustomerId(customer.getCustomerId()).orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(new CustomerDTO(), customer);
        customerDTO.setAccountsDTO(AccountsMapper.mapToAccountDTO(new AccountsDTO(), accounts));
        return customerDTO;
    }

    @Override
    public boolean updateAccount(CustomerDTO customerDTO) {

        boolean isUpdated = false;

        AccountsDTO accountsDTO = customerDTO.getAccountsDTO();

        if(accountsDTO != null){
            Accounts accounts = accountsRepo.findByCustomerId(accountsDTO.getCustomerId()).orElseThrow(()-> new ResourceNotFoundException("Account", "AccountNumber", accountsDTO.getCustomerId().toString()));

            AccountsMapper.mapToAccounts(accountsDTO, accounts);
            accounts = accountsRepo.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepo.findById(customerId).orElseThrow(
                    () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
            );
            CustomerMapper.mapToCustomer(customerDTO,customer);
            customerRepo.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String number) {
        Customer customer = customerRepo.findByMobileNumber(number).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobileNumber", number)
        );
        accountsRepo.deleteByCustomerId(customer.getCustomerId());
        customerRepo.deleteById(customer.getCustomerId());
        return true;
    }

    private Accounts createNewAccount(Customer customer){

        Accounts accounts = new Accounts();
        accounts.setCustomerId(customer.getCustomerId());
        accounts.setAccountType(AccountsConstants.SAVINGS);
        accounts.setBranchAddress(AccountsConstants.ADDRESS);

        long randomAcc  = 100000000L + new Random().nextInt(900000000);
        accounts.setAccountNumber(randomAcc);

        return accounts;
    }
}
