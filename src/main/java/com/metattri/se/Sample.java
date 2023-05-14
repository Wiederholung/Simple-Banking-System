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

       bank.openAccount(new CurrentAccount("your name"));

      bank.deposit("test", 500.0);
      bank.withdraw("test", 1000.0);
      System.out.println(bank.checkBalance("test"));

      bank.suspendAccount("test", true);
      assert !bank.deposit("test", 1000.0);
      bank.suspendAccount("test", false);

      String newAccNo = bank.changeAccountType("cc24d6ea-ca28-49da-b8d5-1b8b60376db4", "CurrentAccount");

      bank.closeAccount(newAccNo);

      bank.printAccounts();
   }
}