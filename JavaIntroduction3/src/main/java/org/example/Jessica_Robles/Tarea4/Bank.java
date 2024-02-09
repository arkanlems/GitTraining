package org.example.Jessica_Robles.Tarea4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.List;

public class Bank {

    // Atributes
    static String name = "Globant Bank";
    private Map<String,Client> users = new HashMap<>(); //<Username, Client>
    private List<String> users_names = new LinkedList<>();

    // constructor
    public Bank() {
        defaultUsers();
    }

    private void defaultUsers(){
        addUser("jessiRobles","password");
        addUser("rodrigoRobles","password");
        addUser("admin","admin");
    }

     // List all the users
    public void listUsers(){
        for (String user: this.users_names){
            this.users.get(user).showInfo();
        }
    }
    
    // Add user
    public boolean addUser(String user, String password){
        if (!users.containsKey(user)){
            users.put(user, new Client(user,password));
            // Poner en lista
            users_names.add(user);
            return true;
        }
        return false;
    }

    // Get user
    public Client getClient(String user){
        return users.get(user);
    }

    // User logIn
    public Client userLogIn(String username, String password){
        Client client = users.get(username);
        if (client != null){
            if (!client.getPassword().equals(password)){
                return null;
            }
        }
        return client;
    }

    // Register user
    
    
}
