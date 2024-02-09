package org.example.Juan_Potes.Tarea4;

import org.example.Juan_Potes.Tarea3.Recipe;
import org.example.Juan_Potes.Tarea3.UserInput;

import java.util.ArrayList;
import java.util.List;

public class Bank {
    private List<Client> clients = new ArrayList<>();
    private static long freeAccNumber = 2501234;

    // Constructor
    public Bank(){}

    // Methods
    public void executeOptions(){

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

    // Getters and Setters
    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
