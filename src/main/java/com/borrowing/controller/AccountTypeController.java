package com.borrowing.controller;

import com.borrowing.entity.AccountType;
import com.borrowing.response.AccountTypeResponce;
import com.borrowing.services.AccountTypeService;
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
@Api(value = "Account Type Api", description = "Account Type Api")
public class AccountTypeController {
    @Autowired
    AccountTypeService accountTypeService;
    private AccountTypeResponce accountTypeResponce =null;

    @ApiOperation(value = "Add Account Type", response = AccountTypeResponce.class)
    @PostMapping("account-type")
    public ResponseEntity<AccountTypeResponce> saveAccount(
            @ApiParam(value = "Account Type Object", required = true)
            @RequestBody AccountType accountType) {
        AccountType saveAccount = accountTypeService.saveDataAccountType(accountType);
        accountTypeResponce = new AccountTypeResponce(HttpStatus.CREATED.value(), "Success Add Account Type" + saveAccount, null, null);
        return new ResponseEntity<AccountTypeResponce>(accountTypeResponce, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit Account", response = AccountTypeResponce.class)
    @PutMapping("account-type")
    public ResponseEntity<AccountTypeResponce> updateDataAccount(
            @ApiParam(value = "Account Type Object", required = true)
            @RequestBody AccountType accountType) {
        AccountType update = accountTypeService.updateDataAccountType(accountType);
        accountTypeResponce = new AccountTypeResponce(HttpStatus.CREATED.value(), "Success Update Account Type " + update, null, null);
        return new ResponseEntity<AccountTypeResponce>(accountTypeResponce, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Account By Account Type Id", response = AccountTypeResponce.class)
    @GetMapping("account-type/{accountTypeId}")
    public ResponseEntity<AccountTypeResponce> getAccountByAccountNumber(
            @ApiParam(value = "Account Type Id", required = true)
            @PathVariable String accountTypeId) {
        AccountType accountType = accountTypeService.getAccountTypeByAccountTypeId(accountTypeId);
        accountTypeResponce = new AccountTypeResponce(HttpStatus.OK.value(), "Account Type By accountTypeId " + accountType.getAccountTypeId(), accountType, null);
        return new ResponseEntity<AccountTypeResponce>(accountTypeResponce, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List Account", response = AccountTypeResponce.class)
    @GetMapping("account-types")
    public ResponseEntity<AccountTypeResponce> getAllAccount() {
        List<AccountType> accountTypes = accountTypeService.getAllDataAccountType();
        accountTypeResponce = new AccountTypeResponce(HttpStatus.OK.value(), "List Account Type", null, accountTypes);
        return new ResponseEntity<AccountTypeResponce>(accountTypeResponce, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Account By Account Type Id", response = AccountTypeResponce.class)
    @DeleteMapping("account-type/{accountTypeId}")
    public void deleteDataAccountByAccountNumber(
            @ApiParam(value = "Account Type Id", required = true)
            @PathVariable String accountTypeId) {
        accountTypeService.deleteAccountTypeByAccountTypeId(accountTypeId);
    }
}
