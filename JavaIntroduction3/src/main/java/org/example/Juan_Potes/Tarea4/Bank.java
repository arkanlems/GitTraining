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

    }

    public void addClient(String userName, String password){

    }

    public Account generateAccount(Client client){

    }


    public void deleteClient(){

    }

    public int indexOf(int accountNumber){

    }

    public int indexOf(String userName){

    }

    public void showClientsInfo(){

    }

    // Getters and Setters
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
