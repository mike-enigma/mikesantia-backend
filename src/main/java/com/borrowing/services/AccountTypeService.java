package com.borrowing.services;

import com.borrowing.entity.AccountType;

import java.util.List;

public interface AccountTypeService {
    AccountType saveDataAccountType(AccountType accountType);

    AccountType updateDataAccountType(AccountType accountType);

    AccountType getAccountTypeByAccountTypeId(String accountTypeId);

    List<AccountType> getAllDataAccountType();

    void deleteAccountTypeByAccountTypeId(String accountTypeId);
}
