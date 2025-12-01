package model;

public class PlantaProceso extends UnidadOperativa {
    private int capacidadProceso;

    public PlantaProceso(String nombre, String comuna, int capacidadProceso) {
        super(nombre, comuna);
        this.capacidadProceso = capacidadProceso;
    }

    public int getCapacidadProceso() {
        return capacidadProceso;
    }

    @Override
    public String toString() {
        return "Planta de Proceso -> Nombre: " + nombre +
               " | Comuna: " + comuna +
               " | Capacidad: " + capacidadProceso + " ton/día";
    }
}
