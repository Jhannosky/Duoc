package model;

public class Salmon {
    private int id;
    private String especie;
    private double pesoKg;
    private int edadMeses;

    public Salmon(int id, String especie, double pesoKg, int edadMeses) {
        this.id = id;
        this.especie = especie;
        this.pesoKg = pesoKg;
        this.edadMeses = edadMeses;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEspecie() { return especie; }
    public void setEspecie(String especie) { this.especie = especie; }

    public double getPesoKg() { return pesoKg; }
    public void setPesoKg(double pesoKg) { this.pesoKg = pesoKg; }

    public int getEdadMeses() { return edadMeses; }
    public void setEdadMeses(int edadMeses) { this.edadMeses = edadMeses; }

    @Override
    public String toString() {
        return "Salmon{" +
                "id=" + id +
                ", especie='" + especie + '\'' +
                ", pesoKg=" + pesoKg +
                ", edadMeses=" + edadMeses +
                '}';
    }
}
