package org.example.Juan_David_Camacho.Homework_4;
import java.time.LocalDate;

public class SavingsAccount {

    private int number;
    private LocalDate openingDate;
    private double balance;

    public SavingsAccount(int number, double balance) {
        this.number = number;
        this.openingDate = java.time.LocalDate.now();
        this.balance = balance;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getOpeningDate() {
        return this.openingDate;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void addMoney(double moneyToAdd) {
        balance += moneyToAdd;
    }

    public void withdraw(double moneyToWithdraw) {
        balance -= moneyToWithdraw;
    }

}
