package model;

public class Proveedor extends Entidad {
    private String producto;

    public Proveedor(String nombre, String producto) {
        super(nombre);
        this.producto = producto;
    }

    @Override
    public String mostrarResumen() {
        return "Proveedor: " + nombre + " | Producto: " + producto;
    }
}