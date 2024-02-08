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

        userList.put(1, new Client("Juan", "123", new SavingsAccount(1, null, 55000)));
        userList.put(2, new Client("Pepe", "123", new SavingsAccount(2, null, 0)));

    }

}