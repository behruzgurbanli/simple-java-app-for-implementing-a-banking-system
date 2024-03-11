package com.system;

import java.math.BigDecimal;

public class BankingDemo {
    public static void main(String[] args) {
        // Creating several CheckingAccount objects

        System.out.println("\n\n  *** CheckingAccount Class ***   \n\n");

        CheckingAccount checkingAccount1 = new CheckingAccount(BigDecimal.valueOf(200));
        CheckingAccount checkingAccount2 = new CheckingAccount(BigDecimal.valueOf(355), BigDecimal.valueOf(200));
        CheckingAccount checkingAccount3 = new CheckingAccount(BigDecimal.valueOf(200), BigDecimal.valueOf(600));

        // Checking methods of CheckingAccount class
        System.out.println("Checking Account 1 ID: " + checkingAccount1.getId());
        System.out.println("Checking Account 1 Balance: " + checkingAccount1.getBalance());
        System.out.println("Checking Account 1 Overdraft limit: " + checkingAccount1.getOverDraftLimit());
        System.out.println("Checking Account 1:\n" + checkingAccount1.toString());

        try {checkingAccount2.withdraw(BigDecimal.valueOf(250));}
        catch (IllegalArgumentException e) {System.err.println(e.toString());}

        try {checkingAccount2.deposit(BigDecimal.valueOf(-200));}
        catch (IllegalArgumentException e) {System.err.println(e.toString());}



        // Creating several SavingAccount objects

        System.out.println("\n\n  *** SavingAccount Class ***   \n\n");

        SavingAccount savingAccount1 = new SavingAccount(BigDecimal.valueOf(800));
        SavingAccount savingAccount2 = new SavingAccount(BigDecimal.valueOf(400), BigDecimal.valueOf(450));
        SavingAccount savingAccount3 = new SavingAccount(BigDecimal.valueOf(800), BigDecimal.valueOf(900));

        // Checking methods of SavingAccount class
        System.out.println("Saving Account 1 ID: " + savingAccount1.getId());
        System.out.println("Saving Account 1 Balance: " + savingAccount1.getBalance());
        System.out.println("Saving Account 1 Interest Rate: " + savingAccount1.getInterestRate());
        System.out.println("Saving Account 1:\n" + savingAccount1.toString());

        try {savingAccount2.withdraw(BigDecimal.valueOf(250));}
        catch (IllegalArgumentException e) {System.err.println(e.toString());}

        try {savingAccount2.deposit(BigDecimal.valueOf(200));}
        catch (IllegalArgumentException e) {System.err.println(e.toString());}

        // Creating Customer object

        System.out.println("\n\n  *** Customer Class ***   \n\n");

        Customer customer = new Customer("Bahruz Gurbanli");
        customer.addAccount(checkingAccount1);
        customer.addAccount(savingAccount2);
        customer.addAccount(checkingAccount3);


        // Checking methods of Customer class
        System.out.println("Customer ID: " + customer.getId());
        System.out.println("Customer Accounts: " + customer.getAccounts());
        System.out.println("Customer Accounts of Type Saving Account: " + customer.getAccounts("saving"));
        System.out.println("Customer Accounts of Type Checking Account: " + customer.getAccounts("checking"));
        System.out.println("Customer Full Name: " + customer.getFullName());
        System.out.println("Customer Total Balance: " + customer.getTotalBalance());
        System.out.println("Customer:\n" + customer.toString());
        customer.addAccount(savingAccount1);


        try {customer.removeAccount(savingAccount3);}
        catch (ObjectNotFoundException e) {System.err.println(e.toString());}

        try {customer.removeAccount(savingAccount3.getId());}
        catch (ObjectNotFoundException e) {System.err.println(e.toString());}



        // Starting Banking class

        System.out.println("\n\n  *** Banking Class ***   \n\n");

        Banking banking = new Banking();

        // Checking methods of Banking class
        banking.addCustomer(customer);
        System.out.println(banking.getCustomers());
        System.out.println(banking.toString());

        try {banking.removeCustomer(customer);}
        catch (ObjectNotFoundException e) {System.err.println(e.toString());}

        try {banking.removeCustomer(customer.getId());}
        catch (ObjectNotFoundException e) {System.err.println(e.toString());}

        try {System.out.println(banking.getCustomer(customer.getId()));}
        catch (ObjectNotFoundException e) {System.err.println(e.toString());}

        banking.createCheckingAccount(customer, BigDecimal.ZERO, BigDecimal.valueOf(200));
        banking.createSavingAccount(customer, BigDecimal.valueOf(100), BigDecimal.valueOf(350));

        /* ----------------------------------------------------------------- */
        System.out.println("End of code needed to be executed");
        /* ----------------------------------------------------------------- */
    }
}
