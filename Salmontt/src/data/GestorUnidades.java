package data;

import model.CentroCultivo;
import model.PlantaProceso;
import model.UnidadOperativa;

public class GestorUnidades {

    public static UnidadOperativa[] crearUnidadesDePrueba() {
        UnidadOperativa[] unidades = new UnidadOperativa[4];

        unidades[0] = new CentroCultivo("Centro Alerce", "Puerto Montt", 250.5);
        unidades[1] = new CentroCultivo("Centro Reloncaví", "Calbuco", 310.8);
        unidades[2] = new PlantaProceso("Planta Sur", "Puerto Varas", 120);
        unidades[3] = new PlantaProceso("Planta Norte", "Frutillar", 150);

        return unidades;
    }
}
