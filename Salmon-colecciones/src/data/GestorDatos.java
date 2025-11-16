package data;

import model.CentroCultivo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase encargada de leer el archivo centros.txt y crear objetos CentroCultivo.
 */
public class GestorDatos {

    /**
     * Método que lee los datos del archivo y devuelve una lista de objetos.
     * @param rutaArchivo Ruta del archivo (por ejemplo: "resources/centros.txt")
     * @return ArrayList con objetos CentroCultivo
     */
    public ArrayList<CentroCultivo> cargarCentros(String rutaArchivo) {
        ArrayList<CentroCultivo> lista = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                // Separar los campos por punto y coma
                String[] datos = linea.split(";");
                if (datos.length == 3) {
                    String nombre = datos[0];
                    String comuna = datos[1];
                    double toneladas = Double.parseDouble(datos[2]);

                    // Crear objeto y agregar a la lista
                    CentroCultivo centro = new CentroCultivo(nombre, comuna, toneladas);
                    lista.add(centro);
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return lista;
    }
}
