package com.metattri.se;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = CurrentAccount.class, name = "CurrentAccount"),
        @JsonSubTypes.Type(value = JuniorAccount.class, name = "JuniorAccount"),
})

public class BankAccount {
    private final String accNo;
    private final String type;
    private String accName;
    private double balance;
    private boolean isSuspended = false;

    public BankAccount() {
        this.accNo = UUID.randomUUID().toString();
        this.type = this.getClass().getSimpleName();
    }

    public BankAccount(String accName) {
        this();
        this.accName = accName;
    }

    public String getAccNo() {
        return accNo;
    }

    public String getAccName() {
        return accName;
    }

    public void setAccName(String accName) {
        this.accName = accName;
    }

    public double getBalance() {
        return balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance = balance + amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance = balance - amount;
            return true;
        }
        System.out.println("Insufficient balance");
        return false;
    }

    public String toString() {
        return "Account number: " + accNo + "\n" + "Account type: " + this.type + "\n" + "Account name: " + accName + "\n" + "Balance: " + balance;
    }

    public boolean getIsSuspended() {
        return isSuspended;
    }

    public void setIsSuspended(boolean isSuspended) {
        this.isSuspended = isSuspended;
    }

    public String getType() {
        return this.type;
    }

}