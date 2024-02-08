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

    public void createNewAccount(String username) {
        accountsDirectory.get(username).add(new Account(getClient(username)));
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
