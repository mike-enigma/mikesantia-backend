package com.borrowing.response;

import com.borrowing.entity.Loan;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanResponse extends BaseResponse {
    private Loan loan;
    private List<Loan> loans;

    public LoanResponse(Integer httpCode, String message, Loan loan, List<Loan> loans) {
        super(httpCode, message);
        this.loan = loan;
        this.loans = loans;
    }

    public Loan getLoan() {
        return loan;
    }

    public List<Loan> getLoans() {
        return loans;
    }
}
