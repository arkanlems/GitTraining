package org.example.Juan_David_Camacho.Homework_4;
public class Client {

    private String user;
    private String pwd;
    private SavingsAccount account;

    public Client(String user, String pwd, SavingsAccount account) {
        this.user = user;
        this.pwd = pwd;
        this.account = account;
    }

    public String getUser() {
        return this.user;
    }

    public void setUser(String name) {
        this.user = name;
    }

    public String getPwd() {
        return this.pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public SavingsAccount getAccount() {
        return this.account;
    }

    public void setAccount(SavingsAccount account) {
        this.account = account;
    }

}
