package org.example.Andres_Rincon.Homework4;

public class Session {
    private String username;
    private String password;
    private Client client;

    public Session(String username, String password, Client client) {
        this.client = client;
        if(userPasswordChecked(password)) {
            this.username = username;
            this.password = password;
        }
    }


    private boolean userPasswordChecked(String password) {
        if(! client.getPassword().equals(password)) {
            throw new RuntimeException("Incorrect password.");
        }
        return true;
    }

    public String getUsername() {
        return username;
    }
}
