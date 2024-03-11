package com.system;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Banking {
    private List<Customer> customers;

    public Banking() {
        this.customers = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        this.customers.add(customer);
    }

    public void removeCustomer(Customer customer) throws ObjectNotFoundException {
        if (!this.customers.contains(customer))
            throw new ObjectNotFoundException("Customer not found.");
        this.customers.remove(customer);
    }

    public void removeCustomer(String customerId) throws ObjectNotFoundException {
        boolean isRemoved = this.customers.removeIf(customer -> customer.getId().equals(customerId));
        if (!isRemoved)
            throw new ObjectNotFoundException("Customer with the specified ID (" + customerId + ") not found");
    }

    public List<Customer> getCustomers() {
        return this.customers;
    }

    public Customer getCustomer(String customerId) throws ObjectNotFoundException {
        Customer specifiedCustomer = null;
        for (Customer customer: customers) {
            if (customer.getId().equals(customerId)) specifiedCustomer = customer;
        }
        if (specifiedCustomer == null)
            throw new ObjectNotFoundException("Customer with the specified ID (" + customerId + ") not found");
        return specifiedCustomer;
    }

    public void createCheckingAccount(Customer customer, BigDecimal balance, BigDecimal overDraftLimit) {
        customer.addAccount(new CheckingAccount(balance, overDraftLimit));
    }

    public void createSavingAccount(Customer customer, BigDecimal balance, BigDecimal interestRate) {
        customer.addAccount(new SavingAccount(balance, interestRate));
    }
}
