package org.example.Juan_David_Camacho.Homework_3;

import java.util.Map;
import java.util.Scanner;

public class OptionMenu {

    public static void displayMenu(Map<Integer, Plate> menu) {

        int option;

        do {

            System.out.println("/* Welcome to restaurant FastLane Feast */\n" +
                    "--------- Main Menu ---------\n" +
                    "1. View the menu\n" +
                    "2. Check the amount of recipes on the menu\n" +
                    "3. Add recipes to the menu\n" +
                    "4. Replace a current menu option\n" +
                    "5. Exit");

            Scanner input = new Scanner(System.in);
            option = input.nextInt();

            manageUserInput(option, menu);

        } while (option != 5);
    }

    private static void manageUserInput(int input, Map<Integer, Plate> menu) {

        switch (input) {
            case 1:

                viewMenu(menu);

                break;

            case 2:

                System.out.println("*/ The amount of recipes currently on the menu is: " + menu.size());

                break;

            case 3:

                addRecipes(menu);

                break;

            case 4:

                replaceRecipe(menu);

                break;

            case 5:

                System.out.println("Now exiting...");

                break;

            default:

                System.out.println("- You entered a number outsie of the menu, please try again");

                break;
        }

    }

    private static void viewMenu(Map<Integer, Plate> menu) {

        System.out.println("ID |  Name   | Price  |");

        for (Map.Entry<Integer, Plate> item : menu.entrySet()) {

            System.out.println(item.getKey() + " | " + item.getValue().returnItem());

        }

    }

    private static void addRecipes(Map<Integer, Plate> menu) {

        System.out.println("*/ Adding a recipe \n" +
                "*/ Please provide the name of the recipe:");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();

        System.out.println("*/ Now please provide its price:");
        double price = input.nextDouble();

        menu.put(menu.size() + 1, new Plate(name, price));

        System.out.println("+ Everything done! " + name + " has been added to the menu.");

    }

    private static void replaceRecipe(Map<Integer, Plate> menu) {

        System.out.println("*/ Replacing a recipe \n" +
                "*/ Please provide the ID of the recipe to be replaced:");
        Scanner input = new Scanner(System.in);
        int ID = input.nextInt();

        if (ID >= 0 && ID < menu.size()) {

            System.out.println("*/ Please provide the name of the item to replace " + menu.get(ID).getName() + ":");
            Scanner input1 = new Scanner(System.in);
            String name = input1.nextLine();

            System.out.println("*/ Now please provide its price:");
            double price = input1.nextDouble();

            menu.put(ID, new Plate(name, price));

            System.out.println("+ " + name + " has successfully been added to the menu.");

        } else {

            System.out.println("- We can't find the ID you provided please try again");

        }

    }

}
