package org.example.Diego_Molina.HomeWork4;
import java.time.LocalDate;
import java.util.*;

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

    public static void login(){
        String typedUserName;
        String typedPassword;
        boolean isLogin = false;

        System.out.println("Username");
        typedUserName = Utils.readString();

        System.out.println("Password");
        typedPassword = Utils.readString();

        Optional<Client> client = Optional.ofNullable(clients.get(typedUserName));

        if(client.isPresent()){
            if(Utils.verifyPassword(typedPassword, clients.get(typedUserName).getPassWord())){
                isLogin = true;
                Menu.showClientMenu(clients.get(typedUserName).getUuid());
            }
        }

        System.out.println("Wrong Credentials");
        Menu.showOptions();

    }

    public static void addMoney(UUID uuid){

    }

    public static void showStateAccount(UUID uuid){
        StringBuilder sb = new StringBuilder();;
        sb.append(String.format("%-45s %-10s %-15s", "UUID", "Balance", "Opening Date"));
        System.out.println("-----------------------------------------------------------");
        System.out.printf("%-45s %-10s %-15s%n", Bank.getAccounts().get(uuid).getUuid().toString(), Bank.getAccounts().get(uuid).getBalance(), Bank.getAccounts().get(uuid).getOpeningDate().toString());
        System.out.println("------------------------------------------------------------");

        Menu.showClientMenu(uuid);
    }

    public static void showClients(){

        StringBuilder sb = new StringBuilder();;
        //sb.append(String.format("%-25s %-10s %-15s", "UUID", "Balance", "Opening Date"));
        sb.append(String.format("%-40s %-10s", "UUID", "UserName"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(sb.toString());
        System.out.println("------------------------------------------------------------");

        for (Map.Entry<String, Client> entry : clients.entrySet()) {
            System.out.print(entry.getValue().toString());
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
