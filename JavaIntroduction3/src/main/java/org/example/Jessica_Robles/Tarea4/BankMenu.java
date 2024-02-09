package org.example.Jessica_Robles.Tarea4;

import java.util.Scanner;

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

            if (isAnOption(option, "3")){
                switch (Byte.parseByte(option)) {
                    case 1: 
                        listAllUsers();
                        break;
                    case 2: 
                        enterAccount();
                        break;
                    case 3: 
                        registerUser();
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
            userMenu(client);
        }
        else{
            System.out.println("\nUsuario o contraseña no validos");
        }
    }

    public static void userMenu(Client client){
        System.out.println("\nBienvenido "+client.getusername());
        String option = "";

        while (!option.equals("0")){
            System.out.println("Seleccione la accion que desea realizar:");
            System.out.println("1. Ver mis cuentas de banco");
            System.out.println("2. Realizar operacion sobre cuenta");
            System.out.println("0. Salir de mi cuenta");

            option = scan.nextLine();

            if (isAnOption(option, "2")){
                switch (Byte.parseByte(option)) {
                    case 1: 
                        client.showInfo();
                        break;
                    case 2: 
                        chooseAccount(client);
                        break;
                }
            }
            else{
                System.out.println("\nLa opcion ingresada no es valida\n");
            }
        }

    }


    public static void chooseAccount(Client client){
        
        System.out.println("Ingrese la cuenta sobre la que desea realizar un cambio");
        client.showAccountsInfo();

        String option = scan.nextLine();

        if(isAnOption(option, String.valueOf(client.numberAccounts()))){
            Account account = client.getAccount(Integer.parseInt(option)-1);
            operationsAccount(account,client);
        }
        else{
            System.out.println("\nLa opcion ingresada no es valida\n");
        }
    }

    public static void operationsAccount(Account account, Client client){
        System.out.println("Seleccione la operacion que desea realizar:");
        System.out.println("1. Retirar dinero");
        System.out.println("2. Recargar dinero");
        System.out.println("3. Transferir dinero");

        String option = scan.nextLine();

        if (isAnOption(option, "3")){
            switch (Byte.parseByte(option)) {
                case 1: 
                    withdrawToAccount(account);
                    break;
                case 2: 
                    addToAccount(account);
                    break;
                case 3: 
                    transfer(account, client);
                    break;
            }
        }
        else{
            System.out.println("\nLa opcion ingresada no es valida\n");
        }

    }

    // Operations in an Account
    public static void withdrawToAccount(Account account){
        System.out.println("Ingrese la cantidad a retirar:");
        String quantity = scan.nextLine();

        if (isPrice(quantity)){
            if (account.withraw(Double.parseDouble(quantity))){
                System.out.println("\nRetiro hecho exitosamente\n");
                account.showInfo();
            }
            else{
                System.out.println("\nNo hay fondos suficientes\n");
            }
        }
    }

    public static void addToAccount(Account account){
        System.out.println("Ingrese la cantidad a depositar:");
        String quantity = scan.nextLine();

        if (isPrice(quantity)){
            account.addMoney(Double.parseDouble(quantity));
            System.out.println("\nLa operacion se ha hecho exitosamente\n");
            account.showInfo();
        }
    }

    public static void transfer(Account account, Client client){
        System.out.println("Ingrese el nombre del usuario:");
        String name = scan.nextLine();
        System.out.println("Ingrese el numero de la cuenta:");
        String accountNumber = scan.nextLine();
        System.out.println("Ingrese la cantidad a transferir:");
        String quantity = scan.nextLine();

        if ((isPrice(quantity)) && (isInt(accountNumber))){
            byte response = bank.transfer(name, Long.parseLong(accountNumber), Double.parseDouble(quantity), account);
            if (response == 2){
                System.out.println("\nLa transferencia se ha realizado con exito\n");
                account.showInfo();
            }
            else if(response == 1){
                System.out.println("\nNo se tienen fondos suficinetes para realizar la transferncia\n");
            }
            else{
                System.out.println("\nNo se ha podido realizar la transferencia, revise que los datos sean correctos.\n");
            }
        }
    }


    // Register user
    public static void registerUser(){
        System.out.println("\nREGISTRAR USUARIO\n");

        System.out.println("\nRecuerde que cada usuario nuevo al momento de crear su cuenta se le asignará una cuenta con el banco.\n");

        System.out.println("Ingrese su usuario:");
        String username = scan.nextLine();

        System.out.println("Ingrese la contraseña:");
        String password = scan.nextLine();

        if(bank.addUser(username, password)){
            System.out.println("\nUsuario creado con exito");
        }
        else{
            System.out.println("\nEl nombre de usuario ya existe");
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

    public static boolean isInt(String integer){

        boolean isInteger = integer.matches("(\\d)+");
        if (isInteger){
            return true;
        }
        else{
            System.out.println("\nNo se ingresó una cantidad valida");
            return false;
        }

    }

    public static void main(String[] args) {
        bank = new Bank();
        System.out.println("\nBienvenido a "+ Bank.name +" :)");
        mainMenu();
    }
}
