package com.codecool.alexLisztes.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Stream;

public class Account {

    private long id;

    private String name;

    private Balance balance;

    private List<Transaction> transactionList = new ArrayList<Transaction>();

    private static long lastId = 0L;


    public Account(String name) {
        this.id = ++lastId;
        this.balance = new Balance();
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Balance getBalance() {
        return balance;
    }

    public void setBalance(Balance balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Balance performTransaction(BigDecimal amount, TransactionType type) {
        Transaction t = null;
        switch (type) {
            case DEPOSIT:
                t = new Deposit(amount, this);
                break;

            case WITHDRAWAL:
                t = new Withdrawal(amount, this);
                break;
            case TRANSFER:
                throw new IllegalArgumentException("Cannot transfer money, Receiver is not specified!");
        }
        t.doTransaction();
        this.transactionList.add(t);

        return this.getBalance();
    }

    public Balance performTransaction(BigDecimal amount, TransactionType type, Account receiver) {
        if (type != TransactionType.TRANSFER) {
            throw new IllegalArgumentException("Wrong transaction type!");
        }

        Transaction t = new Transfer(amount, this, receiver);
        t.doTransaction();
        this.transactionList.add(t);

        return this.getBalance();
    }

    public void printTransactionHistory() {
        ListIterator<Transaction> iter = this.transactionList.listIterator();

        System.out.println(String.format("Transaction history of %s: ", this.getName()));

        while (iter.hasNext()) {
            Transaction t = iter.next();
            System.out.println(t.toString());
            System.out.println();
        }
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}
