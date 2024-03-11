package com.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Customer {
    private final String id;
    private String fullName;
    private List<Account> accounts;

    public Customer(String fullName) {
        this.id = Util.getRandomString();
        this.fullName = fullName;
        this.accounts = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public List<Account> getAccounts() {
        return this.accounts;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) throws ObjectNotFoundException {
        if (!this.accounts.contains(account))
            throw new ObjectNotFoundException("Account not found.");
        this.accounts.remove(account);
    }

    public void removeAccount(String accountId) throws ObjectNotFoundException {
        boolean isRemoved = this.accounts.removeIf(account -> account.getId().equals(accountId));
        if (!isRemoved)
            throw new ObjectNotFoundException("Account with the specified ID (" + accountId + ") not found");
    }

    public BigDecimal getTotalBalance() {
        BigDecimal totalBalance = BigDecimal.ZERO;
        for (Account account: accounts) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    }

    public List<Account> getAccounts(String type) throws IllegalArgumentException {
        List<Account> listOfAccounts = new ArrayList<>();
        for (Account account: accounts) {
            if (type.equalsIgnoreCase("saving") && account instanceof SavingAccount)
                listOfAccounts.add(account);
            else if (type.equalsIgnoreCase("checking") && account instanceof CheckingAccount)
                listOfAccounts.add(account);
        }
        if (listOfAccounts.isEmpty())
            throw new IllegalArgumentException("Type not found.");
        return listOfAccounts;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}
