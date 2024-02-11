package org.example.Santiago_Correa.TAREA3;

import java.util.ArrayList;

public class Menu {
    private ArrayList<Recipe> recipes = new ArrayList<Recipe>();

    public ArrayList<Recipe> getMenuList() {
        return this.recipes;
    }

    public void addNewsRecipes(Recipe recipe){
        this.recipes.add(recipe);
    }

    public void replaceThirdPositionRecipes(Recipe recipe){
        getMenuList().set(3, recipe);
    }

    public Integer getAmountRecipes(){
        return this.recipes.size();
    }

    public void getAllMenu(){
        for(Recipe recipe : recipes){
            System.out.print("Recipe name: " + recipe.getName() + "");
            System.out.println("Recipe price: " + recipe.getPrice());
        }
    }
}
