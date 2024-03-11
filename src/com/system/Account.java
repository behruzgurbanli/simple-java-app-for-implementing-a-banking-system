package com.system;

import java.math.BigDecimal;

public abstract class Account {
    private final String id;
    private BigDecimal balance;

    public Account() {
        this.id = Util.getRandomString();
        this.balance = BigDecimal.ZERO;
    }

    public Account(BigDecimal balance) {
        this.id = Util.getRandomString();
        this.balance = balance;
    }

    public String getId() {
        return this.id;
    }

    public BigDecimal getBalance() {
        return this.balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void deposit(BigDecimal amount) {
        if (amount.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Amount cannot be negative a value.");
        this.balance = this.balance.add(amount);
    }

    public abstract void withdraw(BigDecimal amount) throws IllegalArgumentException;

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", balance=" + balance +
                '}';
    }
}