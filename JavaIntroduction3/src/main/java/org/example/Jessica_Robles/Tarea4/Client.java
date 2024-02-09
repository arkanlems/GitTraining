package org.example.Jessica_Robles.Tarea4;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private String username;
    private String password;
    private List<Account> accounts = new ArrayList<>();

    // Constructor
    public Client(String username, String password) {
        this.username = username;
        this.password = password;
        createAccount(0);
    }

    // Getters
    
    public String getusername() {
        return username;
    }

    public String getPassword() {
        return password;
    }


    // Add account
    public void createAccount(double initialAmount){
        this.accounts.add(new Account(initialAmount));
    }
    
    // Show info
    public void showInfo(){
        System.out.println("\nUsername: "+ username);
        System.out.println("Accounts: ");
        for (Account account: this.accounts){
            account.showInfo();
        }
    }
    
}
