package com.codecool.alexLisztes.model;

import java.math.BigDecimal;

public class Deposit extends Transaction {

    public Deposit(Account account) {
        super(account);
    }

    public Deposit(BigDecimal amount, Account account) {
        super(amount, account);
    }

    public Balance doTransaction() {
        if (this.getAmount() == null) {
            throw new IllegalArgumentException("No amount was set!");
        }
        Balance currentBalance = this.getAccount().getBalance();
        BigDecimal money = currentBalance.getMoney();

        currentBalance.setMoney(money.add(this.getAmount()));
        return currentBalance;
    }
}
