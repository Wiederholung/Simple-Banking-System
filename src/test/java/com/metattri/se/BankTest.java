package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private Bank bank;
    private final String[] uuid = {
            "f7790c67-2dbc-4df4-91d9-8d6fc7645264",
            "f4566a74-379a-409a-a24b-69b542f4566c",
            "a85e67d1-d99a-403e-883c-9a020a44ca22",
    };

    @BeforeEach
    void setUp() {
        try {
            bank = new Bank();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        bank.openAccount("Yitong Hu", 100000.0);
//        bank.openAccount("John", "CurrentAccount");
//        bank.openAccount("Jane", "BankAccount");
//        bank.openAccount("Kid1", 12);
//        bank.openAccount("Kid2", 14, 200.0);
    }

    @Test
    void testDepositAndWithdraw() {
        assertTrue(bank.deposit(uuid[0], 1000.0));
        assertEquals(1000.0, bank.checkBalance(uuid[0]));
        assertTrue(bank.withdraw(uuid[0], 1000.0));
        assertEquals(0.0, bank.checkBalance(uuid[0]));

        assertTrue(bank.deposit(uuid[1], 2000.0));
        assertEquals(2000.0, bank.checkBalance(uuid[1]));
        assertTrue(bank.withdraw(uuid[1], 2500.0));
        assertEquals(-500.0, bank.checkBalance(uuid[1]));
        assertTrue(bank.deposit(uuid[1], 500.0));
        assertEquals(0.0, bank.checkBalance(uuid[1]));

        assertTrue(bank.deposit(uuid[2], 150.0));
        assertEquals(150.0, bank.checkBalance(uuid[2]));
        assertTrue(bank.withdraw(uuid[2], 40.0));
        assertEquals(110.0, bank.checkBalance(uuid[2]));
        assertFalse(bank.withdraw(uuid[2], 60.1));
        assertEquals(110.0, bank.checkBalance(uuid[2]));
        assertTrue(bank.deposit(uuid[2], 40.0));
        assertEquals(150.0, bank.checkBalance(uuid[2]));
    }

    @Test
    void testSuspendAccount() {
        assertTrue(bank.suspendAccount(uuid[0], true));
        assertFalse(bank.deposit(uuid[0], 1000.0));

        assertEquals(5, bank.getNumOfAccounts());

        assertTrue(bank.suspendAccount(uuid[0], false));
        assertTrue(bank.deposit(uuid[0], 1000.0));
        assertTrue(bank.withdraw(uuid[0], 1000.0));
    }

    @Test
    void testCloseAccount() {
        assertTrue(bank.closeAccount("test"));
        assertFalse(bank.isValid("test"));
        assertEquals(5, bank.getNumOfAccounts());

        bank.printAccounts();
    }

    @Test
    void testSaveAccounts() {
        bank.saveAccounts();
    }
}