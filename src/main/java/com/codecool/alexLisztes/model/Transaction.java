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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder
                .append("\t- ").append("Type: ").append(this.getClass().getName())
                .append("\n")
                .append("\t  ").append("Date: ").append(new Date(this.date))
                .append("\n")
                .append("\t  ").append("Amount: ").append(this.amount.toString());
        return stringBuilder.toString();
    }
}
