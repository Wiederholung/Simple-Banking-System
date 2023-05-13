package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("001", "John");
        account.deposit(500.0);
    }

    @Test
    public void testDeposit() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    public void testWithdrawValidAmount() {
        testDeposit();
        account.withdraw(100.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testWithdrawInvalidAmount() {
        assertFalse(account.withdraw(500.1));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    public void testToString() {
        String expected = """
                Account number: 001
                Account type: BankAccount
                Account name: John
                Balance: 500.0""";
        assertEquals(expected, account.toString());
    }
}