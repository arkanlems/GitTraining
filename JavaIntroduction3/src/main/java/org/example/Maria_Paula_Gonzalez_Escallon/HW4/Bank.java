package org.example.Maria_Paula_Gonzalez_Escallon.HW4;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<User> users;

    public Bank() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void printAllUsers() {
        System.out.println("****************************************");
        for (User user : users) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Account Number: " + user.getAccount().getAccountNumber());
            System.out.println("Balance: " + user.getAccount().getBalance());
            System.out.println("Opening Date: " + user.getAccount().getOpeningDate());
            System.out.println();
        }
        System.out.println("****************************************");
    }

}
