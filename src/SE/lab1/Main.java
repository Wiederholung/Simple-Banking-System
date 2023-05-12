package SE.lab1;

public class Main {
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount("001", "Tan Ah Kow");
        CurrentAccount acc3 = new CurrentAccount("003", "Janice", 1000.0);
        acc1.deposit(1000.0);
        acc3.deposit(3000.0);
        acc1.withdraw(2500.0);
        acc3.withdraw(4000.0);
        System.out.println(acc1);
        System.out.println(acc3);
    }
}
