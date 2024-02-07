package org.example.Luisa_Fuentes;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        
        mostrarOpciones();
        
    }
    
    public static void mostrarOpciones(){
        boolean continuar = true;

        Scanner scan = new Scanner(System.in);
        System.out.printf("Ingresa el nombre del restaurante: ");
        scan = new Scanner(System.in);
        String nombre_restaurante = scan.nextLine();
        
        List<Receta> recetas_guardadas = new ArrayList<Receta>();
        Menu menu = new Menu(recetas_guardadas);
        Restaurante restaurante = new Restaurante(nombre_restaurante, menu);

        int contador=0;

        while(continuar == true){
            System.out.printf("Selecciona la operación que deseas realizar\n" +
                    "1. Añadir recetas al menú \n" +
                    "2. Remplazar receta por una vegana \n"+
                    "3. Ver cantidad de recetas del menu \n"+
                    "4. Ver menu \n"+
                    "5. Salir \n");
            int opcion = scan.nextInt();

            if (opcion == 1) {
                while (contador<5){
                    System.out.printf("Ingresa el nombre de la receta #"+(contador+1)+ " a agregar al menu: ");
                    scan = new Scanner(System.in);
                    String nombre = scan.nextLine();

                    if (!nombre.isEmpty()) {
                        System.out.printf("Ingresa el precio de la receta #"+(contador+1)+ " a agregar al menu: ");
                        scan = new Scanner(System.in);
                        double precio = scan.nextDouble();
                        Receta receta = new Receta(nombre, precio);

                        restaurante.getMenu().getRecetas_guardadas().add(receta);
                        contador = contador + 1;

                    }
                }
            }
            else if (opcion == 2){
                List<Receta>  lista_recetas_menu= restaurante.getMenu().getRecetas_guardadas();
                if (lista_recetas_menu.size()>=3) {
                    lista_recetas_menu.set(2, new Receta("vegana", 45000));
                    System.out.printf("La 3ra receta se ha reemplazado por una receta vegana");
                }
                else{
                    System.out.printf("No hay suficiente recetas para que la 3ra receta se ha reemplazada por una receta vegana");

                }
            }
            else if (opcion == 3){
                int cant_recetas=restaurante.getMenu().getRecetas_guardadas().size();
                System.out.printf("La cantidad de recetas del menu es: "+ cant_recetas+"\n");
            }
            else if (opcion == 4){
                for (Receta receta : restaurante.getMenu().getRecetas_guardadas()) {
                    System.out.println("Receta: "+ receta.getNombre() + ", Precio: "+ receta.getPrecio());
                }
                if (restaurante.getMenu().getRecetas_guardadas().size() == 0){
                    System.out.printf("No hay recetas en el menu aún\n");
                }
            }
            else{
                continuar = false;
            }
        }
        
    }
}