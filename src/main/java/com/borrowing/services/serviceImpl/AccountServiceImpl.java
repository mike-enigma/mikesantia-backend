package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaAccount;
import com.borrowing.entity.Account;
import com.borrowing.entity.AccountType;
import com.borrowing.entity.Customer;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.AccountRepository;
import com.borrowing.services.AccountTypeService;
import com.borrowing.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class AccountServiceImpl implements com.borrowing.services.AccountService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    CustomerService customerService;
    @Autowired
    AccountTypeService accountTypeService;

    @Override
    public Account saveAccount(Account account){
        Customer customer=customerService.getDataCustomerByCif(account.getCif());
        account.setCustomer(customer);
        AccountType accountType= accountTypeService.getAccountTypeByAccountTypeId(account.getAccountTypeTransient());
        account.setAccountType(accountType);
        account.setOpenDate(Calendar.getInstance());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber){
        if (!accountRepository.findById(accountNumber).isPresent()){
            throw new NotFound(String.format(ConstantaAccount.MESSAGE_ACCOUNT_TYPE_NOT_FOUND,accountNumber));
        }
        return accountRepository.findById(accountNumber).get();
    }

    @Override
    public Account updateAccount(Account account){
        getAccountByAccountNumber(account.getAccountNumber());
        return accountRepository.save(account);
    }

    @Override
    public List<Account> getAllDataAccount(){
        return accountRepository.findAll();
    }

    @Override
    public void deleteAccountByAccountNumber(String accountNumber){
        accountRepository.deleteById(accountNumber);
    }
}
