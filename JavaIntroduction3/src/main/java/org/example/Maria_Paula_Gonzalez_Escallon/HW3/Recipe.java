package org.example.Maria_Paula_Gonzalez_Escallon.HW3;
public class Recipe {
    private String name;
    private double price;

    public Recipe(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
