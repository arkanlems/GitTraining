package org.example.homeworkSession3;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String name;
    private String steps;
    private Double price;

    public Recipe() {
    }

    public Recipe(String name, String steps, Double price) {
        this.name = name;
        this.steps = steps;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

}
