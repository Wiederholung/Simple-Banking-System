# Simple Banking System

This is a Java project that implements a basic bank account management system, allowing users to create accounts,
deposit and withdraw money, and manage their accounts.

## Features

- Multiple account types, including savings, CurrentAccount, and JuniorAccount
- Withdraw policy for CurrentAccount and JuniorAccount
- Ability to suspend and close accounts
- Java unit tests for each account type and the Bank class
- Data persistence using JSON (v1)
- Ability to change the type of account (v2)
- Fast lookup enabled by HashMap (v3)

## Getting Started

### Prerequisites

- [IntelliJ IDEA](https://www.jetbrains.com/idea/) (_recommended_)
- Java Development Kit (JDK) 8 or later
- Maven 3.2 or later

### Installation

1. Clone the repository:

   ```shell
   git clone https://github.com/Wiederholung/Simple-Banking-System.git
   ```

2. Navigate to the directory where you downloaded the repository:

   ```shell
   cd Simple-Banking-System
   ```

   Optional: open the project in IDEA

3. Compile: `mvn compile`
4. Run unit tests: `mvn test`

## Usage

You can create different types of accounts with varying properties and features. A sample code shows how to create an
account and perform some actions on it:

```java
package com.metattri.se;

import java.io.IOException;

public class Sample {
    public static void main(String[] args) {
        Bank bank;
        try {
            bank = new Bank();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("new account number: " + bank.openAccount(new CurrentAccount("your name")));

        bank.deposit("test", 500.0);
        bank.withdraw("test", 1000.0);
        System.out.println(bank.checkBalance("test"));

        bank.suspendAccount("test", true);
        assert !bank.deposit("test", 1000.0);
        bank.suspendAccount("test", false);

        String newAccNo = bank.changeAccountType("test", "CurrentAccount");
        System.out.println("new account number: " + newAccNo);

        bank.closeAccount(newAccNo);

        bank.printAccounts();
    }
}
```

Note

1. See more usage in the [JUnit tests](src/test/java/com/metattri/se).

2. The account number is a UUID, which is a random string. You can look up the account number via:
    - `bank.printAccounts();`
    - `String accNo = bank.openAccount(new BankAccount("your name"));`
    - [accounts.json](src/main/resources/accounts.json)

3. The database file [accounts.json](src/main/resources/accounts.json) is stored in the directory `src/main/resources`,
   which is the default directory for resources in Maven. You can change the directory in
   the [Bank.java](src/main/java/com/metattri/se/Bank.java) file.

4. After running the [JUnit tests](src/test/java/com/metattri/se)
   or [Sample.java](src/main/java/com/metattri/se/Sample.java), you can check the database file to see the changes.

5. Remember to **[rollback](https://git-scm.com/docs/git-revert)** the changes in
   the [accounts.json](src/main/resources/accounts.json) if you want to run the
   tests again.

## Contributor

- [Yitong Hu](https://yitong-hu.metattri.com/)
