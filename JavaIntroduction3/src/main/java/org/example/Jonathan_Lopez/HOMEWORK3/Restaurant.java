import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Restaurant {

    private String name;
    private List<Recipe> recipes = new ArrayList<Recipe>();

    public Restaurant(){

    }

    public Restaurant(String name){

        this.name=name;
        this.create_menu();

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Recipe> getMenu() {
        return recipes;
    }

    public void setMenu(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public void create_menu(){

        recipes.add(new Recipe("chicken", 23000.0));
        recipes.add(new Recipe("steak",54000.0));
        recipes.add(new Recipe("fish and fries",33000.0));
        recipes.add(new Recipe("soup",15000.0));
        recipes.add(new Recipe("icecream",10000.0));
    }
    public void AddRecipes() {

        System.out.println("Give the new recipe name");
        Scanner input=new Scanner(System.in);
        String newname=input.nextLine();
        System.out.println("Give its price");
        Double price=(double) input.nextFloat();
        Recipe new_recipe=new Recipe(newname,price);
        this.recipes.add(new_recipe);
        System.out.println("Recipe Added");
        Navigation.navigate(this);

        //return new_recipe.getName();
    }

    public void amount_recipes(){

        int quantity=recipes.size();
        System.out.println("There are "+quantity+" recipes on the menu");
        Navigation.navigate(this);



    }

    public void getRecipes() {

        for(Recipe recipe:this.recipes){

            System.out.println("Name: "+recipe.getName()+" | "+" Price: "+recipe.getPrice());

        }
        Navigation.navigate(this);
    }

    public void replace_third(){

        Scanner input= new Scanner(System.in);
        System.out.println("Please, give the name of the recipe:");
        String name=input.nextLine();
        System.out.println("Please, give the price of the recipe:");
        Double price= (double) input.nextFloat();
        Recipe new_recipe=new Recipe(name,price);
        this.recipes.set(2,new_recipe);
        System.out.println("Recipe replaced");
        Navigation.navigate(this);
    }
}
