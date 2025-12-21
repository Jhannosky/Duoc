# SalmonttEFT - Prototipo de Sistema para Empresa Salmonera

## Descripción general
Este proyecto es un prototipo de software en Java para la empresa salmonera Salmontt, ubicada en Puerto Montt.  
La idea principal es digitalizar y organizar procesos internos de la empresa, como la gestión de empleados, clientes, proveedores y productos, usando **Programación Orientada a Objetos (POO)**.  
No es un ERP completo, sino una base que puede escalarse y agregarse nuevas funcionalidades en el futuro.

---

## Clases principales y su función

### Paquete `model`
- **Persona**: Clase abstracta que representa a cualquier persona relacionada con la empresa (empleados, clientes, proveedores). Implementa la interfaz `Registrable`.  
- **Empleado**: Hereda de `Persona`. Representa a los empleados y su cargo, y tiene métodos para registrar y mostrar datos.  
- **Direccion**: Guarda la información de la dirección de cada persona.  
- **Cliente** *(opcional para futuras extensiones)*: Hereda de `Persona`.  
- **Proveedor** *(opcional para futuras extensiones)*: Hereda de `Persona`.  
- **Producto** *(opcional para futuras extensiones)*: Representa productos de la empresa con nombre, cantidad y precio.

### Paquete `interfaces`
- **Registrable**: Interfaz con métodos `registrar()` y `mostrarDatos()`. Se implementa en clases que representan entidades registrables.

### Paquete `utils`
- **ArchivoUtils**: Se encarga de leer archivos `.txt` y convertir los datos en objetos de Java (por ejemplo, cargar empleados desde `empleados.txt`).

### Paquete `app`
- **Main**: Clase principal que arranca el programa, carga los datos desde archivos y muestra la información por consola.

---

## Cómo clonar y ejecutar el proyecto

### Requisitos
- Java JDK 8 o superior
- IDE recomendado: IntelliJ IDEA (u otro IDE que soporte Java)

### Pasos
1. Clonar el proyecto o descargar el ZIP:

```bash
git clone <URL_DEL_REPOSITORIO>
