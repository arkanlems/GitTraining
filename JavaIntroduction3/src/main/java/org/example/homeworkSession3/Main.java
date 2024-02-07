package org.example.homeworkSession3;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int option = 0;
        System.out.println("Write your restaurant´s name");
        String name = sc.nextLine();
        Restaurant restaurant = new Restaurant();
        restaurant.setName(name);
        List<Recipe> menu = restaurant.createReceipes();
        restaurant.setMenu(menu);
        do {
            System.out.println("1. Create new recipe\n2. Print menu size\n3. replace a recipe\n4. Print menu");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Name:");
                    String recipeName = sc.nextLine();
                    System.out.print("Steps");
                    String steps = sc.nextLine();
                    System.out.print("Price");
                    Double price = sc.nextDouble();
                    restaurant.getMenu().add(new Recipe(recipeName, steps, price));
                    break;
                case 2:
                    System.out.println("Total recipes: "+restaurant.getMenu().size());
                    break;
                case 3:
                    restaurant.getMenu().set(2,new Recipe("Vegetable Stir-Fry", "1. Chop assorted vegetables such as bell peppers, broccoli, and carrots.\n2. Heat oil in a wok or skillet." +
                            "\n3. Stir-fry the vegetables until tender-crisp.\n4. Season with soy sauce and your favorite spices.", 7.99));
                    break;
                case 4:
                    System.out.println(restaurant.printMenu());
                default:
                    System.out.println("Please enter an valid option");
                    break;
            }
        } while (option != 4);
    }
}