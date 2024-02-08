package org.example.Andres_Rincon.Homework4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private String name;
    private Map<String, Client> clients;
    private Map<String, List<Account>> accountsDirectoryPerUsername;
    private Map<String, Account> accountsDirectoryPerAccountNumber;
    private Session session;

    public Bank(String name) {
        this.name = name;
        clients = new HashMap<>();
        accountsDirectoryPerUsername = new HashMap<>();
        accountsDirectoryPerAccountNumber = new HashMap<>();
    }

    public void addClient(String name, String username, String password) {
        if(getClient(username) == null) {
            clients.put(username, new Client(name, username, password));
            accountsDirectoryPerUsername.put(username, new ArrayList<>());
        }
        else {
            System.out.println("Username has already been taken");
        }
    }

    public void addNewAccount(String username) {
        Account newAccount = new Account(getClient(username));
        accountsDirectoryPerUsername.get(username).add(newAccount);
        accountsDirectoryPerAccountNumber.put(newAccount.getAccountNumber(), newAccount);
    }

    public void startSession(String username, String password) {
        try {
            if(usernameChecked(username)) {
                session = new Session(username, password, getClient(username));
            }
        }
        catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean usernameChecked(String username) {
        if(getClient(username) == null) {
            throw new RuntimeException("Non existent username");
        }
        return true;
    }

    public void closeSession() {
        session = null;
    }

    public void addMoney(String accountNumber, Double amount) {
        try {
            if(session != null) {
                Account account = getAccountChecked(session.getUsername(), accountNumber);
                account.addMoney(amount);
            }
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(String accountNumber, Double amount) {
        try {
            if(session != null) {
                Account account = getAccountChecked(session.getUsername(), accountNumber);
                account.withdraw(amount);
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }


    private Account getAccountChecked(String username, String accountNumber) {
        for(Account account : accountsDirectoryPerUsername.get(username)) {
            if(account.getAccountNumber().equals(accountNumber) && accountOwnerChecked(account, username)) {
                return account;
            }
        }
        throw new RuntimeException("Invalid account number entered.");
    }

    private boolean accountOwnerChecked(Account account, String username) {
        return account.getOwner().getUsername().equals(username);
    }

    public void transfer(String originAccountNumber, String receiverAccountNumber, Double amount) {

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

    public Map<String, List<Account>> getAccountsDirectoryPerUsername() {
        return accountsDirectoryPerUsername;
    }


}
