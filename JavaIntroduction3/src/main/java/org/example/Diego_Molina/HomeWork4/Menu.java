package org.example.Diego_Molina.HomeWork4;

public class Menu {
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
                showOptions();
                break;
            }
            case 2:{
                showOptions();
                break;
            }
            case 3: {
                Bank.showClients();
                showOptions();
            }
            case 4:{
                break;
            }
            default:{
                System.out.println("Please Enter A Valid Option");
                showOptions();
            }
        }
    }
}
