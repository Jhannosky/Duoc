package model;

public class Producto {
    private String nombre;
    private int stock;
    private double precio;

    public Producto(String nombre, int stock, double precio) {
        this.nombre = nombre;
        this.stock = stock;
        this.precio = precio;
    }

    public String getNombre() { return nombre; }
    public int getStock() { return stock; }
    public double getPrecio() { return precio; }

    public void setStock(int stock) { this.stock = stock; }

    @Override
    public String toString() {
        return nombre + " - Stock: " + stock + " - Precio: $" + precio;
    }
}
