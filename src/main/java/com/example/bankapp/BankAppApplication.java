package com.example.bankapp;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BankAppApplication {

    public static void main(String[] args) {
        Bank bank = new Bank();

        BankAccount account1 = new BankAccount(1, "John Doe", 700);
        BankAccount account2 = new BankAccount(2, "Jane Smith", 1000);
        bank.addAccount(account1);
        bank.addAccount(account2);

        Client client1 = new Client(bank, 1,500,"withdrawal");
        Client client2 = new Client(bank, 2,1250,"deposit");

        // Start the clients
        client1.start();
        client2.start();

        // Wait for clients to finish
        try {
            client1.join();
            client2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
