package com.borrowing.response;

import com.borrowing.entity.LoanType;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoanTypeResponse extends BaseResponse{
    private LoanType loanType;
    private List<LoanType> loanTypes;

    public LoanTypeResponse(Integer httpCode, String message, LoanType loanType, List<LoanType> loanTypes) {
        super(httpCode, message);
        this.loanType = loanType;
        this.loanTypes = loanTypes;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public List<LoanType> getLoanTypes() {
        return loanTypes;
    }
}
