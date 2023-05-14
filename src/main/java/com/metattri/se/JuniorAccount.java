package com.metattri.se;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class JuniorAccount extends BankAccount {
    private final String FILE_PATH = "jun_acc_amt.csv";
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

    private void loadAmount() {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] components = line.split(",");
                if (components.length >= 3 && components[1].equals(super.getAccNo()) && components[0].equals(currentDate)) {
                    try {
                        this.amount = Double.parseDouble(components[2]);
                        return;
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid amount in log file: " + components[2]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
        }
    }

    private void saveAmount() {
        String currentDate = LocalDate.now().format(DateTimeFormatter.ISO_LOCAL_DATE);
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading log file: " + e.getMessage());
            return;
        }

        for (int i = 0; i < lines.size(); i++) {
            String[] components = lines.get(i).split(",");
            if (components.length < 3 || (components[1].equals(super.getAccNo()) && components[0].equals(currentDate))) {
                lines.remove(i);
            }
        }
        lines.add(currentDate + "," + super.getAccNo() + "," + this.amount);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing log file: " + e.getMessage());
        }
    }

    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getLastWithdrawalDate() {
        return lastWithdrawalDate;
    }

    public void setLastWithdrawalDate(String lastWithdrawalDate) {
        this.lastWithdrawalDate = lastWithdrawalDate;
    }
}