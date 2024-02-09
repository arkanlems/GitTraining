package org.example.Luisa_Fuentes.Tarea4;

public class Cliente {
    private Cuenta cuenta_ahorros;
    private String nombre_usuario;
    private String contraseña;

    public Cliente(Cuenta cuenta_ahorros, String nombre_usuario, String contraseña) {
        this.cuenta_ahorros = cuenta_ahorros;
        this.nombre_usuario = nombre_usuario;
        this.contraseña = contraseña;
    }

    public Cuenta getCuenta_ahorros() {
        return cuenta_ahorros;
    }

    public void setCuenta_ahorros(Cuenta cuenta_ahorros) {
        this.cuenta_ahorros = cuenta_ahorros;
    }

    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
