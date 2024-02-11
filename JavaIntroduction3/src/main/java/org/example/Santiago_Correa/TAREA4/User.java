package org.example.Santiago_Correa.TAREA4;

public class User {
    private int accountNumber;
    private String password;
    private String user;

    public User(int accountNumber, String password, String user) {
        this.accountNumber = accountNumber;
        this.password = password;
        this.user = user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
