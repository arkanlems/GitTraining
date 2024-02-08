package org.example.Andres_Rincon.Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String name;
    private Map<String, Client> clients;
    private Map<String, List<Account>> accountsDirectory;

    public Bank(String name) {
        this.name = name;
        clients = new HashMap<>();
        accountsDirectory = new HashMap<>();
    }

    public void addClient(String name, String username, String password) {
        if(getClient(username) == null) {
            clients.put(username, new Client(name, username, password));
            accountsDirectory.put(username, new ArrayList<>());
        }
        else {
            System.out.println("Username has already been taken");
        }
    }

    public void addNewAccount(String username) {
        accountsDirectory.get(username).add(new Account(getClient(username)));
    }

    public void addMoney(String username, String accountNumber, Double amount) {
        try {
            if(usernameChecked(username)) {
                Account account = getAccountChecked(username, accountNumber);
                account.addMoney(amount);
            }
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(String username, String password, String accountNumber, Double amount) {
        try {
            if(usernameChecked(username) && userCredentialsChecked(username, password)) {
                Account account = getAccountChecked(username, accountNumber);
                account.withdraw(amount);
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    private boolean usernameChecked(String username) {
        if(getClient(username) == null) {
            throw new RuntimeException("Non existent username");
        }
        return true;
    }

    private boolean userCredentialsChecked(String username, String password) {
        if(! getClient(username).getPassword().equals(password)) {
            throw new RuntimeException("Incorrect username or password.");
        }
        return true;
    }

    private Account getAccountChecked(String username, String accountNumber) {
        for(Account account : accountsDirectory.get(username)) {
            if(account.getAccountNumber().equals(accountNumber) && accountOwnerChecked(account, username)) {
                return account;
            }
        }
        throw new RuntimeException("Invalid account number entered.");
    }

    private boolean accountOwnerChecked(Account account, String username) {
        return account.getOwner().getUsername().equals(username);
    }


    public Client getClient(String username) {
        return clients.get(username);
    }

    public void printAllClients() {
        for(Map.Entry<String, Client> client : clients.entrySet()) {
            System.out.println(client.getValue());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Client> getClients() {
        return clients;
    }

    public void setClients(Map<String, Client> clients) {
        this.clients = clients;
    }

    public Map<String, List<Account>> getAccountsDirectory() {
        return accountsDirectory;
    }


}
