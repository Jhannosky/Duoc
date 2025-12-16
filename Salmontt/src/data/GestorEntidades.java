package data;

import model.*;
import java.util.ArrayList;

public class GestorEntidades {
    private ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable r) {
        entidades.add(r);
    }

    public String listarEntidades() {
        StringBuilder sb = new StringBuilder();
        for (Registrable r : entidades) {
            if (r instanceof Proveedor) {
                sb.append("[PROVEEDOR] ");
            } else if (r instanceof Empleado) {
                sb.append("[EMPLEADO] ");
            }
            sb.append(r.mostrarResumen()).append("\n");
        }
        return sb.toString();
    }
}