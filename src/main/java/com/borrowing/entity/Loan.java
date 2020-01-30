package com.borrowing.entity;

import com.borrowing.constanta.ConstantaCollectStatus;
import com.borrowing.constanta.ConstantaCustomer;
import com.borrowing.constanta.ConstantaLoan;
import com.borrowing.constanta.ConstantaLoanType;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = ConstantaLoan.ENTITY_LOAN)
public class Loan {
    private String loanId;
    private Calendar openDate;
    private Integer tenor;
    @ManyToOne
    @JoinColumn(name = ConstantaCollectStatus.JOIN_COLLECT_STATUS)
    private CollectStatus collectStatus;
    @Transient
    private Integer collectStatusTransient;
    @ManyToOne
    @JoinColumn(name = ConstantaLoanType.JOIN_LOAN_TYPE)
    private LoanType loanType;
    @Transient
    private String loanTypeTransient;
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = ConstantaCustomer.JOIN_CUSTOMER)
    private Customer customer;
    @Transient
    private String cif;

    public Loan(Integer tenor, Integer collectStatusTransient, String loanTypeTransient, BigDecimal balance, String cif) {
        this.tenor = tenor;
        this.collectStatusTransient = collectStatusTransient;
        this.loanTypeTransient = loanTypeTransient;
        this.balance = balance;
        this.cif = cif;
    }

    public String getLoanId() {
        return loanId;
    }

    public void setLoanId(String loanId) {
        this.loanId = loanId;
    }

    public Calendar getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Calendar openDate) {
        this.openDate = openDate;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public CollectStatus getCollectStatus() {
        return collectStatus;
    }

    public void setCollectStatus(CollectStatus collectStatus) {
        this.collectStatus = collectStatus;
    }

    public Integer getCollectStatusTransient() {
        return collectStatusTransient;
    }

    public void setCollectStatusTransient(Integer collectStatusTransient) {
        this.collectStatusTransient = collectStatusTransient;
    }

    public LoanType getLoanType() {
        return loanType;
    }

    public void setLoanType(LoanType loanType) {
        this.loanType = loanType;
    }

    public String getLoanTypeTransient() {
        return loanTypeTransient;
    }

    public void setLoanTypeTransient(String loanTypeTransient) {
        this.loanTypeTransient = loanTypeTransient;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loan loan = (Loan) o;
        return Objects.equals(loanId, loan.loanId) &&
                Objects.equals(openDate, loan.openDate) &&
                Objects.equals(tenor, loan.tenor) &&
                Objects.equals(collectStatus, loan.collectStatus) &&
                Objects.equals(collectStatusTransient, loan.collectStatusTransient) &&
                Objects.equals(loanType, loan.loanType) &&
                Objects.equals(loanTypeTransient, loan.loanTypeTransient) &&
                Objects.equals(balance, loan.balance) &&
                Objects.equals(customer, loan.customer) &&
                Objects.equals(cif, loan.cif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loanId, openDate, tenor, collectStatus, collectStatusTransient, loanType, loanTypeTransient, balance, customer, cif);
    }
}
