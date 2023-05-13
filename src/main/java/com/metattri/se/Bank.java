package com.metattri.se;

import java.util.HashMap;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accountMap = new HashMap<>();

    public void openAccount(BankAccount account) {
        this.accountMap.put(account.getAccNo(), account);
    }

    public boolean isValid(String accNo) {
        BankAccount account = this.accountMap.get(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        if (account.isSuspended()) {
            System.out.println("Account is suspended");
            return false;
        }
        return true;
    }

    public boolean suspendAccount(String accNo) {
        BankAccount account = this.accountMap.get(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        account.setSuspended(true);
        return true;
    }

    public boolean closeAccount(String accNo) {
        if (this.isValid(accNo)) {
            this.accountMap.remove(accNo);
            return true;
        }
        return false;
    }

    public boolean deposit(String accNo, double amount) {
        if (this.isValid(accNo)) {
            this.accountMap.get(accNo).deposit(amount);
            return true;
        }
        return false;
    }

    public boolean withdraw(String accNo, double amount) {
        if (this.isValid(accNo)) {
            return this.accountMap.get(accNo).withdraw(amount);
        }
        return false;
    }

    public double checkBalance(String accNo) {
        if (this.isValid(accNo)) {
            return this.accountMap.get(accNo).getBalance();
        }
        return -1.0;
    }

    public void printAccount(String accNo) {
        if (this.isValid(accNo)) {
            System.out.println(this.accountMap.get(accNo));
        }
    }

    public void printAccounts() {
        for (BankAccount account : this.accountMap.values()) {
            System.out.println(account);
        }
    }

    public int getNumOfAccounts() {
        return this.accountMap.size();
    }
}
