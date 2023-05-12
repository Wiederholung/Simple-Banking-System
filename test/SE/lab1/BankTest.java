package SE.lab1;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BankTest {
    Bank bank = new Bank();
    BankAccount acc1 = new BankAccount("001", "Tan Ah Kow");
    BankAccount acc2 = new CurrentAccount("002", "Kim Keng Lee");

    @org.junit.jupiter.api.Test
    void openAccount() {
        // 测试用例1：开通两个账户
        bank.openAccount(acc1);
        bank.openAccount(acc2);
    }

    @org.junit.jupiter.api.Test
    void searchAccount() {
        // 测试用例2：输入存在的账户号码，返回该账户在数组中的下标
        openAccount();
        assertEquals(0, bank.searchAccount("001"));
        assertEquals(1, bank.searchAccount("002"));
    }

    @org.junit.jupiter.api.Test
    void closeAccount() {
        // 测试用例3：关闭一个存在的账户，返回true，并查询该账户，返回 -1
        openAccount();
        assertEquals(true, bank.closeAccount("002"));
        assertEquals(-1, bank.searchAccount("002"));
        assertEquals(1, bank.getNumOfAccounts());
    }

    @org.junit.jupiter.api.Test
    void deposit() {
        openAccount();
        assertEquals(true, bank.deposit("001", 1000.0));
        assertEquals(1000.0, bank.checkBalance("001"));

        assertEquals(true, bank.deposit("002", 200.0));
        assertEquals(200.0, bank.checkBalance("002"));

        assertEquals(false, bank.deposit("003", 10000.0));
    }

    @org.junit.jupiter.api.Test
    void withdraw() {
        deposit();
        assertEquals(true, bank.withdraw("001", 500.0));
        assertEquals(500.0, bank.checkBalance("001"));

        assertEquals(false, bank.withdraw("001", 700.0));
        assertEquals(500.0, bank.checkBalance("001"));

        assertEquals(true, bank.withdraw("002", 700.0));
        assertEquals(-500.0, bank.checkBalance("002"));
    }

    @org.junit.jupiter.api.Test
    void checkBalance() {
        openAccount();
        assertEquals(0, bank.checkBalance("001"));
    }

    @org.junit.jupiter.api.Test
    void printAccount() {
        withdraw();
        bank.printAccount("001");
        bank.printAccount("002");
    }

    @org.junit.jupiter.api.Test
    void printAccounts() {
        deposit();
        bank.printAccounts();
    }
}