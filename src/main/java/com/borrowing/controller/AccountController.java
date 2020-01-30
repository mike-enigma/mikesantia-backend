package com.borrowing.controller;

import com.borrowing.entity.Account;
import com.borrowing.response.AccountResponse;
import com.borrowing.services.AccountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
@Api(value = "Account Api", description = "Account Api")
public class AccountController {
    @Autowired
    AccountService accountService;
    private AccountResponse accountResponse =null;

    @ApiOperation(value = "Add Account", response = AccountResponse.class)
    @PostMapping("account")
    public ResponseEntity<AccountResponse> saveAccount(
            @ApiParam(value = "Account Object", required = true)
            @RequestBody Account account) {
        Account saveAccount = accountService.saveAccount(account);
        accountResponse = new AccountResponse(HttpStatus.CREATED.value(), "Success Add Account " + saveAccount, null, null);
        return new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit Account", response = AccountResponse.class)
    @PutMapping("account")
    public ResponseEntity<AccountResponse> updateDataAccount(
            @ApiParam(value = "Account Object", required = true)
            @RequestBody Account account) {
        Account update = accountService.updateAccount(account);
        accountResponse = new AccountResponse(HttpStatus.CREATED.value(), "Success Update Account " + update, null, null);
        return new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Account By Account Number", response = AccountResponse.class)
    @GetMapping("account/{accountNumber}")
    public ResponseEntity<AccountResponse> getAccountByAccountNumber(
            @ApiParam(value = "Account Number", required = true)
            @PathVariable String accountNumber) {
        Account account = accountService.getAccountByAccountNumber(accountNumber);
        accountResponse = new AccountResponse(HttpStatus.OK.value(), "Account By accountNumber " + account.getAccountNumber(), account, null);
        return new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List Account", response = AccountResponse.class)
    @GetMapping("accounts")
    public ResponseEntity<AccountResponse> getAllAccount() {
        List<Account> accounts = accountService.getAllDataAccount();
        accountResponse = new AccountResponse(HttpStatus.OK.value(), "List Account", null, accounts);
        return new ResponseEntity<AccountResponse>(accountResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Account By Account Number", response = AccountResponse.class)
    @DeleteMapping("account/{accountNumber}")
    public void deleteDataAccountByAccountNumber(
            @ApiParam(value = "Account Number", required = true)
            @PathVariable String accountNumber) {
        accountService.deleteAccountByAccountNumber(accountNumber);
    }
}
