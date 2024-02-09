package org.example.Jonathan_Lopez.HOMEWORK4;

class Client {
    private String username;
    private String password;
    private BankAccount account;

    public Client(String username, String password, BankAccount account) {
        this.username = username;
        this.password = password;
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public BankAccount getAccount() {
        return account;
    }
}