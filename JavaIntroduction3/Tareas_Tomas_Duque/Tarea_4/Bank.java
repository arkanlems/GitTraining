package Dia_4.GitTraining.JavaIntroduction3.Tareas_Tomas_Duque.Tarea_4;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<Client> clients;

    public Bank(){
        this.clients = new ArrayList<>();
    }

    public void addClient(Client client){
        clients.add(client);
    }

    public void printClient(){
        for(Client c: clients){
            System.out.println("- " + c.getUsername() + " Contraseña: " + c.getPassword() + " Cuenta " + c.getAccount());
        }
    }
    public Client findClient(String username, String password){
        for (Client client : clients){
            if(client.getUsername().equals(username) && client.getPassword().equals(password)){
                return client;
            }
        }
        return null;
    }


}
