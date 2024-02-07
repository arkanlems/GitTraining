import java.util.ArrayList;
import java.util.List;

public class RestaurantMenu {
    private List<Recipe> recipes = new ArrayList<>();

    // Constructor

    public RestaurantMenu(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public RestaurantMenu(){}

    // Methods

    // Method to execute the different options of the program until the user selects the exit option
    public void executeOptions(){
        int option = -1;

        while(option != 6){
            option = UserInput.optionMenu();

            switch (option){
                case 1:
                    addRecipe();
                    break;
                case 2:
                    deleteRecipe();
                    break;
                case 3:
                    replaceRecipe();
                    break;
                case 4:
                    showRecipesAmount();
                    break;
                case 5:
                    showRecipes();
                    break;
                default:
                    break;
            }
        }
    }

    // Method to add a new recipe with input from the user
    public void addRecipe(){
        String recipeName = UserInput.scanName("Please type the name of the new recipe:  ");
        double recipePrice = UserInput.scanPrice("Please type the price of the new recipe:  ");

        this.recipes.add(new Recipe(recipeName, recipePrice));
    }

    // Method to add a new recipe with the attributes sent as parameters
    public void addRecipe(String name, double price){
        this.recipes.add(new Recipe(name, price));
    }

    // Show the Restaurant Menu in the console
    public void showRecipes(){
        if(!this.recipes.isEmpty()){
            System.out.println("\n\tRESTAURANT MENU");
            System.out.println(String.format("%-4s %-25.25s %-10s", "#", "Recipe Name", "Price"));

            int num = 1;
            for(Recipe recipe : this.recipes){
                System.out.println(String.format("%-4s %-25.25s %-10s", num + ".", recipe.getName(), recipe.getPrice()));
                num++;
            }
        }
        else{
            showEmptyMessage();
        }
    }

    public void showEmptyMessage(){
        System.out.println("\nCurrently the restaurant menu is empty. There are no recipes");
    }

    public void showNotFoundMessage(){
        System.out.println("\nThe recipe was NOT found in the menu. Check the menu list to verify the spelling of the name");
    }

    // Method that search for a recipe name in the list and returns the index (or -1 if it's not found)
    public int indexOfName(String name){
        int index = -1;
        for(int i = 0; i < this.recipes.size(); i++){
            if(this.recipes.get(i).nameEquals(name)){
                index = i;
                break;
            }
        }
        return index;
    }

    // Method to delete a recipe given the name
    public void deleteRecipe(String name){
        int index = indexOfName(name);
        if(index >= 0){
            deleteRecipe(index);
        }
        else{
            showNotFoundMessage();
        }
    }

    // Method to delete a recipe given the index
    public void deleteRecipe(int index){
        if(index >= 0 && index < this.recipes.size()){
            this.recipes.remove(index);
            System.out.println("\nThe recipe was deleted successfully");
        }
        else{
            System.out.println("\nINVALID INDEX");
        }
    }

    // Method to delete a recipe from the user input
    public void deleteRecipe(){
        String name = UserInput.scanName("Please type the name of the recipe to delete: ");
        deleteRecipe(name);
    }

    // Method to replace a recipe given the index to replace and the data of the new recipe
    private void replaceRecipe(int index, String name, double price){
        this.recipes.set(index, new Recipe(name, price));
    }

    // Method to replace a recipe given the original name to replace and the data of the new recipe
    public void replaceRecipe(String origName, String newName, double newPrice){
        int index = indexOfName(origName);
        if(index >= 0){
            replaceRecipe(index, newName, newPrice);
            System.out.println("\nThe recipe was replaced successfully!");
        }
        else{
            showNotFoundMessage();
        }
    }

    // Method to replace a recipe with the user input
    public void replaceRecipe(){
        String origName;
        String newName;
        double newPrice;

        origName = UserInput.scanName("Please type the name of the recipe that will be replaced: ");

        int index = indexOfName(origName);

        if(index >= 0){
            System.out.println("\nThe recipe typed was found!");

            newName = UserInput.scanName("Please type the NAME of the new recipe that will replace the old one: ");
            newPrice = UserInput.scanPrice("Please type the PRICE of the new recipe that will replace the old one: ");

            replaceRecipe(origName, newName, newPrice);
        }
        else{
            showNotFoundMessage();
        }
    }

    // Method that shows the amount of current recipes in the list
    public void showRecipesAmount(){
        if(this.recipes.size() == 0){
            showEmptyMessage();
        }
        else if(this.recipes.size() == 1){
            System.out.println("\nThe menu currently has only 1 recipe");
        }
        else{
            System.out.println("\nThe menu currently has "+ this.recipes.size() + " recipes");
        }
    }

    // Getters and Setters

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
}
