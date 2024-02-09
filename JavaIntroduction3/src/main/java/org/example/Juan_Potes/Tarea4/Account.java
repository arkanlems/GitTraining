package org.example.Juan_Potes.Tarea4;

public class Account {
    private Client client;
    private long accNumber;
    private Date openingDate;
    private double balance;

    public Account(Client client, long accNumber, Date openingDate, double balance) {
        this.client = client;
        this.accNumber = accNumber;
        this.openingDate = openingDate;
        this.balance = balance;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public long getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(long accNumber) {
        this.accNumber = accNumber;
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
