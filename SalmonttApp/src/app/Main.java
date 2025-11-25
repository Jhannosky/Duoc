package app;

import java.util.Scanner;
import service.SalmonService;

public class Main {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            SalmonService servicio = new SalmonService();
            
            System.out.println("=== Bienvenido a SalmonttApp ===");
            servicio.cargarDesdeArchivo("data/salmones.csv");
            
            int opcion;
            do {
                System.out.println("\n--- MENÚ PRINCIPAL ---");
                System.out.println("1. Mostrar todos los salmones");
                System.out.println("2. Buscar por especie");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();
                
                switch (opcion) {
                    case 1 -> servicio.mostrarSalmones();
                    case 2 -> {
                        System.out.print("Ingrese especie a buscar: ");
                        String especie = sc.nextLine();
                        servicio.buscarPorEspecie(especie);
                    }
                    case 0 -> System.out.println("Saliendo del sistema...");
                    default -> System.out.println("Opción no válida.");
                }
                
            } while (opcion != 0);
        }
    }
}
