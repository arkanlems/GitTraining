package org.example.Juan_David_Camacho2;

public class Plate {

    private String name;
    private double price;

    public Plate(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String returnItem() {
        return name + " | $" + price;
    }

}