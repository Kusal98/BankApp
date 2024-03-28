package com.example.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAppApplication {

    public static void main(String[] args) {
        Bank bank = new Bank();

        // Create and add accounts to the bank
        BankAccount account1 = new BankAccount(1, "John Doe", 500);
        BankAccount account2 = new BankAccount(2, "Jane Smith", 1000);
        bank.addAccount(account1);
        bank.addAccount(account2);

        // Simulate multiple clients performing operations
        Thread client1 = new Client(bank, 1);
        Thread client2 = new Client(bank, 2);

        client1.start();
        client2.start();
    }
}
