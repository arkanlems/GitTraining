package org.example.Juan_Potes.Tarea3;

public class Main {
    public static void main(String[] args) {
        RestaurantMenu menu = new RestaurantMenu();
        menu.addRecipe("Pechuga a la plancha", 50000);
        menu.addRecipe("Pasta bolognesa", 40000);
        menu.addRecipe("Ajiaco", 30000);
        menu.addRecipe("Pollo a la naranja", 30000);
        menu.addRecipe("Ensalada de Atun", 30000);
        menu.showRecipes();

        menu.executeOptions();
    }
}