package org.example.Andres_Rincon.Homework3;

public class Restaurant {
    private String name;
    private Menu menu;

    public Restaurant(String name, Menu menu) {
        this.name = name;
        this.menu = menu;
        addInitialRecipes();
    }

    public Restaurant(String name) {
        this.name = name;
        this.menu = new Menu();
        addInitialRecipes();
    }

    private void addInitialRecipes() {
        Recipe recipe1 = new Recipe("Spaghetti Bolognese", 20000.0);
        Recipe recipe2 = new Recipe("Chicken Parmesan", 25000.0);
        Recipe recipe3 = new Recipe("Vegetable Stir-Fry", 17000.0);
        Recipe recipe4 = new Recipe("Chocolate Chip Cookies", 18000.0);
        Recipe recipe5 = new Recipe("Margherita Pizza", 22000.0);

        menu.addRecipe(recipe1);
        menu.addRecipe(recipe2);
        menu.addRecipe(recipe3);
        menu.addRecipe(recipe4);
        menu.addRecipe(recipe5);
    }

    public void addRecipe(String name, Double price) {
       menu.addRecipe(new Recipe(name, price));
    }

    public void replaceRecipe(int index, Recipe recipe) {
        menu.replaceRecipe(index, recipe);
    }

    public void replaceRecipe(Recipe oldRecipe, Recipe newRecipe) {
        menu.replaceRecipe(oldRecipe, newRecipe);
    }

    public void printAmountOfRecipes() {
        System.out.println("Amount of recipes: " + menu.getAmountOfRecipes());
    }

    public void printMenu() {
        System.out.println(menu);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }
}
