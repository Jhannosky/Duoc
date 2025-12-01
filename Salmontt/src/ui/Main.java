package ui;

import data.GestorUnidades;
import model.UnidadOperativa;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Unidades Operativas - Salmontt ===\n");

        UnidadOperativa[] unidades = GestorUnidades.crearUnidadesDePrueba();

        for (UnidadOperativa u : unidades) {
            System.out.println(u.toString());
        }

        System.out.println("\n=== Fin del programa ===");
    }
}
