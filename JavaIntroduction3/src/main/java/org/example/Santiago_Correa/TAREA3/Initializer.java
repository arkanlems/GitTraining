package org.example.Santiago_Correa.TAREA3;

import java.util.ArrayList;

public class Initializer {
    public static void initializeMenu(ArrayList<Recipe> recipes) {
        recipes.add(new Recipe("Potatos fries", 23.0));
        recipes.add(new Recipe("BurguerLite", 50.0));
        recipes.add(new Recipe("BurguerMax", 50.0));
        recipes.add(new Recipe("BurguerPremium", 50.0));
        recipes.add(new Recipe("BurguerPremiumProx", 50.0));
    }
}
