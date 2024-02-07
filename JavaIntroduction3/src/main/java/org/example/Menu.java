package org.example;

import java.util.Scanner;

public class Menu {
    public static int mostrarMenu(){
        System.out.println("----------------------------");
        System.out.println("1. sfasdas");
        System.out.println("2. asdasdas");
        System.out.println("3. asdasdasd");
        System.out.println("----------------------------");
        Scanner scan = new Scanner(System.in);
        int entero = scan.nextInt();
        return entero;
    }
}
