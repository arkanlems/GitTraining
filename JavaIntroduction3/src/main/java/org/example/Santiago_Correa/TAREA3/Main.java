package org.example.Santiago_Correa.TAREA3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        init(menu);
        initMenuRestaurant(scanner, menu);
    }

    static void initMenuRestaurant(Scanner scanner, Menu menu) {
        boolean flag = true;

        while (flag) {
            System.out.println("Choose the option");
            System.out.println("1, Add new recipe to menu");
            System.out.println("2, Display the amount of recipes on the menu");
            System.out.println("3, Display whole menu");
            System.out.println("4. Replace the third position menu");
            System.out.println("5. Exit");

            if (scanner.hasNextInt()) {
                int number = scanner.nextInt();
                scanner.nextLine();
                switch (number) {
                    case 1:
                        System.out.println("Enter name recipe");
                        String name;
                        name = scanner.nextLine();
                        System.out.println("Enter cost recipe");
                        double price;
                        price = scanner.nextDouble();
                        scanner.nextLine();
                        menu.addNewsRecipes(new Recipe(name, price));
                        break;
                    case 2:
                        Integer result = menu.getAmountRecipes();
                        System.out.println("The amount recipes is :"+ result);
                        break;
                    case 3:
                        System.out.println("The menu complete es:");
                        menu.getAllMenu();
                        break;
                    case 4:
                        System.out.println("Enter name recipe");
                        String nameThird = scanner.nextLine();
                        System.out.println("Enter cost recipe");
                        double priceThird = scanner.nextDouble();
                        menu.replaceThirdPositionRecipes(new Recipe(nameThird, priceThird));
                        break;
                    case 5:
                        System.out.println("Closing the program...");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid number entered.");
                        System.exit(0);
                        break;
                }
            } else {
                System.out.println("Invalid number entered.");
                System.exit(0);
                break;
            }
        }
    }

    static void init(Menu menu) {
        Initializer.initializeMenu(menu.getMenuList());
    }
}

