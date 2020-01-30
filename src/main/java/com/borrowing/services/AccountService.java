package com.borrowing.services;

import com.borrowing.entity.Account;

import java.util.List;

public interface AccountService {
    Account saveAccount(Account account);

    Account getAccountByAccountNumber(String accountNumber);

    Account updateAccount(Account account);

    List<Account> getAllDataAccount();

    void deleteAccountByAccountNumber(String accountNumber);
}
