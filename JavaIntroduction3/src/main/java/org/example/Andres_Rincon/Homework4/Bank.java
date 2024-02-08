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
    private double taxRevenue;

    private final double AMOUNT_FOR_TAXING_THRESHOLD = 1000.0;
    private final double WITHDRAWAL_TAX = 200.0;
    private final double WITHDRAWAL_TAX_PERCENTAGE = 0.15;
    private final double TRANSFERRING_TAX = 100.0;

    public Bank(String name) {
        this.name = name;
        clients = new HashMap<>();
        accountsDirectoryPerUsername = new HashMap<>();
        accountsDirectoryPerAccountNumber = new HashMap<>();
        taxRevenue = 0.0;
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

    public void addMoney(String accountNumber, double amount) {
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

    public void withdraw(String accountNumber, double amount) {
        try {
            if(session != null) {
                Account account = getAccountChecked(session.getUsername(), accountNumber);
                account.withdrawalAmountChecked(amount); // check original amount firstly
                double finalAmount = getWithdrawalTaxesChecked(account, amount);
                if(finalAmount > 0) {
                    account.withdraw(finalAmount);
                }
            }
        }
        catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }

    private double getWithdrawalTaxesChecked(Account account, double amount) {
        double finalWithdrawalAmount;
        double taxAmount;
        if(amount < AMOUNT_FOR_TAXING_THRESHOLD) {
            taxAmount = WITHDRAWAL_TAX;
        }
        else {
            taxAmount =  WITHDRAWAL_TAX + (amount* WITHDRAWAL_TAX_PERCENTAGE);
        }
        finalWithdrawalAmount = amount + taxAmount;
        if(account.withdrawalAmountChecked(finalWithdrawalAmount)) {
            taxRevenue += taxAmount;
            return finalWithdrawalAmount;
        }
        else {
            return 0;
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

    public void transfer(String originAccountNumber, String receiverAccountNumber, double amount) {
        Account originAccount = accountsDirectoryPerAccountNumber.get(originAccountNumber);
        Account receiverAccount = accountsDirectoryPerAccountNumber.get(receiverAccountNumber);
        try {
            if(session != null) {
                originAccount.withdrawalAmountChecked(amount); // check original amount firstly
                double finalAmount = getTransferTaxesChecked(originAccount, amount);
                if(finalAmount > 0) {
                    originAccount.withdraw(finalAmount);
                    receiverAccount.addMoney(amount);
                }
            }
            System.out.println("Transferred with success.");
        }
        catch(RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private double getTransferTaxesChecked(Account account, double amount) {
        double finalTransferAmount = amount + TRANSFERRING_TAX;
        if(account.withdrawalAmountChecked(finalTransferAmount)) {
            taxRevenue += TRANSFERRING_TAX;
            return finalTransferAmount;
        }
        return finalTransferAmount;
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

    public Map<String, Account> getAccountsDirectoryPerAccountNumber() {
        return accountsDirectoryPerAccountNumber;
    }

    public double getTaxRevenue() {
        return taxRevenue;
    }
}
