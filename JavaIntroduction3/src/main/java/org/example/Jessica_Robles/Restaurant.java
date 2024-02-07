package org.example.Jessica_Robles;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static String name  = "Doña Pepita";
    private List<Recipe> menu = new ArrayList<>();

    // Getters
    public static String getName() {
        return name;
    }

    public List<Recipe> getMenu() {
        return menu;
    }

    // Add Recipie
    private void addRecipie(String name, double price){
        menu.add(new Recipe(name, price));
    }

    public void addRecipies(List<String[]> recipies){
        for (String[] recipie: recipies){
            addRecipie(recipie[0], Double.parseDouble(recipie[1]));
        }
    }

    //Replace third optiod
    public boolean changeOption(int number, String name, String price){
        // Get number to position index
        number --;

        // Check if the position can be changed
        if ((number > -1) && (number < menu.size())){
            menu.set(number, new Recipe(name, Double.parseDouble(price)));
            return true;
        }
        else{
            return false;
        }
    }

    // Menu size
    public int menuSize(){
        return menu.size();
    }


}

