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

    // Getters
    public long getAccountNumber() {
        return accountNumber;
    }

    // Show Info
    public void showInfo(){
        System.out.println("\tNumero de la cuenta: "+String.valueOf(accountNumber));
        System.out.println("\tBalance: "+String.valueOf(balance));
        System.out.println();
    }

    // Withraw
    public boolean withraw(double quantity){
        double new_balance = this.balance - quantity - 200;

        if (quantity > 1000){
            new_balance -= (quantity*0.15);
        }

        if (new_balance >= 0){
            this.balance = new_balance;
            return true;
        }
        else{
            return false;
        }
    }


    // Add money
    public void addMoney(double quantity){
        this.balance += quantity;
    }

    // transfer to an Account
    public boolean transfer(double quantity, Account transferedAccount){
        double new_balance = this.balance - quantity - 100;
        if (new_balance >= 0){
            this.balance = new_balance;
            transferedAccount.addMoney(quantity);
            return true;
        }
        else{
            return false;
        }
    }

}
