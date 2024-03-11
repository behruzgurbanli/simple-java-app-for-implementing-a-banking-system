package com.system;

import java.math.BigDecimal;

public class SavingAccount extends Account {
    private BigDecimal interestRate;

    public SavingAccount(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(BigDecimal balance, BigDecimal interestRate) {
        super(balance);
        this.interestRate = interestRate;
    }

    public BigDecimal getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(getBalance()) > 0)
            throw new IllegalArgumentException("Withdrawn amount cannot be more than balance.");
        else if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdrawn value is not valid");
        setBalance(getBalance().subtract(amount));
    }

    @Override
    public String toString() {
        return "SavingAccount{" +
                "interestRate=" + interestRate +
                "} " + super.toString();
    }
}
