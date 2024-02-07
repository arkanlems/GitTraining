package org.example.Andres_Rincon.Homework3;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Recipe> recipeList;

    public Menu() {
        recipeList = new ArrayList<>();
    }
    public Menu(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    public void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
    }

    public void replaceRecipe(Recipe oldRecipe, Recipe newRecipe) {
        int index = recipeList.indexOf(oldRecipe);
        replaceRecipe(index, newRecipe);
    }

    public void replaceRecipe(int index, Recipe newRecipe) {
        recipeList.set(index, newRecipe);
    }

    public int getAmountOfRecipes() {
        return recipeList.size();
    }

    public List<Recipe> getRecipeList() {
        return recipeList;
    }

    public void setRecipeList(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Recipe recipe : recipeList) {
            str.append(recipe.getName()).append(" - ").append(recipe.getPrice()).append("\n");
        }
        return String.valueOf(str);
    }
}
