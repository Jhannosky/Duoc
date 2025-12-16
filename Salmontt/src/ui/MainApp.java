package ui;

import javax.swing.*;
import data.GestorEntidades;
import model.*;

public class MainApp {
    public static void main(String[] args) {
        GestorEntidades gestor = new GestorEntidades();
        boolean salir = false;

        while (!salir) {
            String opcion = JOptionPane.showInputDialog(
                "Sistema Salmontt\n1. Agregar Proveedor\n2. Agregar Empleado\n3. Ver Registros\n4. Salir"
            );

            if (opcion == null) break;

            switch (opcion) {
                case "1":
                    String nomProv = JOptionPane.showInputDialog("Nombre del proveedor:");
                    String prod = JOptionPane.showInputDialog("Producto que suministra:");
                    gestor.agregarEntidad(new Proveedor(nomProv, prod));
                    break;
                case "2":
                    String nomEmp = JOptionPane.showInputDialog("Nombre del empleado:");
                    String cargo = JOptionPane.showInputDialog("Cargo:");
                    gestor.agregarEntidad(new Empleado(nomEmp, cargo));
                    break;
                case "3":
                    JOptionPane.showMessageDialog(null, gestor.listarEntidades());
                    break;
                case "4":
                    salir = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        }
    }
}