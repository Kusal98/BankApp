package com.example.bankapp;

public class Client extends Thread {
    private Bank bank;
    private int accountNumber;

    public Client(Bank bank, int accountNumber) {
        this.bank = bank;
        this.accountNumber = accountNumber;
    }

    @Override
    public void run() {
        // Simulate client operations
        BankAccount account = bank.getAccount(accountNumber);
        if (account != null) {
            // Simulate deposit
            account.deposit(100);

            // Simulate withdrawal
            account.withdraw(50);

            // Simulate balance check
            double balance = account.checkBalance();
            System.out.println("Balance for account " + accountNumber + ": " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}