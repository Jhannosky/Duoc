package model;

import java.util.List;

public class OrdenDeCompra {
    private Cliente cliente;
    private List<Producto> productos;

    public OrdenDeCompra(Cliente cliente, List<Producto> productos) {
        this.cliente = cliente;
        this.productos = productos;
    }

    public double calcularTotal() {
        return productos.stream().mapToDouble(Producto::getPrecio).sum();
    }

    @Override
    public String toString() {
        return "Cliente: " + cliente.getNombre() + ", Total: $" + calcularTotal();
    }
}
