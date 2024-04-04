package com.example.bankapp;

public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
    }

    public synchronized void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    public synchronized double checkBalance() {
        return balance;
    }

    public Integer getAccountNumber() {
        return this.accountNumber;
    }

    public String getAccountHolderName(){
        return this.accountHolderName;
    }
}