package com.example.bankapp;

public class Client extends Thread {
    private Bank bank;
    private int accountNumber;

    private double amount;

    private String trasaction;

    public Client(Bank bank, int accountNumber,double amount, String trasaction ) {
        this.bank = bank;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.trasaction= trasaction;
    }

    @Override
    public void run() {
        // Simulate client operations
        BankAccount account = bank.getAccount(accountNumber);
        if (account != null) {
            // Simulate deposit
            switch (trasaction){
                case "deposit":
                    account.deposit(amount);
                    break;

                case "withdrawal":
                    account.withdraw(amount);
                    break;

                default:
                    System.out.println("enterd transaction is not valid");
            }
            // Simulate balance check
            double balance = account.checkBalance();
            System.out.println("Balance for account " + accountNumber + ": " + balance);
        } else {
            System.out.println("Account not found.");
        }
    }
}