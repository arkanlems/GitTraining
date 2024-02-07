package org.example;

import Dia_3.Recipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Recipe> recipes = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        int option;

        do {
            System.out.println("Bienvenido al menú del restaurante!");
            System.out.println("¿Qué deseas hacer? \n1) Añadir receta \n2) Reemplazar receta \n3) Mostrar la cantidad de recetas \n4) Mostrar las recetas \n5) Salir");
            option = scan.nextInt();
            scan.nextLine(); // Consume el salto de línea

            switch (option) {
                case 1:
                    System.out.println("Ingrese el nombre de la receta:");
                    String name = scan.nextLine();
                    System.out.println("Ingrese el precio de la receta:");
                    double price = scan.nextDouble();
                    recipes.add(new Recipe(name, price));
                    System.out.println("Receta añadida correctamente.");
                    break;
                case 2:
                    System.out.println("Ingrese el número de la receta que desea reemplazar:");
                    int index = scan.nextInt() - 1;
                    scan.nextLine(); // Consume el salto de línea
                    if (index >= 0 && index < recipes.size()) {
                        System.out.println("Ingrese el nuevo nombre de la receta:");
                        String newName = scan.nextLine();
                        System.out.println("Ingrese el nuevo precio de la receta:");
                        double newPrice = scan.nextDouble();
                        recipes.set(index, new Recipe(newName, newPrice));
                        System.out.println("Receta reemplazada correctamente.");
                    } else {
                        System.out.println("Índice de receta no válido.");
                    }
                    break;
                case 3:
                    System.out.println("Cantidad de recetas: " + recipes.size());
                    break;
                case 4:
                    System.out.println("Recetas:");
                    for (Recipe r : recipes) {
                        System.out.println("- " + r.getName() + ": $" + r.getPrice());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (option != 5);
    }
    static class Recipe {
        private String name;
        private double price;


        public Recipe() {
            this.name = "";
            this.price = 0.0;
        }


        public Recipe(String name, double price) {
            this.name = name;
            this.price = price;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }

}


