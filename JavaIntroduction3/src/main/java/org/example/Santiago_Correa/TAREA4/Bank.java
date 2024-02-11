package org.example.Santiago_Correa.TAREA4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> listAccounts= new ArrayList<>();

    public void displayAllUsers(){
        for (Account account : listAccounts) {
            System.out.println(account.getUser().getUser());
        }
    }

    public Account login(int accountNumber, String password){
        for (Account account : listAccounts) {
            if (account.getAccountNumber() == accountNumber && account.getUser().getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

    public void registerAccount(User user){
        listAccounts.add(new Account(listAccounts.size()+1, user));
    }
}
