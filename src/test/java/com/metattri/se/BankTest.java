package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;
    private final String[] uuid = {
            "bd4eba8a-cc10-4339-8f31-82d6ec567b5b",
            "f4566a74-379a-409a-a24b-69b542f4566c",
            "f7790c67-2dbc-4df4-91d9-8d6fc7645264",
            "a85e67d1-d99a-403e-883c-9a020a44ca22",
            "cc24d6ea-ca28-49da-b8d5-1b8b60376db4"
    };
    @BeforeEach
    void setUp() {
        try {
            bank = new Bank();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals(6, bank.getNumOfAccounts());
//        bank.openAccount("Yitong Hu", 100000.0);
//        bank.openAccount("John", "CurrentAccount");
//        bank.openAccount("Jane", "BankAccount");
//        bank.openAccount("Kid1", 12);
//        bank.openAccount("Kid2", 14, 200.0);
    }

    @Test
    void testDeposit() {
        assertTrue(bank.deposit(uuid[0], 1000.0));
        assertEquals(1000.0, bank.checkBalance(uuid[0]));

        assertTrue(bank.deposit(uuid[1], 2000.0));
        assertEquals(2000.0, bank.checkBalance(uuid[1]));

        assertTrue(bank.deposit(uuid[2], 150.0));
        assertEquals(150.0, bank.checkBalance(uuid[2]));
    }

    @Test
    void testWithdraw() {
        testDeposit();

        assertTrue(bank.withdraw("bd4eba8a-cc10-4339-8f31-82d6ec567b5b", 500.0));
        assertEquals(500.0, bank.checkBalance("bd4eba8a-cc10-4339-8f31-82d6ec567b5b"));

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
        assertTrue(bank.suspendAccount("bd4eba8a-cc10-4339-8f31-82d6ec567b5b", true));
        assertFalse(bank.deposit("bd4eba8a-cc10-4339-8f31-82d6ec567b5b", 1000.0));

        assertEquals(6, bank.getNumOfAccounts());

        assertTrue(bank.suspendAccount("bd4eba8a-cc10-4339-8f31-82d6ec567b5b", false));
        assertTrue(bank.deposit("bd4eba8a-cc10-4339-8f31-82d6ec567b5b", 1000.0));
    }

    @Test
    void closeAccount() {
        assertTrue(bank.closeAccount("test"));
        assertFalse(bank.isValid("test"));
        assertEquals(5, bank.getNumOfAccounts());

        bank.printAccounts();
    }

    @Test
    void saveAccounts() {
        bank.saveAccounts();
    }
}