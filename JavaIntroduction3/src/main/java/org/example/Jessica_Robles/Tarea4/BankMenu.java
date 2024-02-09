package org.example.Jessica_Robles.Tarea4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.example.Jessica_Robles.Tarea3.Restaurant;

public class BankMenu {

    // Scanner used to read user input
    private static final Scanner scan = new Scanner(System.in);

    private static Bank bank;

    // Main menu
    public static void mainMenu(){
        String option = "";
        while (!option.equals("0")){
            System.out.println("\nMENU PRINCIPAL\n");

            System.out.println("Seleccione la accion que desea realizar:");
            System.out.println("1. Imprimir todos los usuarios del banco");
            System.out.println("2. Ingresar como usuario");
            System.out.println("3. Registrarse como usuario");
            System.out.println("0. Salir de la aplicacion");

            option = scan.nextLine();

            if (isAnOption(option, "4")){
                switch (Byte.parseByte(option)) {
                    case 1: 
                        listAllUsers();
                        break;
                    case 2: 
                        enterAccount();
                        break;
                    case 3: 
                        break;
                }
            }
            else{
                System.out.println("\nLa opcion ingresada no es valida\n");
            }
        }
    }


    // List all the users
    public static void listAllUsers() {
        System.out.println("\nUSUARIOS EN EL BANCO\n");
        bank.listUsers();
    }
    
    // Enter to an account
    public static void enterAccount(){
        System.out.println("\nINGRESAR A MI CUENTA\n");

        System.out.println("Ingrese su usuario:");
        String username = scan.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = scan.nextLine();

        Client client = bank.userLogIn(username, password);
        if(client != null){
            System.out.println("\nBienvenido "+client.getusername());
            userMenu();
        }
        else{
            System.out.println("\nUsuario o contraseña no validos");
        }
    }

    public static void userMenu(){

    }


    // Register user
    public static void registerUser(){
        System.out.println("\nREGISTRAR USUARIO\n");

        System.out.println("\nRecuerde que cada usuario nuevo al momento de crear su cuenta se le asignará una cuenta con el banco.\n");

        System.out.println("Ingrese su usuario:");
        String username = scan.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = scan.nextLine();

        //TODO
        if(true){
            System.out.println("\nUsuario creado con esto");
        }
        else{
            System.out.println("\nEl precio no es valido");
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
        bank = new Bank();
        System.out.println("\nBienvenido a "+ Bank.name +" :)");
        mainMenu();
    }
}
