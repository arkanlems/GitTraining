package org.example.Santiago_Correa.TAREA4;

public class Account {

    private int accountNumber;

    private User user;

    private Double balance = 1000.0;

    public Account(int accountNumber, User user) {
        this.accountNumber = accountNumber;
        this.user = user;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public User getUser() {
        return user;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void deposit(Double amount) {
        balance += amount;
        System.out.println("Deposit successfully New balance is" + " " + balance);
    }

    //withdrrawals tax is 200 for amounts less than 1000. withdrawal of more 1000 tax is 200 plus 15 dfo the amount to withdraw
    //the code is:
    public void withdraw(Double amount) {
        if (amount < 1000) {
            balance -= amount + 200;
            System.out.println("Withdrawal successfully New balance is" + " " + balance);
            return;
        }
        balance -= amount*0.15 + 200;
        System.out.println("Withdrawal successfully New balance is" + " " + balance);
    }

    public void transfer(Double amount, int accountNumber, Bank bank) {
        for (Account account : bank.listAccounts) {
            if (account.getAccountNumber() == accountNumber) {
                account.deposit(amount);
                this.balance -= 100;
                balance -= amount;
                System.out.println("Transfer successfully New balance is" + " " + balance);
                return;
            }

        }
    }

    //login method
    //if the account number and password are correct, return the account
    public Account login(int accountNumber, String password, Bank bank){
        for (Account account : bank.listAccounts) {
            if (account.getAccountNumber() == accountNumber && account.getUser().getPassword().equals(password)) {
                return account;
            }
        }
        return null;
    }

}
