package com.borrowing.services;

import com.borrowing.entity.LoanType;

import java.util.List;

public interface LoanTypeService {
    LoanType saveDataLoanType(LoanType loanType);

    LoanType updateDataLoanType(LoanType loanType);

    LoanType getDataLoanTypeByLoanTypeId(String loanTypeId);

    List<LoanType> getAllDataLoanType();

    void deleteDataLoanTypeByLoanTypeId(String loanTypeId);
}
