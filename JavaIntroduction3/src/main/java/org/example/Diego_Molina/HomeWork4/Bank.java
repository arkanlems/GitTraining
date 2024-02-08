package org.example.Diego_Molina.HomeWork4;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
public class Bank {
    private static String nameBank;
    private static ArrayList<Client> clientList;

    private static Map<String, Client> clients = new HashMap<>();
    private static Map<UUID, Account> accounts = new HashMap<>();

    public static void AddClient(){
        Client newClient = new Client();
        Account newAccount = new Account();

        System.out.println("-----------------------------------------------------------");
        System.out.println("                      New Client                           ");
        System.out.println("-----------------------------------------------------------");

        System.out.println("Username");
        newClient.setUserName(Utils.readString());

        System.out.println("Password");
        newClient.setPassWord(Utils.hashPassword(Utils.readString()));

        newClient.setUuid(UUID.randomUUID());

        newAccount.setUuid(newClient.getUuid());
        newAccount.setBalance(0);
        newAccount.setOpeningDate(LocalDate.now());

        clients.put(newClient.getUserName(), newClient);
        accounts.put(newClient.getUuid(), newAccount);

    }
    public static void showClients(){

        StringBuilder sb = new StringBuilder();;
        //sb.append(String.format("%-25s %-10s %-15s", "UUID", "Balance", "Opening Date"));
        sb.append(String.format("%-40s %-10s", "UUID", "User Name"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(sb.toString());
        System.out.println("------------------------------------------------------------");

        for (Map.Entry<String, Client> entry : clients.entrySet()) {
            System.out.println(entry.getValue().toString());
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
    public static Map<String, Client> getClients() {
        return clients;
    }

    public static void setClients(Map<String, Client> clients) {
        Bank.clients = clients;
    }
}
