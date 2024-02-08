package org.example.homeworkSession4;

import java.util.Date;
import java.util.List;

public class Account {
    String number;
    Date openingDate;
    double balance;
    List<String> historical;

    public Account() {
    }

    public Account(String number, Date openingDate, double balance, List<String> historical) {
        this.number = number;
        this.openingDate = openingDate;
        this.balance = balance;
        this.historical = historical;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public List<String> getHistorical() {
        return historical;
    }

    public void setHistorical(List<String> historical) {
        this.historical = historical;
    }
}
