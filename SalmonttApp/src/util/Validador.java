package util;

public class Validador {

    public static boolean esDatoValido(String dato) {
        return dato != null && !dato.trim().isEmpty();
    }
}
