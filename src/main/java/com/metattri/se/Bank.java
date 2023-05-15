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
    private static final String CURRENT_ACCOUNT_TYPE = "CurrentAccount";
    private static final String BANK_ACCOUNT_TYPE = "BankAccount";
    private static final String JUNIOR_ACCOUNT_TYPE = "JuniorAccount";


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

    public String changeAccountType(String accNo, String tgtType) throws IllegalArgumentException {
        if (!isValid(accNo)) {
            throw new IllegalArgumentException("Invalid account");
        }

        BankAccount currAccount = accountMap.get(accNo);
        String currType = currAccount.getType();

        if (currType.equals(tgtType)) {
            throw new IllegalArgumentException("Account type is already " + tgtType);
        }

        switch (currType) {
            case CURRENT_ACCOUNT_TYPE -> {
                return handleCurrentAccount(currAccount, tgtType);
            }
            case BANK_ACCOUNT_TYPE -> {
                return handleBankAccount(currAccount, tgtType);
            }
            case JUNIOR_ACCOUNT_TYPE -> {
                return handleJuniorAccount((JuniorAccount) currAccount, tgtType);
            }
            default -> {
                System.out.println("Invalid account type");
                throw new IllegalArgumentException("Invalid account type");
            }
        }
    }

    private String handleCurrentAccount(BankAccount currAccount, String tgtType) throws IllegalArgumentException {
        if (currAccount.getBalance() < 0) {
            throw new IllegalArgumentException("Account balance is negative");
        }

        if (tgtType.equals(BANK_ACCOUNT_TYPE)) {
            String newAccNo = openAccount(currAccount.getAccName(), tgtType);
            deposit(newAccNo, currAccount.getBalance());
            closeAccount(currAccount.getAccNo());
            return newAccNo;
        } else {
            throw new IllegalArgumentException("Invalid target account type");
        }
    }

    private String handleBankAccount(BankAccount currAccount, String tgtType) throws IllegalArgumentException {
        if (!tgtType.equals(CURRENT_ACCOUNT_TYPE)) {
            throw new IllegalArgumentException("Invalid target account type");
        }

        String newAccNo = openAccount(currAccount.getAccName(), tgtType);
        deposit(newAccNo, currAccount.getBalance());
        closeAccount(currAccount.getAccNo());
        return newAccNo;
    }

    private String handleJuniorAccount(JuniorAccount currAccount, String tgtType) throws IllegalArgumentException {
        if (tgtType.equals(CURRENT_ACCOUNT_TYPE) || tgtType.equals(BANK_ACCOUNT_TYPE)) {
            if (currAccount.getAge() < 16) {
                throw new IllegalArgumentException("Account holder is under 16");
            }

            String newAccNo = openAccount(currAccount.getAccName(), tgtType);
            deposit(newAccNo, currAccount.getBalance());
            closeAccount(currAccount.getAccNo());
            return newAccNo;
        } else {
            throw new IllegalArgumentException("Invalid target account type");
        }
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
