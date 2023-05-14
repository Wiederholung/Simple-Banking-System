package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CurrentAccountTest {
    private CurrentAccount account;

    @BeforeEach
    void setUp() {
        account = new CurrentAccount("Mary");
        account.deposit(500);
    }

    @Test
    void testWithdrawWithinBalanceAndOverdraftLimit() {
        assertTrue(account.withdraw(600.0));
        assertEquals(-100.0, account.getBalance());
    }

    @Test
    void testWithdrawOverBalanceAndOverdraftLimit() {
        assertFalse(account.withdraw(1000.1));
        assertEquals(500.0, account.getBalance());
    }

    @Test
    void testGetOverdraftLimit() {
        assertEquals(500.0, account.getOverdraftLimit());
    }

    @Test
    void testSetOverdraftLimit() {
        account.setOverdraftLimit(2000.0);
        assertEquals(2000.0, account.getOverdraftLimit());
    }

    @Test
    void testToString() {
        String expected = """
                Account number: UUID
                Account type: CurrentAccount
                Account name: Mary
                Balance: 500.0""";
        assertNotEquals(expected, account.toString());
    }
}