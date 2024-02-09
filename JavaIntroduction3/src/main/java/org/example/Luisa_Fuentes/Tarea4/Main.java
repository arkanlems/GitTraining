package org.example.Luisa_Fuentes.Tarea4;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        mostrarMenuYCrearBanco();
    }

    public static void mostrarMenuYCrearBanco(){
        Banco banco = crearBanco();
        banco.mostrarInfoBanco(banco);
        mostrarMenu(banco);
    }

    public static Banco crearBanco() {
        List<Cliente> clientes_lista = new ArrayList<>();

        Cuenta cuenta1 = new Cuenta(123, Timestamp.from(Instant.now()), 50000);
        Cuenta cuenta2 = new Cuenta(124, Timestamp.from(Instant.now()), 100000);

        Cliente cliente1 = new Cliente(cuenta1, "Pedro Pascal", "ABC123");
        Cliente cliente2 = new Cliente(cuenta2, "Pepita Pérez", "XYZ123");

        clientes_lista.add(cliente1);
        clientes_lista.add(cliente2);

        return new Banco(clientes_lista);

    }

    public static void mostrarMenu(Banco banco) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Bienvenido al Globant Bank\n" +
                "Por favor ingresa tu nombre de usuario: ");
        scan = new Scanner(System.in);
        String nombre_usuario = scan.nextLine();

        System.out.println("Por favor ingresa tu contraseña: ");
        scan = new Scanner(System.in);
        String contraseña = scan.nextLine();

        Cliente cliente_encontrado = banco.buscarCliente(nombre_usuario,contraseña);
        if (cliente_encontrado == null){

            System.out.println("Usuario no registrado \n");
            mostrarMenuYCrearBanco();

        }
        else{
            mostrarMenuClienteBanco(cliente_encontrado,scan, banco);
        }
    }

    public static void mostrarMenuClienteBanco(Cliente cliente_encontrado, Scanner scan, Banco banco){

        System.out.printf("Selecciona la operación que deseas realizar\n" +
                "1. Realizar un depósito \n" +
                "2. Realizar un retiro \n"+
                "3. Transferir dinero \n"+
                "4. Salir \n");

        int opcion = scan.nextInt();

        switch (opcion) {
            case 1:
                menuDeposito(cliente_encontrado,scan,banco);
                mostrarMenuClienteBanco(cliente_encontrado, scan, banco);

                break;
            case 2:
                menuRetiro(cliente_encontrado,scan,banco);
                mostrarMenuClienteBanco(cliente_encontrado, scan, banco);

                break;
            case 3:
                menuTransferencia(cliente_encontrado,scan, banco);
                mostrarMenuClienteBanco(cliente_encontrado, scan, banco);

                break;
            case 4:
                System.exit(0);
            default:
            	System.exit(0);
        }

    }

    public static void menuDeposito(Cliente cliente_encontrado, Scanner scan, Banco banco){
        System.out.println("Por favor ingresa la cantidad de dinero que deseas depositar en tu cuenta: ");
        scan = new Scanner(System.in);
        double cantidad_deposito = scan.nextDouble();

        banco.realizarDeposito(cliente_encontrado, cantidad_deposito);

    }

    public static void menuRetiro(Cliente cliente_encontrado, Scanner scan, Banco banco){
        System.out.println("Por favor ingresa la cantidad de dinero que deseas retirar de tu cuenta: ");
        scan = new Scanner(System.in);
        double cantidad_retiro = scan.nextDouble();

        banco.realizarRetiro(cliente_encontrado, cantidad_retiro);

    }

    public static void menuTransferencia(Cliente cliente_encontrado, Scanner scan, Banco banco){
        System.out.println("Por favor indique el número de cuenta al que desea transferir: ");
        scan = new Scanner(System.in);
        int num_cuenta = scan.nextInt();

        System.out.println("Por favor indique la cantidad de dinero que desea tranferir: ");
        scan = new Scanner(System.in);
        double cant_tranf = scan.nextDouble();
        banco.transferirACuenta(cliente_encontrado,num_cuenta,cant_tranf);


    }
}
