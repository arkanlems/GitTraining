import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Navigation {

    public static Restaurant setup(){

        System.out.println("Welcome to your restaurant app");
        System.out.println("Please Give the name of the restaurant");
        Scanner input= new Scanner(System.in);
        String restaurant_name=input.nextLine();
        Restaurant new_restaurant= new Restaurant(restaurant_name);
        return new_restaurant;
    }
    public static void navigate(Restaurant new_restaurant){

        //List<Recipe> recipes = new ArrayList<Recipe>();
        boolean a=false;
        while(a=true){
            Scanner input= new Scanner(System.in);
            System.out.println("Type 1: To Add a new recipe to the menu");
            System.out.println("Type 2: To Replace a recipe on the third option");
            System.out.println("Type 3: To Know how many recipes the menu have ");
            System.out.println("Type 4: To know the features of the each recipe");
            System.out.println("Type 5: To EXIT");
            int option=input.nextInt();

            switch (option){

                case 1: new_restaurant.AddRecipes();

                case 2: new_restaurant.replace_third();

                case 3: new_restaurant.amount_recipes();

                case 4: new_restaurant.getRecipes();

                case 5: System.exit(0);
            }

        }
    }
}
