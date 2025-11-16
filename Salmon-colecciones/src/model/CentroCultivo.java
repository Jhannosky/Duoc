package model;

/**
 * Clase que representa un centro de cultivo de la empresa Salmontt.
 * Contiene su nombre, comuna y cantidad de toneladas producidas.
 */
public class CentroCultivo {

    private String nombre;
    private String comuna;
    private double toneladas;

    // Constructor
    public CentroCultivo(String nombre, String comuna, double toneladas) {
        this.nombre = nombre;
        this.comuna = comuna;
        this.toneladas = toneladas;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getComuna() { return comuna; }
    public void setComuna(String comuna) { this.comuna = comuna; }

    public double getToneladas() { return toneladas; }
    public void setToneladas(double toneladas) { this.toneladas = toneladas; }

    // Representación legible del objeto
    @Override
    public String toString() {
        return "CentroCultivo{" +
                "nombre='" + nombre + ''' +
                ", comuna='" + comuna + ''' +
                ", toneladas=" + toneladas +
                '}';
    }
}
