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
    


}
