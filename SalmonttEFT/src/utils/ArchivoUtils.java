package utils;

import model.Direccion;
import model.Empleado;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ArchivoUtils {

    public static List<Empleado> cargarEmpleados(String rutaArchivo) {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                empleados.add(new Empleado(
                        datos[0],
                        datos[1],
                        new Direccion(datos[2], Integer.parseInt(datos[3]), datos[4]),
                        datos[5]
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}
