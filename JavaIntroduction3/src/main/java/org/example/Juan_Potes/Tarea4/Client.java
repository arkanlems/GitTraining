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

    // Methods

    public void showAccountInfo(){
        System.out.println("Username: " + this.userName);
        System.out.println("Account number: " + this.account.getAccNumber());
        System.out.println("Account opening date: " + this.account.getOpeningDate().getStringDate());
        System.out.println("Account balance: " + this.account.getBalance());
    }

    public void widthdrawMoney(){

    }

    public void widthdrawMoney(double amount){

    }

    public void addMoney(){

    }

    public void addMoney(double amount){

    }

    public void transferMoney(long accountNumber, double amount){

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
