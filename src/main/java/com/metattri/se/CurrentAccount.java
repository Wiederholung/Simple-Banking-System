package com.metattri.se;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit = 500.0;

    public CurrentAccount() {
        super();
    }

    public CurrentAccount(String accName) {
        this();
        this.setAccName(accName);
    }

    public CurrentAccount(String accName, double odLimit) {
        this(accName);
        this.overdraftLimit = odLimit;
    }

    public boolean withdraw(double amount) {
        if (super.getBalance() + this.overdraftLimit >= amount) {
            super.setBalance(super.getBalance() - amount);
            return true;
        }
        System.out.println("Overdraft limit exceeded");
        return false;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    protected void setOverdraftLimit(double overdraftLimit) {
        this.overdraftLimit = overdraftLimit;
    }
}