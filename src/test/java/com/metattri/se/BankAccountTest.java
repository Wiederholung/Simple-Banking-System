package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    void setUp() {
        account = new BankAccount("John");
        account.deposit(500.0);
    }

    @Test
    void testDeposit() {
        account.deposit(100.0);
        assertEquals(600.0, account.getBalance());
    }

    @Test
    void testWithdrawValidAmount() {
        testDeposit();
        account.withdraw(100.0);
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testWithdrawInvalidAmount() {
        assertFalse(account.withdraw(500.1));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testToString() {
        String expected = """
                Account number: UUID
                Account type: BankAccount
                Account name: John
                Balance: 500.0""";
        assertNotEquals(expected, account.toString());
    }
}