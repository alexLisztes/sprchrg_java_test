package com.codecool.alexLisztes.model;

import java.math.BigDecimal;
import java.util.Date;


public abstract class Transaction {

    private Long date;

    private BigDecimal amount;

    private Account account;


    Transaction(Account account) {
        this.account = account;
    }

    public Transaction(BigDecimal amount, Account account) {
        this.date = new Date().getTime();
        this.amount = amount;
        this.account = account;
    }

    public abstract Balance doTransaction();

    public Long getDate() {
        return date;
    }

    public void setDate(Long date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
