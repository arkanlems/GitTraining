package org.example.Andres_Rincon.Homework4;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank("Globant Bank");
        bank.addClient("John Doe", "johndoe", "password123");
        bank.addClient("Jane Smith", "janesmith", "password456");
        bank.addClient("Michael Johnson", "michaeljohnson", "password789");
        bank.addClient("Emily Davis", "emilydavis", "passwordabc");
        bank.addClient("David Brown", "davidbrown", "passwordxyz");

        bank.printAllClients();
        bank.addNewAccount("johndoe");
        String realAccountNumber = bank.getAccountsDirectoryPerUsername().get("johndoe").get(0).getAccountNumber();

        bank.startSession("johndoe", "password123");
        System.out.println("********** Adding money *********");
        bank.addMoney("12321321", 100.0);
        bank.addMoney( realAccountNumber, -100.0);
        bank.addMoney(realAccountNumber, 100.0);

        System.out.println("********** Withdrawing money *********");
        bank.withdraw("12345", 100.0);
        bank.withdraw(realAccountNumber, -100.0);
        bank.withdraw(realAccountNumber, 200.0);
        bank.withdraw(realAccountNumber, 50.0);


        System.out.println("********** Transferring money *********");
        bank.addNewAccount("janesmith");
        String otherAccountNumber = bank.getAccountsDirectoryPerUsername().get("janesmith").get(0).getAccountNumber();
        bank.transfer(realAccountNumber, otherAccountNumber, 50.0);
        bank.closeSession();


    }
}