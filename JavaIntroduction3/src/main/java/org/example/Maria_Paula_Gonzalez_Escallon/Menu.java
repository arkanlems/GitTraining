import java.util.ArrayList;
import java.util.List;

public class Menu {
    private List<Recipe> recipes;

    public Menu() {
        this.recipes = new ArrayList<>();
    }

    public void addRecipe(String name, double price) {
        recipes.add(new Recipe(name, price));
    }

    public void replaceRecipe (int index, String name, double price) {
        if (index >= 0 && index < recipes.size()) {
            recipes.set(index, new Recipe(name, price));
            System.out.println("This is the new menu: ");
            printMenu();
        }else {
            System.out.println("The Recipe does not exist.");
        }
    }

    public void printSizeMenu() {
        System.out.println("The menu has " + recipes.size() + " recipes");
    }
    
    public void printMenu () {
        for (int i=0; i<recipes.size(); i++) {
            System.out.println((i+1) + ". "+ recipes.get(i).getName() + " - $" + recipes.get(i).getPrice());
        }
    }
}
