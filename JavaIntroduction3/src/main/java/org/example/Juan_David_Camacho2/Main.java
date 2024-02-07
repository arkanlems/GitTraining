package org.example.Juan_David_Camacho2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<Integer, Plate> menu = new HashMap<Integer, Plate>();
        populateMenu(menu);
        OptionMenu.displayMenu(menu);

    }

    private static void populateMenu(Map<Integer, Plate> menu) {

        menu.put(1, new Plate("Burger", 10000));
        menu.put(2, new Plate("Hot Dog", 8900));
        menu.put(3, new Plate("French Fries", 2500));
        menu.put(4, new Plate("Burrito", 12000));
        menu.put(5, new Plate("American Burger", 15000));
        menu.put(6, new Plate("Chili Tacos", 8900));
        menu.put(7, new Plate("Classic Sandwich", 6800));
        menu.put(8, new Plate("Soda", 3000));

    }
}
