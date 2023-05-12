package SE.lab1;

public class CurrentAccount extends BankAccount {
    private double overdraftLimit = 500.0;

    public CurrentAccount(String accNo, String accName) {
        super(accNo, accName);
    }

    public CurrentAccount(String accNo, String accName, double odLimit) {
        super(accNo, accName);
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
