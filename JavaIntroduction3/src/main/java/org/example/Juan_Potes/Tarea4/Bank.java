package org.example.Juan_Potes.Tarea4;

import org.example.Juan_Potes.Tarea3.Recipe;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients = new ArrayList<>();
    private static long freeAccNumber = 10;

    // Constructor
    public Bank(){}

    // Methods
    public void executeBankOptions(){
        int option = 0;
        while(option != 4){
            UserInput.showBankMenu();
            option = UserInput.scanInt("Type an option from the menu: ",1,4);

            switch(option){
                case 1:
                    showClientsInfo();
                    break;
                case 2:
                    addClient();
                    break;
                case 3:
                    deleteClient();
                    break;
                default:
                    break;
            }
        }
    }

    public void executeUserOptions(){

    }

    public void addClient(){
        String userName = UserInput.scanString("Please type the username of the new client:  ");
        String password = UserInput.scanString("Please type the password for the new client:  ");
        long accNumber = getFreeAccNumber();
        Date openingDate = UserInput.scanDate();
        double initialBalance = UserInput.scanMoney("Please type the initial balance for the client's account: ");

        addClient(userName,password,accNumber,openingDate,initialBalance);
    }

    public void addClient(String userName, String password, long accNumber ,Date openingDate, double initialBalance){
        Client newClient = new Client(userName, password);
        Account newAccount = new Account(newClient,accNumber,openingDate,initialBalance);

        newClient.setAccount(newAccount);

        this.clients.add(newClient);
    }

    public static long getFreeAccNumber(){
        freeAccNumber++;
        return freeAccNumber;
    }

    public Account generateAccount(Client client){
        return null;
    }


    public void deleteClient(){

    }

    public int indexOf(int accountNumber){
        return -1;
    }

    public int indexOf(String userName){
        return -1;
    }

    public void showClientsInfo(){
        if(this.clients.size() != 0){
            System.out.println("\n\tBANK CLIENTS");
            System.out.println(String.format("%-20s %-20s %-20s %-20s", "USERNAME", "ACCOUNT NUMBER", "OPENING DATE", "BALANCE"));
            for (Client c : this.clients){
                System.out.println(String.format("%-20s %-20s %-20s %-20s", c.getUserName(), c.getAccount().getAccNumber(), c.getAccount().getOpeningDate().getStringDate(), c.getAccount().getBalance()));
            }
        }
        else{
            showNoClientsMessage();
        }
    }

    public void showNoClientsMessage(){
        System.out.println("\nCurrently the list of clients is empty");
    }

    // Getters and Setters
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
