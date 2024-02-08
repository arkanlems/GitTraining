package org.example.Diego_Molina.HomeWork4;

import org.example.Diego_Molina.HomeWork3.Restaurant;
import org.example.Diego_Molina.HomeWork3.Utils;

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
                Restaurant.addRecipe();
                showOptions();
                break;
            }
            case 2:{
                Restaurant.replaceRecipeById();
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
