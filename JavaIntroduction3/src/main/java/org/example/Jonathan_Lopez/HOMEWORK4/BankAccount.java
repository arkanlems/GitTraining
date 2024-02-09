package org.example.Jonathan_Lopez.HOMEWORK4;
import java.util.Date;

class BankAccount {
    private String account_number;
    private Date openingDate;
    private double balance;

    public BankAccount(String accountNumber, Date openingDate, double balance) {
        this.account_number = accountNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) {

        final double Tax_less_1000 = 200.0;
        final double Tax_plus_1000 = 0.15;
        double tax = amount < 1000 ? Tax_less_1000 : Tax_less_1000 + (amount - 1000) * Tax_plus_1000;

        if (balance >= (amount + tax)) {
            balance -= (amount + tax);
            System.out.println("Withdrawal successful. Tax deducted: $" + tax);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println("Deposit done it.");
    }

    public void transfer(BankAccount toAccount, double amount) {
        final double transfer_tax = 100.0;
        if (balance >= (amount + transfer_tax)) {
            balance -= (amount + transfer_tax);
            toAccount.deposit(amount);
            System.out.println("Transfer successful. Tax deducted: $" + transfer_tax);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

}