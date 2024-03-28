package com.example.bankapp;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, BankAccount> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public synchronized void addAccount(BankAccount account) {
        accounts.put(account.getAccountNumber(), account);
    }

    public synchronized BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}