package org.example.Luisa_Fuentes.Tarea3;

import java.util.List;

public class Menu {
    private List<Receta> recetas_guardadas;

    public Menu(List<Receta> recetas_guardadas) {
        this.recetas_guardadas = recetas_guardadas;
    }

    public List<Receta> getRecetas_guardadas() {
        return recetas_guardadas;
    }

    public void setRecetas_guardadas(List<Receta> recetas_guardadas) {
        this.recetas_guardadas = recetas_guardadas;
    }




}
