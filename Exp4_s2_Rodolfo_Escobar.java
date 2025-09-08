import java.util.Scanner;

public class Exp4_s2_Rodolfo_Escobar {

    public static void main(String[] args) {
        // Precios base por zona
        try (Scanner scanner = new Scanner(System.in)) {
            // Precios base por zona
            final int PRECIO_ZONA_A = 15000;
            final int PRECIO_ZONA_B = 10000;
            final int PRECIO_ZONA_C = 7000;
            
            boolean continuarComprando = true;
            
            for (; continuarComprando;) {
                // Menú principal
                System.out.println("=== TEATRO MORO ===");
                System.out.println("1. Comprar entrada");
                System.out.println("2. Salir");
                System.out.print("Seleccione una opción: ");
                String opcion = scanner.nextLine();
                
                switch (opcion) {
                    case "1" -> {
                        // Mostrar plano de ubicaciones
                        System.out.println("\nPlano del teatro:");
                        System.out.println("[Zona A] - Frontal - $15.000");
                        System.out.println("[Zona B] - Central - $10.000");
                        System.out.println("[Zona C] - Lateral - $7.000");
                        
                        // Selección de zona
                        System.out.print("\nSeleccione la zona (A, B o C): ");
                        String zona = scanner.nextLine().toUpperCase();
                        
                        int precioBase ;
                    switch (zona) {
                        case "A" -> precioBase = PRECIO_ZONA_A;
                        case "B" -> precioBase = PRECIO_ZONA_B;
                        case "C" -> precioBase = PRECIO_ZONA_C;
                        default -> {
                            System.out.println("Zona inválida. Intente nuevamente.\n");
                            continue; // vuelve al menú principal
                        }
                    }
                        
                        // Solicitar edad
                        int edad = 0;
                        while (true) {
                            try {
                                System.out.print("Ingrese su edad: ");
                                edad = Integer.parseInt(scanner.nextLine());
                                if (edad <= 0 || edad > 120) {
                                    System.out.println("Edad inválida. Intente nuevamente.");
                                } else {
                                    break;
                                }
                            } catch (NumberFormatException e) {
                                System.out.println("Entrada no válida. Debe ingresar un número.");
                            }
                        }
                        
                        // Aplicar descuento
                        double descuento = 0.0;
                        if (edad < 25) {
                            descuento = 0.10; // 10% estudiantes
                            System.out.println("Descuento aplicado: 10% (Estudiante)");
                        } else if (edad >= 60) {
                            descuento = 0.15; // 15% tercera edad
                            System.out.println("Descuento aplicado: 15% (Tercera edad)");
                        } else {
                            System.out.println("No se aplica descuento.");
                        }
                        
                        // Calcular precio final
                        double precioFinal = precioBase - (precioBase * descuento);
                        
                        // Mostrar resumen
                        System.out.println("\n--- Resumen de la compra ---");
                        System.out.println("Zona seleccionada: " + zona);
                        System.out.println("Precio base: $" + precioBase);
                        
                        if (descuento > 0) {
                            System.out.println("Descuento: " + (int)(descuento * 100) + "%");
                        } else {
                            System.out.println("Descuento: No aplica");
                        }
                        
                        System.out.println("Precio final a pagar: $" + (int)precioFinal);
                        System.out.println("----------------------------\n");
                        
                        // Preguntar si desea continuar
                        String respuesta;
                        do {
                            System.out.print("¿Desea realizar otra compra? (S/N): ");
                            respuesta = scanner.nextLine().toUpperCase();
                            
                            if (respuesta.equals("N")) {
                                continuarComprando = false;
                                System.out.println("Gracias por su compra. ¡Hasta luego!");
                            } else if (!respuesta.equals("S")) {
                                System.out.println("Respuesta no válida. Intente con S o N.");
                            }
                            
                        } while (!respuesta.equals("S") && !respuesta.equals("N"));
                    }
                        
                    case "2" -> {
                        System.out.println("Gracias por usar el sistema del Teatro Moro. ¡Adiós!");
                        continuarComprando = false;
                    }
                        
                    default -> System.out.println("Opción inválida. Intente nuevamente.\n");
                }
            }
        }
    }
}
