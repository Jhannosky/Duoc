package speedfast;

public class Main {
    public static void main(String[] args) {

        Pedido comida = new PedidoComida(1, "Av. Central 123", 4.5);
        Pedido encomienda = new PedidoEncomienda(2, "Calle Norte 456", 10);
        Pedido express = new PedidoExpress(3, "Ruta Sur 789", 6);

        comida.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + comida.calcularTiempoEntrega() + " minutos\n");

        encomienda.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + encomienda.calcularTiempoEntrega() + " minutos\n");

        express.mostrarResumen();
        System.out.println("Tiempo estimado de entrega: " + express.calcularTiempoEntrega() + " minutos\n");

        System.out.println("=======================================");
        System.out.println("Comparativa:");
        System.out.println("- Pedido Comida: " + comida.calcularTiempoEntrega() + " min");
        System.out.println("- Pedido Encomienda: " + encomienda.calcularTiempoEntrega() + " min");
        System.out.println("- Pedido Express: " + express.calcularTiempoEntrega() + " min");
    }
}