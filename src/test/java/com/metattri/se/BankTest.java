package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    Bank bank = new Bank();

    @BeforeEach
    void setUp() {
        bank.openAccount("001", "John");
        bank.openAccount("002", "Mary", 1000.0);
        bank.openAccount("003", "David", 12);
    }

    @Test
    void testGetNumOfAccounts() {
        assertEquals(3, bank.getNumOfAccounts());
    }

    @Test
    void testDeposit() {
        assertTrue(bank.deposit("001", 1000.0));
        assertEquals(1000.0, bank.checkBalance("001"));

        assertTrue(bank.deposit("002", 2000.0));
        assertEquals(2000.0, bank.checkBalance("002"));

        assertTrue(bank.deposit("003", 150.0));
        assertEquals(150.0, bank.checkBalance("003"));
    }

    @Test
    void testWithdraw() {
        testDeposit();

        assertTrue(bank.withdraw("001", 500.0));
        assertEquals(500.0, bank.checkBalance("001"));

        assertFalse(bank.withdraw("001", 3000.0));
        assertEquals(500.0, bank.checkBalance("001"));

        assertTrue(bank.withdraw("002", 3000.0));
        assertEquals(-1000.0, bank.checkBalance("002"));

        assertFalse(bank.withdraw("002", 1000.1));
        assertEquals(-1000.0, bank.checkBalance("002"));

        assertTrue(bank.withdraw("003", 40.0));
        assertEquals(110.0, bank.checkBalance("003"));

        assertFalse(bank.withdraw("003", 60.1));
        assertEquals(110.0, bank.checkBalance("003"));
    }

    @Test
    void suspendAccount() {
        assertTrue(bank.suspendAccount("001", true));
        assertFalse(bank.deposit("001", 1000.0));

        assertEquals(3, bank.getNumOfAccounts());

        assertTrue(bank.suspendAccount("001", false));
        assertTrue(bank.deposit("001", 1000.0));
    }

    @Test
    void closeAccount() {
        assertTrue(bank.closeAccount("002"));
        assertFalse(bank.isValid("002"));
        assertEquals(2, bank.getNumOfAccounts());

        bank.printAccounts();

        bank.openAccount("002", "Mary", 1000.0);
        bank.printAccount("002");
    }
}