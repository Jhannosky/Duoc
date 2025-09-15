
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Exp5_s2_Rodolfo_Escobar {

    // Variables globales
    static int totalEntradasVendidas = 0;
    static double totalIngresos = 0;
    static int totalEstudiantes = 0;

    static ArrayList<Entrada> entradasVendidas = new ArrayList<>();
    static String nombreTeatro = "Teatro Moro";
    static int capacidadSala;
    static int entradasDisponibles;
    static double precioBase;

    static class Entrada {

        int numero;
        String ubicacion;
        String tipoCliente;
        double precioFinal;

        Entrada(int numero, String ubicacion, String tipoCliente, double precioFinal) {
            this.numero = numero;
            this.ubicacion = ubicacion;
            this.tipoCliente = tipoCliente;
            this.precioFinal = precioFinal;
        }

        void mostrarInfo() {
            System.out.println("Número: " + numero);
            System.out.println("Ubicación: " + ubicacion);
            System.out.println("Tipo Cliente: " + tipoCliente);
            System.out.printf("Precio Final: $%.2f%n", precioFinal);
            System.out.println("-------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner;
        scanner = new Scanner(System.in);
        int contadorEntradas = 1;

        // solicitar datos 
        System.out.print("Ingrese capacidad de la sala: ");
        capacidadSala = obtenerEntero(scanner);

        System.out.print("Ingrese precio base de la entrada: ");
        precioBase = obtenerDouble(scanner);

        entradasDisponibles = capacidadSala;

        int opcion;
        do {
            System.out.println("\n*** Bienvenido al " + nombreTeatro + " ***");
            System.out.println("1. Venta de entradas");
            System.out.println("2. Ver promociones");
            System.out.println("3. Buscar entradas");
            System.out.println("4. Eliminar entrada");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = obtenerEntero(scanner);

            switch (opcion) {
                case 1 -> {
                    if (entradasDisponibles <= 0) {
                        System.out.println("No hay entradas disponibles.");
                        break;
                    }

                    String ubicacion;
                    List<String> ubicacionesValidas = Arrays.asList("VIP", "Platea", "General");
                    while (true) {
                        System.out.print("Ingrese ubicación (VIP, Platea, General): ");
                        ubicacion = scanner.nextLine().trim();
                        if (ubicacionesValidas.contains(ubicacion)) {
                            break;
                        }
                        System.out.println("Ubicación inválida.");
                    }

                    System.out.print("¿Es estudiante? (s/n): ");
                    String esEstudiante = scanner.nextLine().trim();

                    System.out.print("¿Es de la tercera edad? (s/n): ");
                    String esTerceraEdad = scanner.nextLine().trim();

                    if (esEstudiante.equalsIgnoreCase("s") && esTerceraEdad.equalsIgnoreCase("s")) {
                        System.out.println("No puede ser estudiante y de la tercera edad al mismo tiempo.");
                        break;
                    }

                    double descuento = 0;
                    String tipoCliente = "normal";

                    if (esEstudiante.equalsIgnoreCase("s")) {
                        descuento = 0.10;
                        tipoCliente = "estudiante";
                        totalEstudiantes++;
                    } else if (esTerceraEdad.equalsIgnoreCase("s")) {
                        descuento = 0.15;
                        tipoCliente = "tercera edad";
                    }

                    double precioFinal = precioBase - (precioBase * descuento);

                    // Usar el contador global
                    Entrada nuevaEntrada = new Entrada(contadorEntradas++, ubicacion, tipoCliente, precioFinal);
                    entradasVendidas.add(nuevaEntrada);
                    entradasDisponibles--;
                    totalEntradasVendidas++;
                    totalIngresos += precioFinal;

                    System.out.println("Entrada vendida con éxito.");
                    System.out.printf("Precio final: $%.2f%n", precioFinal);
                }

                case 2 ->
                    mostrarPromociones();

                case 3 ->
                    buscarEntradas(scanner);

                case 4 ->
                    eliminarEntrada(scanner);

                case 5 -> {
                    System.out.println("Gracias por usar el sistema del " + nombreTeatro);
                    System.out.println("Entradas vendidas: " + totalEntradasVendidas);
                    System.out.printf("Total ingresos: $%.2f%n", totalIngresos);
                    System.out.println("Estudiantes atendidos: " + totalEstudiantes);
                }

                default ->
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 5);

        scanner.close();
    }

    private static void mostrarPromociones() {
        System.out.println("\n*** Promociones Disponibles ***");
        System.out.println("- 10% de descuento para estudiantes.");
        System.out.println("- 15% de descuento para personas de la tercera edad.");
        System.out.println("- Compra 3 entradas y obtén 1 entrada general gratis (en boletería).");
    }

    private static void buscarEntradas(Scanner scanner) {
        System.out.println("\nBuscar por:");
        System.out.println("1. Número de entrada");
        System.out.println("2. Ubicación");
        System.out.println("3. Tipo de cliente");
        System.out.print("Seleccione una opción: ");
        int busqueda = obtenerEntero(scanner);

        boolean encontrado = false;

        switch (busqueda) {
            case 1 -> {
                System.out.print("Ingrese número de entrada: ");
                int numeroBuscar = obtenerEntero(scanner);

                for (Entrada e : entradasVendidas) {
                    if (e.numero == numeroBuscar) {
                        e.mostrarInfo();
                        encontrado = true;
                        break;
                    }
                }
                break;
            }

            case 2 -> {
                System.out.print("Ingrese ubicación (VIP, Platea, General): ");
                String ubiBuscar = scanner.nextLine().trim();

                for (Entrada e : entradasVendidas) {
                    if (e.ubicacion.equalsIgnoreCase(ubiBuscar)) {
                        e.mostrarInfo();
                        encontrado = true;
                    }
                }
                break;
            }

            case 3 -> {
                System.out.print("Ingrese tipo de cliente (normal, estudiante, tercera edad): ");
                String tipoBuscar = scanner.nextLine().trim();

                for (Entrada e : entradasVendidas) {
                    if (e.tipoCliente.equalsIgnoreCase(tipoBuscar)) {
                        e.mostrarInfo();
                        encontrado = true;
                    }
                }
                break;
            }

            default ->
                System.out.println("Opción no válida.");
        }

        if (!encontrado) {
            System.out.println("No se encontraron entradas con esos datos.");
        }
    }

    private static void eliminarEntrada(Scanner scanner) {
        System.out.print("Ingrese número de entrada a eliminar: ");
        int numeroEliminar = obtenerEntero(scanner);

        boolean eliminado = false;
        for (int i = 0; i < entradasVendidas.size(); i++) {
            if (entradasVendidas.get(i).numero == numeroEliminar) {
                totalIngresos -= entradasVendidas.get(i).precioFinal;
                totalEntradasVendidas--;
                entradasDisponibles++;

                entradasVendidas.remove(i);
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            System.out.println("Entrada eliminada con éxito.");
        } else {
            System.out.println("No se encontró la entrada.");
        }
    }

    // Métodos auxiliares para validar entrada numérica
    private static int obtenerEntero(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, ingrese un número entero válido: ");
            scanner.nextLine();
        }
        int valor = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }

    private static double obtenerDouble(Scanner scanner) {
        while (!scanner.hasNextDouble()) {
            System.out.print("Por favor, ingrese un número válido: ");
            scanner.nextLine();
        }
        double valor = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer
        return valor;
    }
}
