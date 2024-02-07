package org.example.Diego_Molina.HomeWork3;

public class Recipe {
    private int id;
    private String name;
    private int price;
    private String type;


    public Recipe(){

    }

    public Recipe(int id, String name, int price, String type) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%-5d %-25s %-15d %-15s\n", id, name, price, type));
        return sb.toString();
    }
}
