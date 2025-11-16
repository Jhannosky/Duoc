package ui;

import data.GestorDatos;
import model.CentroCultivo;
import java.util.ArrayList;

/**
 * Clase principal del programa SalmonttApp.
 * Lee los centros de cultivo, los muestra y aplica filtros.
 */
public class Main {
    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();

        // Cargar los datos desde el archivo
        ArrayList<CentroCultivo> centros = gestor.cargarCentros("resources/centros.txt");

        System.out.println("=== LISTA DE CENTROS DE CULTIVO ===");
        for (CentroCultivo c : centros) {
            System.out.println(c);
        }

        // Filtrar los centros con producción superior a 1000 toneladas
        System.out.println("\n=== CENTROS CON PRODUCCIÓN > 1000 TONELADAS ===");
        for (CentroCultivo c : centros) {
            if (c.getToneladas() > 1000) {
                System.out.println(c);
            }
        }
    }
}
