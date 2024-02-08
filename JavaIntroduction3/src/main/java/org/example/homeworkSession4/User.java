package org.example.homeworkSession4;

public class User {
    String userId;
    String name;
    String password;
    Account account;

    public User() {
    }

    public User(String userId, String name, String password, Account account) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.account = account;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
