# SalmonttApp - Semana 4

Proyecto formativo individual de la asignatura **Desarrollo Orientado a Objetos I** (Duoc UC).

## Descripción
Aplicación en Java que lee datos de un archivo `centros.txt`, instancia objetos de tipo `CentroCultivo` y los almacena en un `ArrayList`.  
Permite mostrar todos los centros y filtrar los que tienen producción superior a 1000 toneladas.

## Estructura de paquetes
- `model`: Contiene la clase `CentroCultivo`.
- `data`: Contiene la clase `GestorDatos` (lectura de archivo y creación de objetos).
- `ui`: Contiene la clase `Main` que ejecuta la aplicación.
- `resources`: Contiene el archivo `centros.txt` con los datos de entrada.

## Ejemplo de archivo
```
CentroA;Puerto Montt;850.5
CentroB;Calbuco;1200.0
CentroC;Chiloé;950.0
CentroD;Ancud;2000.3
CentroE;Quellón;1750.7
```

## Requisitos
- Java 17 o superior.
- IntelliJ IDEA o NetBeans.
- Archivo `centros.txt` ubicado en `resources/`.

## Autor
Rodolfo Escobar – Ingeniería en Informática
