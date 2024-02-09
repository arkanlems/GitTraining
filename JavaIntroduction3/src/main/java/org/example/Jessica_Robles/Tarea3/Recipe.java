package org.example.Jessica_Robles.Tarea3;

public class Recipe {
    private String name;
    private double price;

    // Constructor
    public Recipe(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Show info
    public void showInfo(){
        System.out.println("Nombre: "+ this.name);
        System.out.println("Precio: "+ String.valueOf(this.price));
    }
}


