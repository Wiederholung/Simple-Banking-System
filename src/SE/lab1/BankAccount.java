package SE.lab1;

public class BankAccount {
    private final String accNo;
    private String accName;
    private double balance;
    private boolean isSuspended = false;

    public BankAccount(String accNo, String accName) {
        this.accNo = accNo;
        this.accName = accName;
        this.balance = 0.0;
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
        return "Account number: " + accNo + "\n" + "Account type: " + this.getClass().getSimpleName() + "\n" + "Account name: " + accName + "\n" + "Balance: " + balance;
    }

    protected void setBalance(double balance) {
        this.balance = balance;
    }

    public boolean isSuspended() {
        return isSuspended;
    }

    public void setSuspended(boolean suspended) {
        isSuspended = suspended;
    }
}