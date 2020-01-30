package com.borrowing.services;

import com.borrowing.entity.Loan;

import java.util.List;

public interface LoanService {
    Loan saveDataLoan(Loan loan);

    Loan updateDataLoan(Loan loan);

    Loan getDataLoanByLoanId(String loanId);

    List<Loan> getAllDataLoan();

    void deleteDataLoanByLoanId(String loanId);
}
