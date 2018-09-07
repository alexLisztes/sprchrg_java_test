package com.codecool.alexLisztes.model;

import java.math.BigDecimal;

public class Withdrawal extends Transaction {

    public Withdrawal(Account account) {
        super(account);
    }

    public Withdrawal(BigDecimal amount, Account account) {
        super(amount, account);
    }

    public Balance doTransaction() {
        if (this.getAmount() == null) {
            throw new IllegalArgumentException("No amount was set!");
        }
        Balance currentBalance = this.getAccount().getBalance();
        BigDecimal money = currentBalance.getMoney();

        if(money.compareTo(this.getAmount()) < 0) {
            throw new IllegalArgumentException("Cannot withdraw, not enough money!");
        }

        currentBalance.setMoney(money.subtract(this.getAmount()));
        return currentBalance;
    }
}
