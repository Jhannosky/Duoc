# SalmonttApp

Descripción del proyecto
**SalmonttApp** es un sistema desarrollado en Java que permite gestionar información de una salmonera, aplicando los principios de la **Programación Orientada a Objetos (POO)**.  
El sistema lee datos desde archivos, instancia objetos y los organiza dentro de colecciones, permitiendo realizar operaciones sobre ellos (como mostrar, filtrar o calcular información relevante).

El proyecto fue desarrollado con fines educativos, como parte de la asignatura de **Desarrollo Orientado a Objetos I**, aplicando modularización, encapsulamiento y reutilización de código.

---

Paquetes y clases implementadas

### Paquete `modelo`
- **Salmon.java** → Clase principal que representa un salmón, con atributos como especie, peso y zona.
- **ZonaCultivo.java** → Define la zona donde se cultivan los salmones, con su respectiva identificación y ubicación.
- **Produccion.java** → Contiene información sobre la producción de una zona específica (cantidad, fechas, etc.).

### Paquete `servicios`
- **LectorArchivo.java** → Encargado de leer los datos desde un archivo `.txt` y crear las instancias correspondientes.
- **GestorProduccion.java** → Administra la lista de objetos y permite realizar operaciones (mostrar datos, calcular promedios, etc.).

### Paquete `principal`
- **Main.java** → Clase principal del programa. Contiene el método `main()` desde donde se ejecuta el sistema.

---

Instrucciones para ejecutar el programa

1. **Abrir el proyecto**  
   Descomprime el archivo `SalmonttApp.zip` en tu computadora.  
   Puedes abrirlo en cualquier editor de código, por ejemplo **Visual Studio Code** o **IntelliJ IDEA**.

2. **Verifica la versión de Java**  
   Asegúrate de tener instalado **Java 17** o superior.  
   Puedes comprobarlo con el siguiente comando en tu terminal o consola:
   ```bash
   java -version
