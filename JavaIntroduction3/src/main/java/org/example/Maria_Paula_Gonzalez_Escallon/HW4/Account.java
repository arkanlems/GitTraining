package org.example.Maria_Paula_Gonzalez_Escallon.HW4;

public class Account {
    private Long accountNumber;
    private String openingDate;
    private double balance;

    public Account(String openingDate, Long accountNumber) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = 0;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }
}
