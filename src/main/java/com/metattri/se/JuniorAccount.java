package com.metattri.se;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class JuniorAccount extends BankAccount {
    private final double MAX_WITHDRAW = 100.0;
    private final String FILE_PATH = "jun_acc_amt.csv";
    private int age;
    private double amount = 0.0;

    public JuniorAccount(String accNo, String accName, int age) {
        super(accNo, accName);
        this.age = age;
        this.loadAmount();
    }

    public boolean withdraw(double amount) {
        if (super.getBalance() >= amount && amount <= this.MAX_WITHDRAW - this.amount) {
            super.setBalance(super.getBalance() - amount);
            this.amount += amount;
            this.saveAmount();
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

    public double getWithdrawLimit() {
        return MAX_WITHDRAW;
    }
}