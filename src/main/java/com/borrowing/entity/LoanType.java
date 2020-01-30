package com.borrowing.entity;

import com.borrowing.constanta.ConstantaLoanType;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = ConstantaLoanType.ENTITY_LOAN_TYPE)
public class LoanType {
    @Id
    private String loanTypeId;
    private String description;

    public LoanType(String description) {
        this.description = description;
    }

    public String getLoanTypeId() {
        return loanTypeId;
    }

    public void setLoanTypeId(String loanTypeId) {
        this.loanTypeId = loanTypeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LoanType loanType1 = (LoanType) o;
        return Objects.equals(loanTypeId, loanType1.loanTypeId) &&
                Objects.equals(description, loanType1.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanTypeId, description);
    }
}
