package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class JuniorAccountTest {
    private JuniorAccount account;

    @BeforeEach
    void setUp() {
        account = new JuniorAccount("003", "David", 12);
        account.deposit(100);
    }

    @Test
    void testWithdraw() {
        assertTrue(account.withdraw(10.0));
        assertEquals(90.0, account.getBalance());

        assertFalse(account.withdraw(90.1));
        assertEquals(90.0, account.getBalance());
    }

    @Test
    void testGetWithdrawLimit() {
        assertEquals(100.0, account.getWithdrawLimit());
    }

    @Test
    void testToString() {
        String expected = """
                Account number: 003
                Account type: JuniorAccount
                Account name: David
                Balance: 100.0""";
        assertEquals(expected, account.toString());
    }
}
