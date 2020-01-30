package com.borrowing.response;

import com.borrowing.entity.AccountType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountTypeResponce extends BaseResponse{
    private AccountType accountType;
    private List<AccountType> accountTypes;

    public AccountTypeResponce(Integer httpCode, String message, AccountType accountType, List<AccountType> accountTypes) {
        super(httpCode, message);
        this.accountType = accountType;
        this.accountTypes = accountTypes;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public List<AccountType> getAccountTypes() {
        return accountTypes;
    }
}
