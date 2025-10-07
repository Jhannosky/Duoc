import java.util.ArrayList;
import java.util.Scanner;

// Clase Cliente (sin public)
class Cliente {
    String nombre;
    String tipo; // Estudiante, TerceraEdad o General

    public Cliente(String nombre, int edad) {
        this.nombre = nombre;

        if (edad >= 60) {
            this.tipo = "TerceraEdad";
        } else if (edad <= 25) {
            this.tipo = "Estudiante";
        } else {
            this.tipo = "General";
        }
    }
}

// Clase Asiento
class Asiento {
    int numero;
    boolean disponible;

    public Asiento(int numero) {
        this.numero = numero;
        this.disponible = true;
    }
}

// Clase Venta
class Venta {
    int idVenta;
    Cliente cliente;
    Asiento asiento;
    double precioFinal;
    String fecha;

    public Venta(int idVenta, Cliente cliente, Asiento asiento, double precioFinal, String fecha) {
        this.idVenta = idVenta;
        this.cliente = cliente;
        this.asiento = asiento;
        this.precioFinal = precioFinal;
        this.fecha = fecha;
    }
}

// Clase Evento
class Evento {
    int idEvento;
    String nombreEvento;
    ArrayList<Venta> ventas;

    public Evento(int idEvento, String nombreEvento) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.ventas = new ArrayList<>();
    }

    public int getIdEvento() {
        return idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }
}

// Clase principal
public class Exp7_S8_Rodolfo_Escobar {

    static Asiento[] asientos = new Asiento[100];
    static ArrayList<Evento> eventos = new ArrayList<>();
    static int idVentaActual = 1;

    public static void inicializarAsientos() {
        for (int i = 0; i < asientos.length; i++) {
            asientos[i] = new Asiento(i + 1);
        }
    }

    public static double aplicarDescuento(String tipoCliente, double precioBase) {
        if (tipoCliente.equals("Estudiante")) {
            return precioBase * 0.9; // 10%
        } else if (tipoCliente.equals("TerceraEdad")) {
            return precioBase * 0.85; // 15%
        }
        return precioBase;
    }

    public static boolean validarEdad(int edad) {
        return edad >= 0 && edad <= 120;
    }

    public static void venderEntrada(Evento evento, Scanner sc) {
        System.out.println("🔹 Ingrese el nombre del cliente:");
        String nombre = sc.nextLine();

        System.out.println("🔹 Ingrese la edad del cliente:");
        int edad;

        try {
            edad = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Edad inválida. Venta cancelada.");
            return;
        }

        if (!validarEdad(edad)) {
            System.out.println("❌ Edad fuera de rango. Venta cancelada.");
            return;
        }

        System.out.println("🔹 Ingrese el precio base de la entrada:");
        double precioBase;

        try {
            precioBase = Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ Precio inválido. Venta cancelada.");
            return;
        }

        System.out.println("🔹 Ingrese la fecha de la venta (dd-mm-aaaa):");
        String fecha = sc.nextLine();

        for (Asiento asiento : asientos) {
            if (asiento.disponible) {
                Cliente cliente = new Cliente(nombre, edad);
                double precioFinal = aplicarDescuento(cliente.tipo, precioBase);

                asiento.disponible = false;

                Venta venta = new Venta(idVentaActual++, cliente, asiento, precioFinal, fecha);
                evento.ventas.add(venta);

                System.out.println("✅ Venta realizada:");
                System.out.println("Cliente: " + cliente.nombre + " (" + cliente.tipo + ")");
                System.out.println("Asiento asignado: " + asiento.numero);
                System.out.println("Precio final: $" + precioFinal);
                System.out.println("----------------------------");
                return;
            }
        }

        System.out.println("❌ No hay asientos disponibles.");
    }

    public static void cancelarVenta(Evento evento, Scanner sc) {
        System.out.println("🔹 Ingrese el ID de la venta a cancelar:");
        int idVenta;

        try {
            idVenta = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("❌ ID inválido.");
            return;
        }

        for (int i = 0; i < evento.ventas.size(); i++) {
            Venta venta = evento.ventas.get(i);
            if (venta.idVenta == idVenta) {
                venta.asiento.disponible = true;
                evento.ventas.remove(i);
                System.out.println("🗑️ Venta cancelada correctamente.");
                return;
            }
        }

        System.out.println("❌ Venta no encontrada.");
    }

    public static void mostrarVentas(Evento evento) {
        System.out.println("📋 Ventas registradas:");
        if (evento.ventas.isEmpty()) {
            System.out.println("No hay ventas registradas.");
        } else {
            for (Venta venta : evento.ventas) {
                System.out.println("ID Venta: " + venta.idVenta +
                        " | Cliente: " + venta.cliente.nombre +
                        " | Asiento: " + venta.asiento.numero +
                        " | Precio: $" + venta.precioFinal +
                        " | Fecha: " + venta.fecha);
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            inicializarAsientos();
            
            Evento eventoPrincipal = new Evento(1, "Concierto de Jazz");
            eventos.add(eventoPrincipal);
            
            int opcion = 0;
            
            do {
                System.out.println("\n🎭 TEATRO MORO - SISTEMA DE VENTAS");
                System.out.println("1. Vender entrada");
                System.out.println("2. Cancelar venta");
                System.out.println("3. Mostrar ventas");
                System.out.println("4. Salir");
                System.out.print("Seleccione una opción: ");
                
                try {
                    opcion = Integer.parseInt(sc.nextLine());
                    
                    switch (opcion) {
                        case 1 -> venderEntrada(eventoPrincipal, sc);
                        case 2 -> cancelarVenta(eventoPrincipal, sc);
                        case 3 -> mostrarVentas(eventoPrincipal);
                        case 4 -> System.out.println("👋 Gracias por usar el sistema. Hasta pronto.");
                        default -> System.out.println("❌ Opción inválida. Intente nuevamente.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("❌ Error: Ingrese una opción numérica válida.");
                }
                
            } while (true && opcion != 4);
        }
    }
}
