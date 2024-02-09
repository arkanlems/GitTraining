package org.example.Diego_Molina.HomeWork4;
import java.util.UUID;

public class Menu {

    private Bank bank = new Bank();
    public static void showClientMenu(UUID uuid){
        System.out.println("---------------------Welcome To GloBank--------------");
        System.out.println("1. Add Money");
        System.out.println("2. Transfer Money");
        System.out.println("3. State Account");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------------");

        System.out.print("Input: ");
        int option = Utils.readInteger();

        switch (option){
            case 1:{
                Bank.addMoney(uuid);
                Menu.showClientMenu(uuid);
                break;
            }
            case 3:{
                Bank.showStateAccount(uuid);
                break;
            } case 4:{
                Menu.showOptions();
                break;
            }
        }
    }
    public static void showOptions(){
        System.out.println("---------------------Welcome To GloBank--------------");
        System.out.println("1. Add Client");
        System.out.println("2. Login Like Client");
        System.out.println("3. Show Clients");
        System.out.println("4. Exit");
        System.out.println("-------------------------------------------------------");

        System.out.print("Input: ");
        int option = Utils.readInteger();

        switch (option){
            case 1:{
                Bank.AddClient();
                Menu.showOptions();
                break;
            }
            case 2:{
                Bank.login();
                break;
            }
            case 3: {
                Bank.showClients();
                showOptions();
            }
            case 4:{
                System.exit(0);
                break;
            }
            default:{
                System.out.println("Please Enter A Valid Option");
                showOptions();
            }
        }
    }
}
