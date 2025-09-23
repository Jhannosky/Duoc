import java.util.Scanner;

public class Exp2_S6_Rodolfo_escobar {
    static final int TOTAL_ASIENTOS = 10;
    static String[] asientos = new String[TOTAL_ASIENTOS]; // "Libre", "Reservado", "Vendido"
    static double precioEntrada = 5000;

    // Variables de instancia
    static String nombreTeatro = "Teatro Moro";

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            inicializarAsientos();
            
            int opcion;
            do {
                System.out.println("\n===== " + nombreTeatro + " =====");
                System.out.println("1. Reservar un asiento");
                System.out.println("2. Modificar una reserva");
                System.out.println("3. Comprar entradas");
                System.out.println("4. Imprimir boleta");
                System.out.println("5. Salir");
                System.out.print("Elige una opción: ");
                opcion = sc.nextInt();
                
                switch(opcion) {
                    case 1 -> reservarAsiento(sc);
                    case 2 -> modificarReserva(sc);
                    case 3 -> comprarEntrada(sc);
                    case 4 -> imprimirBoleta(sc);
                    case 5 -> System.out.println("Gracias por usar el sistema.");
                    default -> System.out.println("Opción inválida.");
                }
            } while (opcion != 5);
        }
    }

    // Inicializa todos los asientos como "Libre"
    public static void inicializarAsientos() {
        for (int i = 0; i < TOTAL_ASIENTOS; i++) {
            asientos[i] = "Libre";
        }
    }

    // Mostrar estado actual de los asientos
    public static void mostrarAsientos() {
        System.out.println("Estado de los asientos:");
        for (int i = 0; i < TOTAL_ASIENTOS; i++) {
            System.out.println("Asiento " + i + ": " + asientos[i]);
        }
    }

    // Reservar asiento
    public static void reservarAsiento(Scanner sc) {
        mostrarAsientos();
        System.out.print("Ingresa el número de asiento a reservar (0-" + (TOTAL_ASIENTOS-1) + "): ");
        int numero = sc.nextInt();

        if (numero >= 0 && numero < TOTAL_ASIENTOS) {
            if (asientos[numero].equals("Libre")) {
                asientos[numero] = "Reservado";
                System.out.println("Asiento " + numero + " reservado correctamente.");
            } else {
                System.out.println("Ese asiento no está disponible.");
            }
        } else {
            System.out.println("Número de asiento inválido.");
        }
    }

    // Modificar reserva
    public static void modificarReserva(Scanner sc) {
        mostrarAsientos();
        System.out.print("Ingresa el número de asiento reservado que deseas cambiar: ");
        int actual = sc.nextInt();

        if (actual >= 0 && actual < TOTAL_ASIENTOS && asientos[actual].equals("Reservado")) {
            System.out.print("Ingresa el nuevo asiento que deseas reservar: ");
            int nuevo = sc.nextInt();

            if (nuevo >= 0 && nuevo < TOTAL_ASIENTOS && asientos[nuevo].equals("Libre")) {
                asientos[actual] = "Libre";
                asientos[nuevo] = "Reservado";
                System.out.println("Reserva modificada correctamente.");
            } else {
                System.out.println("El nuevo asiento no está disponible.");
            }
        } else {
            System.out.println("El asiento original no está reservado o es inválido.");
        }
    }

    // Comprar asiento reservado
    public static void comprarEntrada(Scanner sc) {
        mostrarAsientos();
        System.out.print("Ingresa el número de asiento reservado para comprar: ");
        int numero = sc.nextInt();

        if (numero >= 0 && numero < TOTAL_ASIENTOS && asientos[numero].equals("Reservado")) {
            asientos[numero] = "Vendido";
            System.out.println("Compra realizada correctamente.");
        } else {
            System.out.println("El asiento no está reservado o no es válido.");
        }
    }

    // Imprimir boleta
    public static void imprimirBoleta(Scanner sc) {
        mostrarAsientos();
        System.out.print("Ingresa el número de asiento vendido para imprimir boleta: ");
        int numero = sc.nextInt();

        if (numero >= 0 && numero < TOTAL_ASIENTOS && asientos[numero].equals("Vendido")) {
            System.out.println("\n----- BOLETA -----");
            System.out.println("Teatro: " + nombreTeatro);
            System.out.println("Asiento: " + numero);
            System.out.println("Cantidad: 1");
            System.out.println("Total: $" + precioEntrada);
            System.out.println("------------------");

            // 🔍 Punto de depuración 1
            // Verifica si la boleta imprime el asiento correcto
            // 🔍 Punto de depuración 2
            // Verifica el valor total de la boleta
            // 🔍 Punto de depuración 3
            // Confirmar que solo asientos "Vendidos" permiten boleta
        } else {
            System.out.println("El asiento no está vendido o es inválido.");
        }
    }
}
