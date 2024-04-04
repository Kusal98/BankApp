package com.example.bankapp;
import java.util.concurrent.ConcurrentHashMap;

public class Bank {
    private ConcurrentHashMap<Integer, BankAccount> accounts;

    public Bank() {

        this.accounts = new ConcurrentHashMap<>();
    }

    public void addAccount(BankAccount account) {

        accounts.putIfAbsent(account.getAccountNumber(), account);
    }

    public BankAccount getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }
}