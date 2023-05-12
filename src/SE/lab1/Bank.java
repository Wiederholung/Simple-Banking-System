package SE.lab1;

public class Bank {
    private BankAccount[] accounts;
    private int numOfAccounts;

    public Bank() {
        this.accounts = new BankAccount[100];
        this.numOfAccounts = 0;
    }

    public void openAccount(BankAccount acc) {
        this.accounts[this.numOfAccounts] = acc;
        this.numOfAccounts++;
    }

    public int searchAccount(String accNo) {
        for (int i = 0; i < this.numOfAccounts; i++) {
            if (this.accounts[i].getAccNo().equals(accNo)) {
                return i;
            }
        }
        System.out.println("Account not found");
        return -1;
    }

    public Boolean closeAccount(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            this.accounts[index] = this.accounts[this.numOfAccounts - 1];
            this.accounts[this.numOfAccounts - 1] = null;
            this.numOfAccounts--;
            return true;
        }
        return false;
    }

    public Boolean deposit(String accNo, double amount) {
        int index = searchAccount(accNo);
        if (index != -1) {
            this.accounts[index].deposit(amount);
            return true;
        }
        return false;
    }

    public Boolean withdraw(String accNo, double amount) {
        int index = searchAccount(accNo);
        if (index != -1) {
            return this.accounts[index].withdraw(amount);
        }
        return false;
    }

    public double checkBalance(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            return this.accounts[index].getBalance();
        }
        return -1;
    }

    public void printAccount(String accNo) {
        int index = searchAccount(accNo);
        if (index != -1) {
            System.out.println(this.accounts[index]);
        }
    }

    public void printAccounts() {
        for (int i = 0; i < this.numOfAccounts; i++) {
            System.out.println(this.accounts[i]);
        }
    }

    public int getNumOfAccounts() {
        return numOfAccounts;
    }
}
