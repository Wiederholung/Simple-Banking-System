package SE.lab1;

import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void openAccount(BankAccount acc) {
        this.accounts.add(acc);
    }

    public int searchAccount(String accNo) {
        for (BankAccount account : this.accounts) {
            if (account.getAccNo().equals(accNo)) {
                return this.accounts.indexOf(account);
            }
        }
        System.out.println("Account not found");
        return -1;
    }

    public Boolean closeAccount(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            this.accounts.remove(index);
            return true;
        }
        return false;
    }

    public Boolean deposit(String accNo, double amount) {
        int index = searchAccount(accNo);
        if (index != -1) {
            this.accounts.get(index).deposit(amount);
            return true;
        }
        return false;
    }

    public Boolean withdraw(String accNo, double amount) {
        int index = searchAccount(accNo);
        if (index != -1) {
            return this.accounts.get(index).withdraw(amount);
        }
        return false;
    }

    public double checkBalance(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            return this.accounts.get(index).getBalance();
        }
        return -1;
    }

    public void printAccount(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            System.out.println(this.accounts.get(index));
        }
    }

    public void printAccounts() {
        for (BankAccount account : this.accounts) {
            System.out.println(account);
        }
    }

    public int getNumOfAccounts() {
        return this.accounts.size();
    }
}
