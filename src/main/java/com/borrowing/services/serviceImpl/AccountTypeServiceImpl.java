package com.borrowing.services.serviceImpl;

import com.borrowing.constanta.ConstantaAccountType;
import com.borrowing.entity.AccountType;
import com.borrowing.exception.NotFound;
import com.borrowing.repositories.AccountTypeRepository;
import com.borrowing.utils.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountTypeServiceImpl implements com.borrowing.services.AccountTypeService {
    @Autowired
    AccountTypeRepository accountTypeRepository;

    @Override
    public AccountType saveDataAccountType(AccountType accountType){
        accountType.setAccountTypeId(Utility.generateIdLength5());
        return accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType updateDataAccountType(AccountType accountType){
        getAccountTypeByAccountTypeId(accountType.getAccountTypeId());
        return accountTypeRepository.save(accountType);
    }

    @Override
    public AccountType getAccountTypeByAccountTypeId(String accountTypeId){
        if (!accountTypeRepository.findById(accountTypeId).isPresent()){
            throw new NotFound(String.format(ConstantaAccountType.MESSAGE_ACCOUNT_TYPE_NOT_FOUND,accountTypeId));
        }
        return accountTypeRepository.findById(accountTypeId).get();
    }

    @Override
    public List<AccountType> getAllDataAccountType(){
        return accountTypeRepository.findAll();
    }

    @Override
    public void deleteAccountTypeByAccountTypeId(String accountTypeId){
        accountTypeRepository.deleteById(accountTypeId);
    }
}
