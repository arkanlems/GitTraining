package org.example.Diego_Molina.HomeWork4;
import java.util.ArrayList;
import java.util.Map;
import java.util.UUID;
public class Bank {
    private static String nameBank;
    private static ArrayList<Client> clientList;
    private static Map<UUID, Account> accounts;

    public static void showClients(){
        for(Client client : clientList){
            System.out.println(client.toString());
        }
    }
    public static String getNameBank() {
        return nameBank;
    }

    public static void setNameBank(String nameBank) {
        Bank.nameBank = nameBank;
    }

    public static ArrayList<Client> getClientList() {
        return clientList;
    }

    public static void setClientList(ArrayList<Client> clientList) {
        Bank.clientList = clientList;
    }

    public static Map<UUID, Account> getAccounts() {
        return accounts;
    }

    public static void setAccounts(Map<UUID, Account> accounts) {
        Bank.accounts = accounts;
    }
}
