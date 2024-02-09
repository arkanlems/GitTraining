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

    public Account getAccount(int index){
        if (index < numberAccounts()){
            return accounts.get(index);
        }
        else{
            return null;
        }
    }


    // Add account
    public void createAccount(double initialAmount){
        this.accounts.add(new Account(initialAmount));
    }
    
    // Check if has account
    public Account hasAccount(long accountNumber){
        boolean found = false;
        short i = 0;
        Account account =  null;
        while ((i < accounts.size()) && (!found)){
            if (accounts.get(i).getAccountNumber() == accountNumber){
                account =  accounts.get(i);
            }
            i ++;
        }
        return account;
    }
    // Show info
    public void showInfo(){
        System.out.println("\nUsername: "+ username);
        System.out.println("Accounts: ");
        showAccountsInfo();
    }

    public void showAccountsInfo(){
        byte i = 1;
        for (Account account: this.accounts){
            System.out.print(String.valueOf(i)+".");
            account.showInfo();
            i ++;
        }
    }

    public int numberAccounts(){
        return accounts.size();
    }
    
}
