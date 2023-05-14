package com.metattri.se;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class JuniorAccount extends BankAccount {
    private int age;
    private double maxWithdraw = 100.0;
    private double amount;


    private String lastWithdrawalDate;

    public JuniorAccount() {
        super();
    }

    public JuniorAccount(String accName, int age) {
        this();
        this.setAccName(accName);
        this.age = age;
    }

    public JuniorAccount(String accName, int age, double maxWithdraw) {
        this(accName, age);
        this.maxWithdraw = maxWithdraw;
    }

    public boolean withdraw(double amount) {
        if (!LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE).equals(this.lastWithdrawalDate)) {
            this.amount = 0.0;
        }
        if (super.getBalance() >= amount && amount <= this.maxWithdraw - this.amount) {
            super.setBalance(super.getBalance() - amount);
            this.amount += amount;
            this.lastWithdrawalDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
            return true;
        }
        System.out.println("Withdraw amount exceeds the maximum amount today");
        return false;
    }

    public int getAge() {
        return age;
    }

    protected void setAge(int age) {
        this.age = age;
    }

    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    public double getAmount() {
        return amount;
    }

    public String getLastWithdrawalDate() {
        return lastWithdrawalDate;
    }
}