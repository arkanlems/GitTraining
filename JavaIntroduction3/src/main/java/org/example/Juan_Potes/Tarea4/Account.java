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
}
