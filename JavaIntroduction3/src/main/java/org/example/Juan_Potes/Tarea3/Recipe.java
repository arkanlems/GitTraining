package org.example.Juan_Potes.Tarea3;
public class Recipe {
    private String name;
    private double price;

    // Constructor

    public Recipe(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Methods

    public boolean nameEquals(String name){
        return name.equalsIgnoreCase(this.name);
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
