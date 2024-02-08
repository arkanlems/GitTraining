package org.example.Juan_Potes.Tarea4;

public class Client {
    private String name;
    private int id;
    private String userName;
    private String password;
    private Account account;

    // Constructors

    public Client(String name, int id, String userName, String password) {
        this.name = name;
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    // Getters and Setters

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
