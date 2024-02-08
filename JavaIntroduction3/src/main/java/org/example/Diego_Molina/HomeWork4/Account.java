package org.example.Diego_Molina.HomeWork4;

import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID uuid;
    private Date openingDate;
    private double  balance;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s %-15f %-15s\n", uuid.toString(), balance, openingDate.toString()));
        return sb.toString();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
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
}
