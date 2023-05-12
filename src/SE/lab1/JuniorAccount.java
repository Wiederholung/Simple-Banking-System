package SE.lab1;

public class JuniorAccount extends BankAccount {
    private int age;
    private double maxWithdraw = 100.0;
    private double amount;

    public JuniorAccount(String accNo, String accName, int age) {
        super(accNo, accName);
        this.age = age;
        this.loadAmount();
    }

    public boolean withdraw(double amount) {
        if (super.getBalance() >= amount && amount <= this.maxWithdraw - this.amount) {
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

    public double getMaxWithdraw() {
        return maxWithdraw;
    }

    protected void setMaxWithdraw(double maxWithdraw) {
        this.maxWithdraw = maxWithdraw;
    }

    public void loadAmount() {
        // 从jun_acc_log.csv中读取数据，读取的数据格式为：data,accNo,amount，例如：2019-01-01,123456,100.0。首先获取系统当前日期，找到data与当前日期相同且accNo与当前账户相同所在行，将amount赋值给this.amount
        this.amount = 0.0;
    }

    public void saveAmount() {
        // 将this.amount写入jun_acc_log.csv中，覆盖原有数据所在行
    }
}
