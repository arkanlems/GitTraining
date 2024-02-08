package org.example.Diego_Molina.HomeWork4;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

public class Account {
    private UUID uuid;
    private LocalDate openingDate;
    private double  balance;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-25s %-10f %-15s\n", uuid.toString(), balance, openingDate.toString()));
        return sb.toString();
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDate openingDate) {
        this.openingDate = openingDate;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}
