package app.app;

import model.Empleado;
import utils.ArchivoUtils;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Empleado> empleados = ArchivoUtils.cargarEmpleados("src/data/empleados.txt");

        for (Empleado e : empleados) {
            e.registrar();
            e.mostrarDatos();
        }
    }
}
