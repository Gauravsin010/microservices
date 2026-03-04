package com.micro.accounts.service;

import com.micro.accounts.dto.CustomerDTO;

public interface IAccountsService {

    void createAccount(CustomerDTO customerDTO);
    CustomerDTO fetchAccountDetails(String number);
    boolean updateAccount(CustomerDTO customerDTO);
    boolean deleteAccount(String number);
}
