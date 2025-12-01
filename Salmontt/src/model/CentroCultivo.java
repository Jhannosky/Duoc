package model;

public class CentroCultivo extends UnidadOperativa {
    private double toneladasProduccion;

    public CentroCultivo(String nombre, String comuna, double toneladasProduccion) {
        super(nombre, comuna);
        this.toneladasProduccion = toneladasProduccion;
    }

    public double getToneladasProduccion() {
        return toneladasProduccion;
    }

    @Override
    public String toString() {
        return "Centro de Cultivo -> Nombre: " + nombre +
               " | Comuna: " + comuna +
               " | Producción: " + toneladasProduccion + " toneladas";
    }
}
