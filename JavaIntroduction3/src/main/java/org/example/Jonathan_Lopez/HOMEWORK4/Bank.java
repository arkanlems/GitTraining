package org.example.Jonathan_Lopez.HOMEWORK4;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

class Bank {
    private List<Client> clients;

    public Bank() {
        clients = new ArrayList<>();
        clients.add(new Client("felipe", "123", new BankAccount("12345", new Date(), 5000.0)));
        clients.add(new Client("maria", "345", new BankAccount("67890", new Date(), 10000.0)));
    }

    public void printClients() {
        for (Client client : clients) {
            System.out.println(client.getUsername());
            System.out.println(client.getAccount());
            System.out.println(client.getAccount().getAccount_number());
            System.out.println(client.getAccount().getBalance());
        }
    }

    public void withdraw(String username, String password, double amount) {
        Client client = find_username(username);
        if (client != null && client.getPassword().equals(password)) {
            client.getAccount().withdraw(amount);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void deposit(String username, String password, double amount) {
        Client client = find_username(username);
        if (client != null && client.getPassword().equals(password)) {
            client.getAccount().deposit(amount);
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    public void transfer(String username, String password, String destination, double amount) {
        Client user = find_username(username);

        if (user != null && user.getPassword().equals(password)) {
            BankAccount toAccount = find_number(destination);
            if (toAccount != null) {
                user.getAccount().transfer(toAccount, amount);
            } else {
                System.out.println("This account doesn't exist.");
            }
        } else {
            System.out.println("Invalid username or password.");
        }
    }

    private Client find_username(String username) {
        for (Client client : clients) {
            if (client.getUsername().equals(username)) {
                return client;
            }
        }
        return null;
    }

    private BankAccount find_number(String account_number) {
        for (Client client : clients) {
            if (client.getAccount().getAccount_number().equals(account_number)) {
                return client.getAccount();
            }
        }
        return null;
    }

    public void createUser(){
        Scanner input=new Scanner(System.in);
        System.out.println("Please write your user name");
        String username= input.next();
        System.out.println("Please write your password");
        String password= input.next();
        System.out.println("We give you the possibilty to have your own number account, write it!");
        String accountnumber= input.next();
        clients.add(new Client(username, password, new BankAccount(accountnumber, new Date(), 0)));

    }
}
