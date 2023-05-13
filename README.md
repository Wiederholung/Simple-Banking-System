# Bank Account Management System

This is a Java project that implements a basic bank account management system, allowing users to create accounts,
deposit and withdraw money, and manage their accounts.

## Features

- Multiple account types, including savings, CurrentAccount, and JuniorAccount
- Withdraw limit for CurrentAccount and JuniorAccount
- Ability to suspend or close accounts
- Withdrawals are logged
- Java unit tests for each account type and the Bank class

## Getting Started

### Prerequisites

- Java Development Kit (JDK) 8 or later
- Maven 3.2 or later

### Installation

1. Clone the repository `https://github.com/Wiederholung/CodeTest-Java.git`
2. `cd CodeTest-Java`
3. Compile `mvn compile`
4. Run unit tests `mvn test`

## Usage

You can create different types of accounts with varying properties and features. A sample code shows how to create an
account and perform some actions on it:

```
Bank bank = new Bank();
bank.openAccount(new CurrentAccount("001", Mary));
bank.deposit("001", 500.0);
bank.withdraw("001", 750.0);
bank.closeAccount("001");
```

This creates a new bank, opens a CurrentAccount with a name "Mary" and initial deposit of 0.0 and overdraft limit of
1500.0 (default). Deposit 500 to the account, withdraw 750 from the account using the account number "001", and then
close the account.

## Contributors

- [Yitong Hu](https://yitong-hu.metattri.com/)