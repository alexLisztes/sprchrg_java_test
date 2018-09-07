package com.codecool.alexLisztes;

import com.codecool.alexLisztes.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankApp {

    private List<Account> accounts = new ArrayList<Account>();

    public static void main(String[] args) {

        BankApp moneyCharge = new BankApp();

        Account alex = new Account("Alex");
        Account alfonso = new Account("Alfonso");

        moneyCharge.accounts.add(alex);
        moneyCharge.accounts.add(alfonso);

        alex.performTransaction(BigDecimal.valueOf(5000L), TransactionType.DEPOSIT);
        alex.performTransaction(BigDecimal.valueOf(600L), TransactionType.TRANSFER, alfonso);

        System.out.println(alex.performTransaction(BigDecimal.valueOf(500L), TransactionType.DEPOSIT).getMoney());

        List<Transaction> history = alex.getTransactionList();
        System.out.println();

        alex.printTransactionHistory();
        alex.printFilteredTransactionHistory(TransactionType.DEPOSIT);
    }
}
