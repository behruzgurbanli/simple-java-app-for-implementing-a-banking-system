package com.system;

import java.math.BigDecimal;

public class CheckingAccount extends Account {
    private BigDecimal overDraftLimit;

    public CheckingAccount(BigDecimal overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    public CheckingAccount(BigDecimal balance, BigDecimal overDraftLimit) {
        super(balance);
        this.overDraftLimit = overDraftLimit;
    }

    public BigDecimal getOverDraftLimit() {
        return this.overDraftLimit;
    }

    public void setOverDraftLimit(BigDecimal overDraftLimit) {
        this.overDraftLimit = overDraftLimit;
    }

    @Override
    public void withdraw(BigDecimal amount) {
        if (amount.compareTo(getBalance().add(overDraftLimit)) > 0)
            throw new IllegalArgumentException("Withdrawn amount cannot be more than overdraft limit.");
        else if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdrawn value is not valid");
        setBalance(getBalance().subtract(amount));
    }

    @Override
    public String toString() {
        return "CheckingAccount{" +
                "overDraftLimit=" + overDraftLimit +
                "} " + super.toString();
    }
}
