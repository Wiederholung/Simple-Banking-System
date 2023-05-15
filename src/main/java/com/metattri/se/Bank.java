package com.metattri.se;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private final Map<String, BankAccount> accountMap = new HashMap<>();
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final File dataFile = new File("src/main/resources/accounts.json");

    public Bank() throws IOException {
        this.loadAccounts();
    }

    public String openAccount(BankAccount account) {
        this.accountMap.put(account.getAccNo(), account);
        this.saveAccounts();
        return account.getAccNo();
    }

    public String openAccount(String accName, String accType) {
        BankAccount account = switch (accType) {
            case "CurrentAccount" -> new CurrentAccount(accName);
            case "BankAccount" -> new BankAccount(accName);
            default -> throw new IllegalArgumentException("Invalid account type");
        };
        return openAccount(account);
    }

    public String openAccount(String accName, Double odLimit) {
        return openAccount(new CurrentAccount(accName, odLimit));
    }

    public String openAccount(String accName, int age) {
        return openAccount(new JuniorAccount(accName, age));
    }

    public String openAccount(String accName, int age, double maxWithdrawal) {
        return openAccount(new JuniorAccount(accName, age, maxWithdrawal));
    }

    public boolean isValid(String accNo) {
        BankAccount account = this.accountMap.get(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        if (account.getIsSuspended()) {
            System.out.println("Account is suspended");
            return false;
        }
        this.saveAccounts();
        return true;
    }

    public boolean suspendAccount(String accNo, boolean isSuspended) {
        BankAccount account = this.accountMap.get(accNo);
        if (account == null) {
            System.out.println("Account not found");
            return false;
        }
        account.setIsSuspended(isSuspended);
        this.saveAccounts();
        return true;
    }

    public boolean closeAccount(String accNo) {
        if (this.isValid(accNo)) {
            this.accountMap.remove(accNo);
            this.saveAccounts();
            return true;
        }
        return false;
    }

    public boolean deposit(String accNo, double amount) {
        if (this.isValid(accNo)) {
            this.accountMap.get(accNo).deposit(amount);
            this.saveAccounts();
            return true;
        }
        return false;
    }

    public boolean withdraw(String accNo, double amount) {
        if (this.isValid(accNo)) {
            boolean flag = this.accountMap.get(accNo).withdraw(amount);
            this.saveAccounts();
            return flag;
        }
        return false;
    }

    public String changeAccountType(String accNo, String tgtType) {
        if (this.isValid(accNo)) {
            BankAccount currAccount = this.accountMap.get(accNo);
            String currType = currAccount.getType();
            String newAccNo;

            if (currType.equals(tgtType)) {
                System.out.println("Account type is already " + tgtType);
                return accNo;
            }

            switch (currType) {
                case "CurrentAccount" -> {
                    if (currAccount.getBalance() >= 0) {
                        if (tgtType.equals("BankAccount")) {
                            newAccNo = openAccount(currAccount.getAccName(), tgtType);
                            this.deposit(newAccNo, currAccount.getBalance());
                            this.closeAccount(accNo);
                            return newAccNo;
                        } else {
                            throw new IllegalArgumentException("Invalid target account type");
                        }
                    } else {
                        throw new IllegalArgumentException("Account balance is negative");
                    }
                }
                case "BankAccount" -> {
                    if (tgtType.equals("CurrentAccount")) {
                        newAccNo = openAccount(currAccount.getAccName(), tgtType);
                        this.deposit(newAccNo, currAccount.getBalance());
                        this.closeAccount(accNo);
                        return newAccNo;
                    } else {
                        throw new IllegalArgumentException("Invalid target account type");
                    }
                }
                case "JuniorAccount" -> {
                    if (tgtType.equals("CurrentAccount") || tgtType.equals("BankAccount")) {
                        if (((JuniorAccount) currAccount).getAge() >= 16) {
                            newAccNo = openAccount(currAccount.getAccName(), tgtType);
                            this.deposit(newAccNo, currAccount.getBalance());
                            this.closeAccount(accNo);
                            return newAccNo;
                        } else {
                            throw new IllegalArgumentException("Account holder is under 16");
                        }
                    }
                }
                default -> System.out.println("Invalid account type");
            }
        }
        // invalid account
        throw new IllegalArgumentException("Invalid account");
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

    public void loadAccounts() throws IOException {
        if (dataFile.exists()) {
            List<BankAccount> accounts = objectMapper.readValue(dataFile, new TypeReference<>() {
            });
            accounts.forEach(account -> accountMap.put(account.getAccNo(), account));
        }
    }

    public void saveAccounts() {
        try {
            objectMapper.writeValue(dataFile, accountMap.values());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
