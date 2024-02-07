import java.util.Scanner;

public class Virtual {
   public void VirtualRestaurant() {

      Restaurant.getMenu().addRecipe("Burger", 9.99);
      Restaurant.getMenu().addRecipe("Pizza", 12.99);
      Restaurant.getMenu().addRecipe("Hot dog", 5.99);
      Restaurant.getMenu().addRecipe("Spaghetti", 16.99);
      Restaurant.getMenu().addRecipe("Chicken", 14.99);
      Restaurant.getMenu().addRecipe("Beef", 10.99);
      Restaurant.getMenu().addRecipe("Salmon", 20.99);
      Restaurant.getMenu().addRecipe("Soup", 2.99);

      Scanner scan = new Scanner(System.in);
      System.out.println("Welcome to " + Restaurant.getName());
      boolean running = true;

      while (running) {
         System.out.println("What option would you like to make today? (Please enter the corresponding number)" +
                 "\n 1. Add recipes" +
                 "\n 2. Change recipe" +
                 "\n 3. Print the amount of recipes" +
                 "\n 4. Print the menu" +
                 "\n 5. Exit restaurant");
         String option = scan.nextLine();

         switch (option) {
            case "1":
               double price = 0;
               System.out.println("Please enter the recipe name: ");
               String name = scan.nextLine();

               System.out.println("Please enter the recipe price: ");
               String inputPrice = scan.nextLine();
               if (inputPrice.matches("^\\d+(\\.\\d+)?$")){
                  price = Double.parseDouble(inputPrice);
               }
               Restaurant.getMenu().addRecipe(name, price);
               System.out.println("This is the new menu: ");
               Restaurant.getMenu().printMenu();
               break;
            case "2":
               Restaurant.getMenu().replaceRecipe(3, "Salad", 3.99);
               break;
            case "3":
               Restaurant.getMenu().printSizeMenu();
               break;
            case "4":
               Restaurant.getMenu().printMenu();
               break;
            case "5":
               running = false;
               break;
            default:
               System.out.println("Invalid option. Please try again.");
         }
      }
      System.out.println("Exiting the restaurant. See you soon!");
      scan.close();
   }
}
