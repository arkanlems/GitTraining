package org.example.homeworkSession3;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private String name;
    private List<Recipe> menu;

    public Restaurant() {
    }

    public Restaurant(String name, List<Recipe> menu) {
        this.name = name;
        this.menu = menu;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getMenu() {
        return menu;
    }

    public void setMenu(List<Recipe> menu) {
        this.menu = menu;
    }

    public List<Recipe> createReceipes() {
        List<Recipe> menu = new ArrayList<>();
        menu.add(new Recipe("Caesar Salad", "1. Wash and chop the lettuce.\n2. Toss the lettuce with Caesar dressing." +
                "\n3. Add toasted bread croutons and grated Parmesan cheese.", 8.99));
        menu.add(new Recipe("Ham and Cheese Sandwich", "1. Place ham and cheese slices between two bread slices." +
                "\n2. Heat in a skillet until golden brown on both sides.", 5.49));
        menu.add(new Recipe("French Toast", "1. Beat eggs, milk, and cinnamon together.\n2. Soak bread slices in the mixture." +
                "\n3. Cook in a hot skillet until golden brown on both sides.", 6.99));
        menu.add(new Recipe("Alfredo Pasta", "1. Cook pasta according to package instructions.\n2. Melt butter in a skillet and add cream." +
                "\n3. Toss cooked pasta with sauce and sprinkle with Parmesan cheese on top.", 9.75));
        menu.add(new Recipe("Fruit Smoothie", "1. Cut fruits into small pieces.\n2. Place fruits in a blender along with yogurt and ice." +
                "\n3. Blend until smooth and homogeneous.", 4.25));
        return menu;
    }

    public String printMenu() {
        String msg = "";
        for (Recipe recipe : this.menu)
            msg += recipe.getName() + "..........................." + recipe.getPrice() + "\n";
        return msg;
    }
}
