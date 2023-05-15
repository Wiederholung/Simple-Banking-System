package com.metattri.se;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {
    private final String[] uuid = {
            "f7790c67-2dbc-4df4-91d9-8d6fc7645264",
            "f4566a74-379a-409a-a24b-69b542f4566c",
            "a85e67d1-d99a-403e-883c-9a020a44ca22",
            "cc24d6ea-ca28-49da-b8d5-1b8b60376db4"
    };
    private Bank bank;

    @BeforeEach
    void setUp() {
        try {
            bank = new Bank();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

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

        assertTrue(bank.suspendAccount(uuid[0], false));
        assertTrue(bank.deposit(uuid[0], 1000.0));
        assertTrue(bank.withdraw(uuid[0], 1000.0));
    }

    @Test
    void testCloseAndOpenAccount() {
        assertTrue(bank.closeAccount("test"));
        assertFalse(bank.isValid("test"));
        assertEquals(4, bank.getNumOfAccounts());

        System.out.println(bank.openAccount("Yitong Hu", 200000.0));
        System.out.println(bank.openAccount("John2", "CurrentAccount"));
        System.out.println(bank.openAccount("Jane2", "BankAccount"));
        System.out.println(bank.openAccount("Kid3", 13));
        System.out.println(bank.openAccount("Kid4", 14, 400.0));
        bank.printAccounts();
    }

    @Test
    void testSaveAccounts() {
        bank.saveAccounts();
    }

    @Test
    void testChangeAccountType() {
        testDepositAndWithdraw();

        String newAccNo;
        // BankAccount to BankAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType(uuid[0], "BankAccount"));
        // BankAccount to JuniorAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType(uuid[0], "JuniorAccount"));
        // BankAccount to CurrentAccount
        System.out.println(bank.changeAccountType(uuid[0], "CurrentAccount"));

        // CurrentAccount to CurrentAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType(uuid[1], "CurrentAccount"));
        // CurrentAccount to JuniorAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType(uuid[1], "JuniorAccount"));
        // CurrentAccount to BankAccount
        System.out.println(bank.changeAccountType(uuid[1], "BankAccount"));

        // JuniorAccount to JuniorAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType(uuid[3], "JuniorAccount"));
        // JuniorAccount to CurrentAccount
        newAccNo = bank.changeAccountType(uuid[3], "CurrentAccount");
        System.out.println(newAccNo);
        // JuniorAccount to BankAccount
        assertThrows(IllegalArgumentException.class, () -> bank.changeAccountType("test", "BankAccount"));
    }
}