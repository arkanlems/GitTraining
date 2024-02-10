package Dia_4.GitTraining.JavaIntroduction3.Tareas_Tomas_Duque.Tarea_4;

import java.util.Scanner;

public class Main {

    public static void main(String [] args){

        Bank bank = new Bank();
        bank.addClient(new Client("Usuario1", "Pass1", new Account("100000001", "2024-01-01", 1000.0)));
        bank.addClient(new Client("Usuario2", "Pass2", new Account("100000002", "2024-01-02", 2000.0)));
        bank.addClient(new Client("Usuario3", "Pass3", new Account("100000003", "2024-01-03", 3000.0)));
        bank.addClient(new Client("Usuario4", "Pass4", new Account("100000004", "2024-01-04", 4000.0)));
        bank.addClient(new Client("Usuario5", "Pass5", new Account("100000005", "2024-01-05", 5000.0)));
        bank.addClient(new Client("Usuario6", "Pass6", new Account("100000006", "2024-01-06", 6000.0)));
        bank.addClient(new Client("Usuario7", "Pass7", new Account("100000007", "2024-01-07", 7000.0)));
        bank.addClient(new Client("Usuario8", "Pass8", new Account("100000008", "2024-01-08", 8000.0)));
        bank.addClient(new Client("Usuario9", "Pass9", new Account("100000009", "2024-01-09", 9000.0)));
        bank.addClient(new Client("Usuario10", "Pass10", new Account("100000010", "2024-01-10", 10000.0)));
        int option = 0;
        do{
        System.out.println("Bienvenido al menú del banco, ¿Qué desea hacer? \n 1). Ver a todos los clientes \n 2). Retirar dinero \n 3). Añadir dinero \n 4). Transferir dinero\n5). Salir" );

        Scanner scan = new Scanner(System.in);
         option = scan.nextInt();
        scan.nextLine();
        switch(option){
            case 1:
                System.out.println("Clientes:");
                bank.printClient();
                break;
            case 2:
                System.out.println("Ingrese el nombre de usuario:");
                String username = scan.nextLine();
                System.out.println("Ingrese contraseña:");
                String password = scan.nextLine();
                Client client = bank.findClient(username,password);
                if(client == null){
                    System.out.println("El usuario no está registrado o la constraseña es incorrecta");
                    break;
                }

                System.out.println("Cuanto desea retirar?");
                double amount = scan.nextDouble();

                client.getAccount().withdraw(amount);
                break;
            case 3:
                System.out.println("Ingrese el nombre de usuario:");
                String usernameDeposit = scan.nextLine();
                System.out.println("Ingrese contraseña:");
                String passwordDeposit = scan.nextLine();
                Client clientDeposit = bank.findClient(usernameDeposit,passwordDeposit);
                if(clientDeposit == null){
                    System.out.println("El usuario no está registrado o la constraseña es incorrecta");
                    break;
                }

                System.out.println("Cuanto desea depositar?");
                double amountDeposit = scan.nextDouble();

                clientDeposit.getAccount().deposit(amountDeposit);
                break;
            case 4:
                System.out.println("Ingrese el nombre de usuario:");
                String usernameTransfer = scan.nextLine();
                System.out.println("Ingrese contraseña:");
                String passwordTransfer = scan.nextLine();
                Client clientTransfer = bank.findClient(usernameTransfer,passwordTransfer);
                if(clientTransfer == null){
                    System.out.println("El usuario no está registrado o la constraseña es incorrecta");
                    break;
                }else {

                    System.out.println("Cuanto desea transferir?");
                    double amountTransfer = scan.nextDouble();
                    scan.nextLine();
                    System.out.println("Ingrese el nombre del usuario de la cuenta a la que desea transferir");
                    String reciverAccount = scan.nextLine();
                    Client reciverClient = bank.findClientByUsername(reciverAccount);
                    if (reciverClient == null) {
                        System.out.println("El usuario al que desea transferir no se encuentra registrado");
                    } else if (amountTransfer <=0) {
                        System.out.println("El monto a transferir debe ser mayor a 0");
                    } else{

                    clientTransfer.getAccount().transfer(amountTransfer, reciverClient.getAccount());
                    break;}
                }

        }}while(option !=5);
    }
}
