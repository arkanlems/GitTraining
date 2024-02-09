package org.example.Luisa_Fuentes.Tarea4;

import java.util.List;

public class Banco {
    private List<Cliente> clientes;

    public Banco(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void mostrarInfoBanco(Banco banco){
        List<Cliente> clientes=banco.getClientes();
        for (Cliente cliente: clientes){

            System.out.println("Cliente: "+cliente.getNombre_usuario() + " Número de cuenta: "+ cliente.getCuenta_ahorros().getNumero());
        }

    }
    public Cliente buscarCliente(String nombre_usuario, String contraseña) {
        Cliente cli= null;
        for (Cliente cliente: clientes){

            if (nombre_usuario.equalsIgnoreCase(cliente.getNombre_usuario()) ){
                if (contraseña.toString().equals(cliente.getContraseña())){
                    cli=cliente;
                    break;
                }
                else{
                    System.out.println("Credenciales incorrectas \n");
                }
            }
        }
        return cli;
    }

    public void realizarDeposito(Cliente cliente_encontrado, Double cantidad_deposito){

        if (cantidad_deposito > 0) {
            double balance = cliente_encontrado.getCuenta_ahorros().getBalance();
            double nuevo_balance = balance + cantidad_deposito;
            cliente_encontrado.getCuenta_ahorros().setBalance(nuevo_balance);
            System.out.println("Valor actual del balance: " + nuevo_balance);

        }
        else{
            System.out.println("Por favor ingresa una cantidad de dinero válida ");

        }
    }

    public void realizarRetiro(Cliente cliente_encontrado, Double cantidad_retiro){
        double balance= cliente_encontrado.getCuenta_ahorros().getBalance();

        if (cantidad_retiro <= 1000 && balance-cantidad_retiro>0) {
            double nuevo_balance = balance - cantidad_retiro - 200;
            cliente_encontrado.getCuenta_ahorros().setBalance(nuevo_balance);
            System.out.println("Valor actual del balance: " + nuevo_balance);
        }
        else if (cantidad_retiro > 1000){
            double restante= balance - (cantidad_retiro + (200 + cantidad_retiro* 0.15));
            if (restante > 0){
                cliente_encontrado.getCuenta_ahorros().setBalance(restante);
                System.out.println("Valor actual del balance: " + restante);
            }
            else{
                System.out.println("No tienes suficiente dinero para hacer el retiro");
            }
        }
        else{
            System.out.println("No tienes suficiente dinero para hacer el retiro");
        }
    }


    public void transferirACuenta(Cliente clienteEncontrado, int numCuenta, double cantTranf) {
        boolean encontrado= false;

        for (Cliente cliente: clientes){

            if (cliente.getCuenta_ahorros().getNumero()==numCuenta){

                double balance_cuenta_origen = clienteEncontrado.getCuenta_ahorros().getBalance();
                double cant_restar= (cantTranf + 100);
                if (balance_cuenta_origen > 0 &&  balance_cuenta_origen-cant_restar>0) {
                    clienteEncontrado.getCuenta_ahorros().setBalance(balance_cuenta_origen - cant_restar);
                    System.out.println("Valor actual del balance: " + clienteEncontrado.getCuenta_ahorros().getBalance());


                    double balance_cuenta_destino =cliente.getCuenta_ahorros().getBalance();
                    cliente.getCuenta_ahorros().setBalance(balance_cuenta_destino+cantTranf);

                    encontrado= true;
                }
                else{
                    System.out.println("No tienes suficiente dinero para hacer la transferencia");

                }
                encontrado= true;
            }
        }
        if (encontrado == false ){
            System.out.println("No existe un usuario con ese número de cuenta");

        }

    }
}