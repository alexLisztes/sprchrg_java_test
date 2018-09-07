package com.codecool.alexLisztes.model;

import java.math.BigDecimal;

public class Transfer extends Transaction {

    private Account receiver;


    public Transfer(BigDecimal amount, Account sender, Account receiver) {
        super(amount, sender);
        this.receiver = receiver;
    }

    public Balance doTransaction() {
        if (this.getAccount() == null || this.receiver == null) {
            throw new IllegalArgumentException("The transaction is not set properly, please check the two accounts!");
        } else if (this.getAccount().equals(receiver)) {
            throw new IllegalArgumentException("Cannot transfer money to yourself!");
        }

        Account sender = this.getAccount();
        Account receiver = this.receiver;

        Balance senderBalance = sender.getBalance();
        BigDecimal senderMoney = senderBalance.getMoney();

        // TODO: create a method like hasEnoughMoney and refactor the Deposit and Withdrawal also!
        if (senderMoney.compareTo(this.getAmount()) < 0) {
            throw new IllegalArgumentException("Cannot transfer, not enough money!");
        }

        // FIXME: Cannot call perfromTransaction, that way the transfer gets saved as a Transfer + Withdraw on sender's history
//        sender.performTransaction(this.getAmount(), TransactionType.WITHDRAWAL);
        Transaction wdraw = new Withdrawal(this.getAmount(), sender);
        wdraw.doTransaction();

        // FIXME: Same as above, but with Deposit
//        receiver.performTransaction(this.getAmount(), TransactionType.DEPOSIT);
        Transaction depo = new Deposit(this.getAmount(), receiver);
        depo.doTransaction();

        return senderBalance;
    }
}
