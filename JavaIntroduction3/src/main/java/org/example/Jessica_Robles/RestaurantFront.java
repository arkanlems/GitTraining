package org.example.Jessica_Robles;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RestaurantFront {

    // Scanner used to read user input
    private static final Scanner scan = new Scanner(System.in);

    private static Restaurant restaurant;

    // Main menu
    public static void mainMenu(){
        String option = "";
        while (!option.equals("0")){
            System.out.println("\nMENU PRINCIPAL\n");

            System.out.println("Seleccione la accion que desea realizar:");
            System.out.println("1. Añadir 5 recetas al menu");
            System.out.println("2. Reemplazar por opcion vegana");
            System.out.println("3. Consultar cantidad de recetas en el menu");
            System.out.println("4. Consultar menu");
            System.out.println("0. Salir de la aplicacion");

            option = scan.nextLine();

            if (isAnOption(option, "4")){
                switch (Byte.parseByte(option)) {
                    case 1: 
                        addFiveRecipies();
                        break;
                    case 2: 
                        replaceThirdOption();
                        break;
                    case 3: 
                        amountOfRecipies();
                        break;
                    case 4: 
                        printMenu();
                        break;
                }
            }
            else{
                System.out.println("\nLa opcion ingresada no es valida\n");
            }
        }
    }


    // Add 5 recipes to the menu
    public static void addFiveRecipies(){
        System.out.println("\nAÑADIR NUEVAS RECETAS\n");

        byte recipesMade = 0;
        // Recipies
        List<String[]> recipies = new LinkedList<>();

        while (recipesMade < 5){
            System.out.println("Receta "+String.valueOf(recipesMade+1));
            System.out.println("Ingrese el nombre de la receta:");
            String name = scan.nextLine();
    
            System.out.println("Ingrese el precio de la receta:");
            String price = scan.nextLine();
    
            if(isPrice(price)){
                String[] recipie = {name,price};
                recipies.add(recipie);
                recipesMade ++;
            }
            else{
                System.out.println("\nEl precio no es valido");
                // Get out the loop
                recipesMade = 10;
            }
        }
        if (recipesMade == 5){
            restaurant.addRecipies(recipies);
            System.out.println("\nRecetas añadidas con exito");
        }
    }

    // Replace third option
    public static void replaceThirdOption(){
        System.out.println("\nCAMBIAR A OPCION VEGANA\n");

        System.out.println("Ingrese el nombre de la receta:");
        String name = scan.nextLine();

        System.out.println("Ingrese el precio de la receta:");
        String price = scan.nextLine();

        if(isPrice(price)){
            boolean changed = restaurant.changeOption(3, name, price);
            if (changed){
                System.out.println("Opcion cambiada con exito");
            }
            else{
                System.out.println("No se ha podido realizar el cambio. Revise el tamaño del menu");
            }
        }
        else{
            System.out.println("\nEl precio no es valido");
        }
    }

    // Print amount of recipes
    public static void amountOfRecipies(){
        System.out.println("\nNUMERO DE RECETAS\n");

        System.out.println("Actualmente el menu cuenta con "+ 
                            String.valueOf(restaurant.menuSize()) + 
                            " recetas.");
    }

    // Print menu
    public static void printMenu(){
        System.out.println("\nMENU DEL RESTAURNATE\n");
        byte receta = 1;

        for (Recipe recipe: restaurant.getMenu()){
            System.out.println("Receta "+String.valueOf(receta));
            recipe.showInfo();
            System.out.println();
            receta ++;
        }
    }

    // Input verification
    public static boolean isAnOption(String option, String maxOption){

        String regexString = String.format("([0-%s])", maxOption);

        boolean inOptions = option.matches(regexString);
        if (inOptions){
            return true;
        }
        else{
            System.out.println("\nNo se ingresó una opcion valida");
            return false;
        }

    }

    public static boolean isPrice(String price){

        boolean isPrice = price.matches("(\\d)*\\.?\\d+");
        if (isPrice){
            return true;
        }
        else{
            System.out.println("\nNo se ingresó un precio valido");
            return false;
        }

    }
    public static void main(String[] args) {
        restaurant = new Restaurant();
        System.out.println("Bienvenido a el restaurante "+Restaurant.getName()+" :)");
        mainMenu();
    }
}
