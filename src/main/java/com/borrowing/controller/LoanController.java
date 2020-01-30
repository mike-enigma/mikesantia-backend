package com.borrowing.controller;

import com.borrowing.entity.Loan;
import com.borrowing.response.LoanResponse;
import com.borrowing.services.LoanService;
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
@Api(value = "Loan Api", description = "Loan Api")
public class LoanController {
    @Autowired
    LoanService loanService;
    private LoanResponse loanResponse=null;

    @ApiOperation(value = "Add Loan", response = LoanResponse.class)
    @PostMapping("loan")
    public ResponseEntity<LoanResponse> saveDataLoan(
            @ApiParam(value = "Loan Object", required = true)
            @RequestBody Loan loan) {
        Loan saveLoan = loanService.saveDataLoan(loan);
        loanResponse = new LoanResponse(HttpStatus.CREATED.value(), "Success Add Loan " + saveLoan, null, null);
        return new ResponseEntity<LoanResponse>(loanResponse, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit Loan", response = LoanResponse.class)
    @PutMapping("loan")
    public ResponseEntity<LoanResponse> updateDataLoan(
            @ApiParam(value = "Loan Object", required = true)
            @RequestBody Loan loan) {
        Loan update = loanService.updateDataLoan(loan);
        loanResponse = new LoanResponse(HttpStatus.CREATED.value(), "Success Update Loan " + update, null, null);
        return new ResponseEntity<LoanResponse>(loanResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Loan By Loan Id", response = LoanResponse.class)
    @GetMapping("loan/{loanId}")
    public ResponseEntity<LoanResponse> getLoanByLoanId(
            @ApiParam(value = "Loan Id", required = true)
            @PathVariable String loanId) {
        Loan loan = loanService.getDataLoanByLoanId(loanId);
        loanResponse = new LoanResponse(HttpStatus.OK.value(), "Loan By Loan Id " + loan.getLoanId(), loan, null);
        return new ResponseEntity<LoanResponse>(loanResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List Loan", response = LoanResponse.class)
    @GetMapping("loans")
    public ResponseEntity<LoanResponse> getAllLoan() {
        List<Loan> loans = loanService.getAllDataLoan();
        loanResponse = new LoanResponse(HttpStatus.OK.value(), "List Loan", null, loans);
        return new ResponseEntity<LoanResponse>(loanResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Loan By Loan Id", response = LoanResponse.class)
    @DeleteMapping("loan/{loanId}")
    public void deleteLoanByLoanId(
            @ApiParam(value = "Loan Id", required = true)
            @PathVariable String loanId) {
        loanService.deleteDataLoanByLoanId(loanId);
    }
}
