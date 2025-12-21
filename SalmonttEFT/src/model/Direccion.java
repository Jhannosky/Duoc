package model;

public class Direccion {
    private String calle;
    private int numero;
    private String ciudad;

    public Direccion(String calle, int numero, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
    }

    @Override
    public String toString() {
        return calle + " #" + numero + ", " + ciudad;
    }
}
