package org.example.Maria_Paula_Gonzalez_Escallon.HW4;

public class Account {
    private int accountNumber;
    private String openingDate;
    private double balance;

    public Account(String openingDate, int accountNumber) {
        this.accountNumber = accountNumber;
        this.openingDate = openingDate;
        this.balance = 0;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getOpeningDate() {
        return openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void withdraw(double amount) {
        double tax = amount < 1000 ? 200 : 200 + 0.15 * amount;
        if ((amount + tax) < balance) {
            balance -= amount + tax;
        }
        else {
            System.out.println("Oops, looks like you don't have enough money to make the transaction.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
    }
}
