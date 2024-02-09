package org.example.Jessica_Robles.Tarea4;

import java.time.LocalDateTime;

public class Account {
    
    // Atributes
    private long accountNumber;
    private LocalDateTime oppeningDate;
    private double balance;
    private static int numberOfAccounts = 0;

    // Constructor
    public Account(double balance) {
        numberOfAccounts ++;
        this.balance = balance;
        this.accountNumber = numberOfAccounts;
        this.oppeningDate = LocalDateTime.now();
    }

    // Show Info
    public void showInfo(){
        System.out.println("\tNumero de la cuenta: "+String.valueOf(accountNumber));
        System.out.println("\tBalance: "+String.valueOf(balance));
    }

}
