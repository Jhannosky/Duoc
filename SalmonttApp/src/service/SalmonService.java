package service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import model.Salmon;
import util.Validador;

public class SalmonService {
    private final ArrayList<Salmon> salmones;

    public SalmonService() {
        this.salmones = new ArrayList<>();
    }

    public void cargarDesdeArchivo(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    try {
                        int id = Integer.parseInt(datos[0]);
                        String especie = datos[1];
                        double peso = Double.parseDouble(datos[2]);
                        int edad = Integer.parseInt(datos[3]);

                        if (Validador.esDatoValido(especie) && peso > 0 && edad > 0) {
                            Salmon s = new Salmon(id, especie, peso, edad);
                            salmones.add(s);
                        } else {
                            System.out.println("⚠️ Datos inválidos en línea: " + linea);
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("⚠️ Error en formato numérico: " + linea);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("❌ No se pudo leer el archivo: " + e.getMessage());
        }
    }

    public void mostrarSalmones() {
        if (salmones.isEmpty()) {
            System.out.println("No hay registros cargados.");
        } else {
            for (Salmon s : salmones) {
                System.out.println(s);
            }
        }
    }

    public void buscarPorEspecie(String especie) {
        boolean encontrado = false;
        for (Salmon s : salmones) {
            if (s.getEspecie().equalsIgnoreCase(especie)) {
                System.out.println(s);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron salmones de la especie: " + especie);
        }
    }
}
