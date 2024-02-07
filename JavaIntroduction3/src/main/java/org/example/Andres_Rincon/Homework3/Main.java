package org.example.Andres_Rincon.Homework3;

public class Main {
    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant("MyRestaurant");
        restaurant.printAmountOfRecipes();
        restaurant.printMenu();

        System.out.println("********************");
        Recipe veganRecipe = new Recipe("Lentil and vegetables curry", 22000.0);
        restaurant.replaceRecipe(2, veganRecipe);
        restaurant.printMenu();

    }
}