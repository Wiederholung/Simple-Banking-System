# Bank Account Management System

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

1. Clone the repository

   ```shell
   git clone https://github.com/Wiederholung/Simple-Banking-System.git
   ```

2. Navigate to the directory where you downloaded the repository

   ```shell
   cd Simple-Banking-System
   ```

   Optional: open the project in IDEA

3. Compile `mvn compile`
4. Run unit tests `mvn test`

## Usage

You can create different types of accounts with varying properties and features. A sample code shows how to create an
account and perform some actions on it:

```java
package com.metattri.se;

public class Sample {
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.openAccount(new CurrentAccount("001", Mary));
        bank.deposit("001", 500.0);
        bank.withdraw("001", 750.0);
        bank.closeAccount("001");
    }
}
```

## Contributors

- [Yitong Hu](https://yitong-hu.metattri.com/)
