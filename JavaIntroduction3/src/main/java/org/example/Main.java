package org.example;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        Menu.mostrarMenu();

        String numero = String.valueOf(12);

        int [] enteros = new int[4];

        List<Integer> enterosLista = new ArrayList<>();
        List<String> estudiantesLista = new ArrayList<>();

        estudiantesLista.add(("esteban"));
        estudiantesLista.add("juan");
        estudiantesLista.add("omar");
        estudiantesLista.add("maria");
        estudiantesLista.add("daniela");
        estudiantesLista.add("daniel");
        estudiantesLista.add("sebastian");

       

        /*

        *key        value
         [esteban][1]
        * [juan][3]
        * [Daniela][0]
        * [Sebastian][2]
        *
        * */


    }
    private int Menu(int entero){
        entero= entero+1;
        return 0;
    }
}