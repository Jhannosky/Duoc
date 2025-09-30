import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Entrada {
    // Variables de instancia
    private final String ubicacion;
    private final double costoBase;
    private final double descuento;
    private final double costoFinal;

    // Constructor
    public Entrada(String ubicacion, double costoBase, double descuento, double costoFinal) {
        this.ubicacion = ubicacion;
        this.costoBase = costoBase;
        this.descuento = descuento;
        this.costoFinal = costoFinal;
    }

    // Getters
    public String getUbicacion() { return ubicacion; }
    public double getCostoBase() { return costoBase; }
    public double getDescuento() { return descuento; }
    public double getCostoFinal() { return costoFinal; }

    // Método para imprimir boleta
    public void imprimirBoleta() {
        System.out.println("=================================");
        System.out.println("         TEATRO MORO");
        System.out.println(" Ubicación: " + ubicacion);
        System.out.println(" Costo base: $" + costoBase);
        System.out.println(" Descuento aplicado: $" + descuento);
        System.out.println(" Costo final: $" + costoFinal);
        System.out.println(" ¡Gracias por preferirnos!");
        System.out.println("=================================");
    }
}

public class Exp6_S7_Rodolfo_Escobar {
    // Variables estáticas (estadísticas globales)
    private static int totalEntradasVendidas = 0;
    private static double totalIngresos = 0.0;
    private static final String NOMBRE_TEATRO = "Teatro Moro";

    // Lista para almacenar las ventas
    private static final List<Entrada> ventas = new ArrayList<>();

    public static void main(String[] args) {
        // Variables locales
        try (Scanner sc = new Scanner(System.in)) {
            // Variables locales
            int opcion;
            String ubicacion;
            double costoBase;
            double descuento;
            double costoFinal;
            
            do {
                // Menú principal
                System.out.println("\n===== " + NOMBRE_TEATRO + " =====");
                System.out.println("1. Venta de entradas");
                System.out.println("2. Visualizar resumen de ventas");
                System.out.println("3. Generar boleta");
                System.out.println("4. Calcular ingresos totales");
                System.out.println("5. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine(); // limpiar buffer
                
                switch (opcion) {
                    case 1 -> {
                        // Venta de entradas
                        System.out.println("\nSeleccione ubicación:");
                        System.out.println("1. VIP ($20000)");
                        System.out.println("2. Platea ($15000)");
                        System.out.println("3. Balcón ($10000)");
                        System.out.print("Opción: ");
                        int ubic = sc.nextInt();
                        sc.nextLine();
                        
                        switch (ubic) {
                            case 1 -> {
                                ubicacion = "VIP"; costoBase = 20000;
                        }
                            case 2 -> {
                                ubicacion = "Platea"; costoBase = 15000;
                        }
                            case 3 -> {
                                ubicacion = "Balcón"; costoBase = 10000;
                        }
                            default -> {
                                System.out.println("Ubicación inválida.");
                                continue;
                        }
                        }
                        
                        // Preguntar por descuento
                        System.out.println("¿Es estudiante (E) o tercera edad (T)? (N = Ninguno)");
                        char tipo = sc.next().toUpperCase().charAt(0);
                        
                        descuento = switch (tipo) {
                        case 'E' -> costoBase * 0.10;
                        case 'T' -> costoBase * 0.15;
                        default -> 0;
                    };
                        
                        costoFinal = costoBase - descuento;
                        
                        // Crear entrada y almacenarla
                        Entrada entrada = new Entrada(ubicacion, costoBase, descuento, costoFinal);
                        ventas.add(entrada);
                        
                        totalEntradasVendidas++;
                        totalIngresos += costoFinal;
                        
                        System.out.println("¡Entrada registrada con éxito!");
                    }
                        
                    case 2 -> {
                        // Resumen de ventas
                        System.out.println("\n===== Resumen de Ventas =====");
                        if (ventas.isEmpty()) {
                            System.out.println("No hay ventas registradas.");
                        } else {
                            for (int i = 0; i < ventas.size(); i++) {
                                Entrada e = ventas.get(i);
                                System.out.println((i+1) + ". " + e.getUbicacion() +
                                        " | Costo Final: $" + e.getCostoFinal() +
                                        " | Descuento: $" + e.getDescuento());
                            }
                        }
                    }
                        
                    case 3 -> {
                        // Generar boletas
                        if (ventas.isEmpty()) {
                            System.out.println("No hay ventas para generar boletas.");
                        } else {
                            for (Entrada e : ventas) {
                                e.imprimirBoleta();
                            }
                        }
                    }
                        
                    case 4 -> {
                        // Ingresos totales
                        System.out.println("\n===== Ingresos Totales =====");
                        System.out.println("Entradas vendidas: " + totalEntradasVendidas);
                        System.out.println("Total recaudado: $" + totalIngresos);
                    }
                        
                    case 5 -> System.out.println("Gracias por su compra. ¡Hasta pronto!");
                        
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 5);
        }
    }

    public static String getNombreTeatro() {
    return NOMBRE_TEATRO;
    }

}
