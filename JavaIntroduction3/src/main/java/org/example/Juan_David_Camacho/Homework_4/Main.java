package org.example.Juan_David_Camacho.Homework_4;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws Exception {

        Map<Integer, Client> userList = new HashMap<Integer, Client>();
        populateUserList(userList);
        Menu.mainMenu(userList);
    }

    private static void populateUserList(Map<Integer, Client> userList) {

        userList.put(1, new Client("Juan", "123", new SavingsAccount(1, 55000)));
        userList.put(2, new Client("Pepe", "123", new SavingsAccount(2, 0)));
        userList.put(3, new Client("Sergio", "123", new SavingsAccount(3, 0)));
        userList.put(4, new Client("Rodrigo12", "123", new SavingsAccount(4, 0)));
        userList.put(5, new Client("Rafa", "123", new SavingsAccount(5, 0)));
        userList.put(6, new Client("Teo33", "123", new SavingsAccount(6, 55000)));
        userList.put(7, new Client("Brandon_", "123", new SavingsAccount(7, 0)));
        userList.put(8, new Client("Cristian", "123", new SavingsAccount(8, 0)));
        userList.put(9, new Client("xDavidx", "123", new SavingsAccount(9, 0)));
        userList.put(10, new Client("Miguel07", "123", new SavingsAccount(10, 0)));
        userList.put(11, new Client("Alvaro", "123", new SavingsAccount(11, 55000)));
        userList.put(12, new Client("Diego", "123", new SavingsAccount(12, 0)));
        userList.put(13, new Client("Jh0n", "123", new SavingsAccount(13, 0)));
        userList.put(14, new Client("Oscar", "123", new SavingsAccount(14, 0)));
        userList.put(15, new Client("Sebastian", "123", new SavingsAccount(15, 0)));
        userList.put(16, new Client("Carlos", "123", new SavingsAccount(16, 55000)));
        userList.put(17, new Client("Alejandro", "123", new SavingsAccount(17, 0)));
        userList.put(18, new Client("Alex48", "123", new SavingsAccount(18, 0)));
        userList.put(19, new Client("Valentina", "123", new SavingsAccount(19, 0)));
        userList.put(20, new Client("Laura", "123", new SavingsAccount(20, 0)));
        userList.put(21, new Client("Maria_Paula", "123", new SavingsAccount(21, 0)));
        userList.put(22, new Client("Nicolle", "123", new SavingsAccount(22, 0)));
        userList.put(23, new Client("Susana", "123", new SavingsAccount(23, 0)));
        userList.put(24, new Client("Mariana4", "123", new SavingsAccount(24, 0)));
        userList.put(25, new Client("Paula", "123", new SavingsAccount(25, 0)));

    }

}