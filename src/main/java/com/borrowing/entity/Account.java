package com.borrowing.entity;

import com.borrowing.constanta.ConstantaAccount;
import com.borrowing.constanta.ConstantaAccountType;
import com.borrowing.constanta.ConstantaCustomer;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name = ConstantaAccount.ENTITY_ACCOUNT)
public class Account {
    @Id
    private String accountNumber;
    private Calendar openDate;
    @ManyToOne
    @JoinColumn(name=ConstantaAccountType.JOIN_ENTITY)
    private AccountType accountType;
    @Transient
    private String accountTypeTransient;
    private BigDecimal balance;
    @ManyToOne
    @JoinColumn(name = ConstantaCustomer.JOIN_CUSTOMER)
    private Customer customer;
    @Transient
    private String cif;

    public Account(String accountTypeTransient, BigDecimal balance, String cif) {
        this.accountTypeTransient = accountTypeTransient;
        this.balance = balance;
        this.cif = cif;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Calendar getOpenDate() {
        return openDate;
    }

    public void setOpenDate(Calendar openDate) {
        this.openDate = openDate;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public String getAccountTypeTransient() {
        return accountTypeTransient;
    }

    public void setAccountTypeTransient(String accountTypeTransient) {
        this.accountTypeTransient = accountTypeTransient;
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
        Account account = (Account) o;
        return Objects.equals(accountNumber, account.accountNumber) &&
                Objects.equals(openDate, account.openDate) &&
                Objects.equals(accountType, account.accountType) &&
                Objects.equals(accountTypeTransient, account.accountTypeTransient) &&
                Objects.equals(balance, account.balance) &&
                Objects.equals(customer, account.customer) &&
                Objects.equals(cif, account.cif);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountNumber, openDate, accountType, accountTypeTransient, balance, customer, cif);
    }
}
