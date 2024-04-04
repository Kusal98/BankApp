package com.example.bankapp;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BankAccountTest {
    private BankAccount account;
    @Before
    public void setUp() {
        account = new BankAccount(121, "Alice", 1000);
    }
    @Test
    public void testDeposit() {
        account.deposit(500);
        Assert.assertEquals(1500, account.checkBalance(), 0.01);
    }
    @Test
    public void testWithdraw() {
        account.withdraw(200);
        Assert.assertEquals(800, account.checkBalance(), 0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawNegativeAmount() {
        account.withdraw(-200);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testDepositNegativeAmount() {
        account.deposit(-500);
    }
    @Test(expected = IllegalStateException.class)
    public void testWithdrawInsufficientFunds() throws InterruptedException {
        Thread withdrawalThread = new Thread(() -> {
            account.withdraw(1200);
        });
        withdrawalThread.start();
        withdrawalThread.join();
    }
    @Test
    public void testGetBalance() {
        // Testing initial balance
        Assert.assertEquals(1000, account.checkBalance(), 0.01);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidAccountNumber() {
        new BankAccount(-121, "Alice", 1000);
    }
    @Test(expected = IllegalArgumentException.class)
    public void testNegativeInitialBalance() {
        new BankAccount(121, "Alice", -1000);
    }
}