package com.borrowing.controller;

import com.borrowing.entity.LoanType;
import com.borrowing.response.LoanTypeResponse;
import com.borrowing.services.LoanTypeService;
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
@Api(value = "Loan Type Api", description = "Loan Type Api")
public class LoanTypeController {
    @Autowired
    LoanTypeService loanTypeService;
    private LoanTypeResponse loanTypeResponse=null;

    @ApiOperation(value = "Add Loan Type", response = LoanTypeResponse.class)
    @PostMapping("loan-type")
    public ResponseEntity<LoanTypeResponse> saveDataLoanType(
            @ApiParam(value = "Loan Type Object", required = true)
            @RequestBody LoanType loanType) {
        LoanType saveLoanType = loanTypeService.saveDataLoanType(loanType);
        loanTypeResponse = new LoanTypeResponse(HttpStatus.CREATED.value(), "Success Add Loan " + saveLoanType, null, null);
        return new ResponseEntity<LoanTypeResponse>(loanTypeResponse, HttpStatus.CREATED);
    }
    @ApiOperation(value = "Edit Loan Type", response = LoanTypeResponse.class)
    @PutMapping("loan-type")
    public ResponseEntity<LoanTypeResponse> updateDataLoanType(
            @ApiParam(value = "Loan Type Object", required = true)
            @RequestBody LoanType loanType) {
        LoanType update = loanTypeService.updateDataLoanType(loanType);
        loanTypeResponse = new LoanTypeResponse(HttpStatus.CREATED.value(), "Success Update Loan Type" + update, null, null);
        return new ResponseEntity<LoanTypeResponse>(loanTypeResponse, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Get Loan By Loan Id", response = LoanTypeResponse.class)
    @GetMapping("loan-type/{loanTypeId}")
    public ResponseEntity<LoanTypeResponse> getDataLoanTypeByLoanTypeId(
            @ApiParam(value = "Loan Type Id", required = true)
            @PathVariable String loanTypeId) {
        LoanType loanType = loanTypeService.getDataLoanTypeByLoanTypeId(loanTypeId);
        loanTypeResponse = new LoanTypeResponse(HttpStatus.OK.value(), "Loan By Laon Id " + loanType.getLoanTypeId(), loanType, null);
        return new ResponseEntity<LoanTypeResponse>(loanTypeResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Get List Loan Type Id", response = LoanTypeResponse.class)
    @GetMapping("loan-types")
    public ResponseEntity<LoanTypeResponse> getAllDataLoanType() {
        List<LoanType> loanTypes = loanTypeService.getAllDataLoanType();
        loanTypeResponse = new LoanTypeResponse(HttpStatus.OK.value(), "List Loan", null, loanTypes);
        return new ResponseEntity<LoanTypeResponse>(loanTypeResponse, HttpStatus.OK);
    }

    @ApiOperation(value = "Delete Loan By Loan Id", response = LoanTypeResponse.class)
    @DeleteMapping("customer/{loanTypeId}")
    public void deleteDataLoanTypeByLoanTypeId(
            @ApiParam(value = "Loan Type Id", required = true)
            @PathVariable String loanTypeId) {
        loanTypeService.deleteDataLoanTypeByLoanTypeId(loanTypeId);
    }
}
