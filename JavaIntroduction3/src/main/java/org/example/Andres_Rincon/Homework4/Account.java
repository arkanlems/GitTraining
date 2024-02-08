package org.example.Andres_Rincon.Homework4;

import java.util.Date;
import java.util.UUID;

public class Account {

    private final Client owner;
    private String accountNumber;
    private Date openingDate;
    private Double balance;

    public Account(Client owner) {
        this.owner = owner;
        this.accountNumber = generateRandomAccountNumber();
        this.openingDate = new Date();
        this.balance = 0.0;
    }

    private String generateRandomAccountNumber() {
        UUID uuid = UUID.randomUUID();
        long randomNumber = Math.abs(uuid.getMostSignificantBits() % 10_000_000_000L);
        return String.valueOf(randomNumber);
    }
    public void addMoney(Double amount) {
        if(amount > 0) {
            balance += amount;
            System.out.println("Money added.");
        }
        else {
            throw new RuntimeException("Amount must be more than zero.");
        }
    }

    public void withdraw(Double amount) {
        if(amount <= 0) {
            throw new RuntimeException("Amount must be positive.");
        }
        if(balance >= amount) {
            balance -= amount;
            System.out.println("Money withdrawn.");
        }
        else {
            throw new RuntimeException("Insufficient funds.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Date getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(Date openingDate) {
        this.openingDate = openingDate;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Client getOwner() {
        return owner;
    }


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                '}';
    }
}
