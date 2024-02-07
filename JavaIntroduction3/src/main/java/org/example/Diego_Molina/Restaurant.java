import java.util.ArrayList;
import java.util.Optional;

public class Restaurant {

    private static String name = "Glo Recipe";
    private static ArrayList<Recipe> menu = new ArrayList<>();

    public static void init(){
        menu.add(new Recipe(101,"Spaghetti Carbonara", 10, "Italian"));
        menu.add(new Recipe(102,"Chicken Tikka Masala", 15, "Indian"));
        menu.add(new Recipe(103,"Miso Soup", 8, "Japanese"));
        menu.add(new Recipe(104, "Tacos al Pastor", 12, "Mexican"));
        menu.add(new Recipe(105, "Beef Wellington", 20, "French"));
    }

    public static Optional<Integer> getIndexById(int id) {
        return menu.stream().parallel()
                .map(Recipe::getId)
                .filter(recipeId -> recipeId == id)
                .findFirst()
                .map(recipeId -> menu.indexOf(menu.stream()
                        .filter(recipe -> recipe.getId() == recipeId)
                        .findFirst()
                        .orElse(null)));
    }

    public static void addRecipe(){

        Recipe newRecipe = new Recipe();
        System.out.println("-----------------------------------------------------------");
        System.out.println("                      New Recipe                           ");
        System.out.println("-----------------------------------------------------------");

        while(true){
            System.out.println("Id");
            newRecipe.setId(Utils.readInteger());
            Optional<Integer> index =  getIndexById(newRecipe.getId());

            if(index.isPresent()){
                System.out.println("Id is already used");
            }else{
                break;
            }
        }

        System.out.println("Name: ");
        newRecipe.setName(Utils.readString());

        System.out.println("Price: ");
        newRecipe.setPrice(Utils.readInteger());

        System.out.println("Type: ");
        newRecipe.setType(Utils.readString());

        menu.add(newRecipe);
        System.out.println("New Recipe Was Added");
    }

    public static void showMenu(){
        StringBuilder sb = new StringBuilder();;
        sb.append(String.format("%-5s %-25s %-15s %-15s","Id", "Name", "Price", "Type"));
        System.out.println("-----------------------------------------------------------");
        System.out.println(sb.toString());
        System.out.println("------------------------------------------------------------");

        for (Recipe recipe : menu) {
            System.out.print(recipe.toString());
        }
    }

    public static void replaceRecipeById(){
        Recipe newRecipe = new Recipe();
        System.out.println("-----------------------------------------------------------");
        System.out.println("                  Replace Recipe                           ");
        System.out.println("-----------------------------------------------------------");

        System.out.println("Id");
        newRecipe.setId(Utils.readInteger());
        Optional<Integer> index =  getIndexById(newRecipe.getId());

        if(index.isPresent()){
            System.out.println("Name: ");
            newRecipe.setName(Utils.readString());

            System.out.println("Price: ");
            newRecipe.setPrice(Utils.readInteger());

            System.out.println("Type: ");
            newRecipe.setType(Utils.readString());

            menu.set(index.get(), newRecipe);
        }else{
            System.out.println("Id is not used");
            StartMenu.showOptions();
        }
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Restaurant.name = name;
    }

    public static ArrayList<Recipe> getMenu() {
        return menu;
    }

    public static void setMenu(ArrayList<Recipe> menu) {
        Restaurant.menu = menu;
    }
}
