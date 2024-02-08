package org.example.Juan_David_Camacho.Homework_4;
import java.util.Date;

public class SavingsAccount {

    private int number;
    private Date openingDate;
    private double balance;

    public SavingsAccount(int number, Date openingDate, double balance) {
        this.number = number;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public int getNumber() {
        return this.number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getOpeningDate() {
        return this.openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
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
