package org.example.Juan_Potes.Tarea3;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class UserInput {
    public static int optionMenu(){
        Scanner scan = new Scanner(System.in);
        int option = 0;
        boolean validInput = false;

        // Repeat until the user types a valid input
        while(!validInput){
            showOptions();
            System.out.print("\nPlease type the number of your choice from the options menu:  ");
            if (scan.hasNextInt()){
                option = scan.nextInt();
                if(option < 1 || option > 6){
                    System.out.println("\nINVALID VALUE. Try again (Write only integers values between 1 and 6)");
                }
                else{
                    validInput = true;
                }
            }
            else{
                System.out.println("\nINVALID VALUE. Try again (Write only integers values between 1 and 6)");
            }
        }
        return option;
    }

    public static void showOptions(){
        System.out.println("\n----------------------------------------------");
        System.out.println("|              SELECT AN OPTION                |");
        System.out.println("|  1. Add new recipe to the menu.              |");
        System.out.println("|  2. Delete a recipe from the menu.           |");
        System.out.println("|  3. Replace a recipe.                        |");
        System.out.println("|  4. Show the amount of recipes in the menu.  |");
        System.out.println("|  5. Show the restaurant menu.                |");
        System.out.println("|  6. Exit.                                    |");
        System.out.println("------------------------------------------------");
    }

    public static double scanPrice(String requestMessage){
        Scanner scan = new Scanner(System.in);

        double price = 0.0;

        boolean validInput = false;

        while(!validInput){
            System.out.print("\n" + requestMessage);

            if (scan.hasNextDouble()){
                price = scan.nextDouble();
                if(price > 0){
                    validInput = true;
                }
            }

            if(!validInput){
                System.out.println("\nINVALID VALUE. Try again (Write only positive numbers).");
            }
        }

        return price;
    }

    public static String scanName(String requestMessage){
        Scanner scan = new Scanner(System.in);
        Pattern pattern = Pattern.compile(".*[a-zA-Z]+.*");
        String name = "";
        Matcher matcher;
        boolean matches = false;

        while(!matches){
            System.out.print("\n" + requestMessage);
            name = scan.nextLine();

            matcher = pattern.matcher(name);

            matches = matcher.matches();

            if(!matches){
                System.out.println("\nINVALID VALUE. Try again (The name must contain at least one letter).");
            }
        }

        return name;
    }
}
