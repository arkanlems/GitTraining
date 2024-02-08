package org.example.Andres_Rincon.Homework4;


public class Client {
    private String name;
    private String username;
    private String password;

    public Client(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", username='" + username + '\'' +
                '}';
    }


}
