package org.example.Juan_Potes.Tarea4;

public class Client {
    private String userName;
    private String password;
    private Account account;

    // Constructors

    public Client(String userName, String password) {
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
