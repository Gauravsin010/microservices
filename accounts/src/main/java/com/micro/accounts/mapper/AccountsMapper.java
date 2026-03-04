package com.micro.accounts.mapper;

import com.micro.accounts.dto.AccountsDTO;
import com.micro.accounts.entity.Accounts;

public class AccountsMapper {

    public static AccountsDTO mapToAccountDTO(AccountsDTO accountsDTO, Accounts accounts){
        accountsDTO.setAccountType(accounts.getAccountType());
        accountsDTO.setCustomerId(accounts.getCustomerId());
        accountsDTO.setBranchAddress(accounts.getBranchAddress());
        return accountsDTO;
    }

    public static Accounts mapToAccounts(AccountsDTO accountsDTO, Accounts accounts){
        accounts.setAccountType(accountsDTO.getAccountType());
        accounts.setCustomerId(accountsDTO.getCustomerId());
        accounts.setBranchAddress(accountsDTO.getBranchAddress());
        return accounts;
    }
}
