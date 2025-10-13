import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EFT_S9_Rodolfo_Escobar {

    // Clase Cliente
    static class Cliente {
        private final String nombre;
        private final int edad;
        private final String tipoCliente; // niño, mujer, estudiante, tercera edad

        public Cliente(String nombre, int edad, String tipoCliente) {
            this.nombre = nombre;
            this.edad = edad;
            this.tipoCliente = tipoCliente;
        }

        // Getter para el tipo de cliente
        public String getTipoCliente() {
            return tipoCliente;
        }

        // Método para calcular el descuento
        public double calcularDescuento() {
            double descuento = 0;
            switch (this.tipoCliente.toLowerCase()) {
                case "niño" -> descuento = 0.05;
                case "mujer" -> descuento = 0.07;
                case "estudiante" -> descuento = 0.25;
                case "tercera edad" -> descuento = 0.30;
                default -> System.out.println("Tipo de cliente desconocido.");
            }
            return descuento;
        }

        // Getter para nombre
        public String getNombre() {
            return nombre;
        }

        // Getter para edad
        public int getEdad() {
            return edad;
        }
    }

    // Clase Asiento
    static class Asiento {
        private final String ubicacion; // VIP, Palco, Platea Baja, Platea Alta, Galería
        private boolean disponible;

        public Asiento(String ubicacion) {
            this.ubicacion = ubicacion;
            this.disponible = true; // Todos los asientos están disponibles al principio
        }

        public String getUbicacion() {
            return ubicacion;
        }

        public boolean estaDisponible() {
            return disponible;
        }

        public boolean asignar() {
            if (this.disponible) {
                this.disponible = false;
                return true; // Asiento asignado correctamente
            }
            return false; // Asiento ya ocupado
        }
    }

    // Clase Venta
    static class Venta {
        private final Cliente cliente;
        private final Asiento asiento;
        private final double precioBase;

        public Venta(Cliente cliente, Asiento asiento, double precioBase) {
            this.cliente = cliente;
            this.asiento = asiento;
            this.precioBase = precioBase;
        }

        // Calcular el precio final con descuento
        public double calcularPrecioFinal() {
            double descuento = cliente.calcularDescuento();
            return precioBase - (precioBase * descuento);
        }

        // Generar boleta de la venta
        public void imprimirBoleta() {
            System.out.println("******** BOLETA DE VENTA ********");
            System.out.println("Cliente: " + cliente.getNombre());
            System.out.println("Edad: " + cliente.getEdad() + " años");
            System.out.println("Tipo de cliente: " + cliente.getTipoCliente());
            System.out.println("Ubicación del asiento: " + asiento.getUbicacion());
            System.out.println("Precio base: $ " + precioBase);
            System.out.println("Descuento: " + (cliente.calcularDescuento() * 100) + "%");
            System.out.println("Precio final: $ " + calcularPrecioFinal());
            System.out.println("***********************************");
        }
    }

    // Clase Teatro
    static class Teatro {
        private final List<Asiento> asientos;

        public Teatro() {
            asientos = new ArrayList<>();
            // Crear 20 asientos de diferentes ubicaciones
            asientos.add(new Asiento("VIP"));
            asientos.add(new Asiento("Palco"));
            asientos.add(new Asiento("Platea Baja"));
            asientos.add(new Asiento("Platea Alta"));
            asientos.add(new Asiento("Galería"));
            // Agregar más asientos según sea necesario...
        }

        // Mostrar todos los asientos disponibles
        public void mostrarAsientosDisponibles() {
            System.out.println("Asientos disponibles:");
            for (int i = 0; i < asientos.size(); i++) {
                if (asientos.get(i).estaDisponible()) {
                    System.out.println("Asiento " + i + " en " + asientos.get(i).getUbicacion());
                }
            }
        }

        // Asignar un asiento
        public boolean asignarAsiento(int numeroAsiento) {
            if (numeroAsiento >= 0 && numeroAsiento < asientos.size()) {
                return asientos.get(numeroAsiento).asignar();
            }
            return false; // Si el asiento no existe
        }

        // Obtener un asiento por su número
        public Asiento obtenerAsiento(int numeroAsiento) {
            if (numeroAsiento >= 0 && numeroAsiento < asientos.size()) {
                return asientos.get(numeroAsiento);
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // Crear una instancia del teatro
        try (Scanner scanner = new Scanner(System.in)) {
            // Crear una instancia del teatro
            Teatro teatro = new Teatro();
            
            // Mostrar los asientos disponibles
            teatro.mostrarAsientosDisponibles();
            
            // Obtener la información del cliente
            System.out.println("Ingrese el nombre del cliente:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese la edad del cliente:");
            int edad = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            System.out.println("Ingrese el tipo de cliente (niño, mujer, estudiante, tercera edad):");
            String tipoCliente = scanner.nextLine();
            
            // Crear el cliente
            Cliente cliente = new Cliente(nombre, edad, tipoCliente);
            
            // Selección de asiento
            System.out.println("Seleccione el número de asiento (0-4):");
            int numeroAsiento = scanner.nextInt();
            
            // Intentar asignar el asiento
            boolean asignado = teatro.asignarAsiento(numeroAsiento);
            if (!asignado) {
                System.out.println("El asiento seleccionado no está disponible.");
                return;
            }
            
            // Crear la venta con un precio base 
            Asiento asiento = teatro.obtenerAsiento(numeroAsiento);
            Venta venta = new Venta(cliente, asiento, 5000);
            
            // Imprimir boleta
            venta.imprimirBoleta();
        }
    }
}
