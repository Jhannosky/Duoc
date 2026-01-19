# Proyecto SpeedFast - Semana 2
### Definiendo una clase abstracta y su jerarquía

Este proyecto pertenece a la semana 2 de la asignatura de Ingeniería en Informática.

## Descripción
Se modela una jerarquía de clases para distintos tipos de pedidos de la empresa **SpeedFast**, aplicando el uso de clases abstractas y polimorfismo.

### Clases incluidas
- **Pedido (abstracta)**: contiene los atributos comunes y el método abstracto `calcularTiempoEntrega()`.
- **PedidoComida**: tiempo base 15 min + 2 min por km.
- **PedidoEncomienda**: tiempo base 20 min + 1.5 min por km (redondeado).
- **PedidoExpress**: tiempo base 10 min, si > 5 km se agregan 5 min extra.

## Ejecución
1. Abre el proyecto en IntelliJ IDEA o VSCode.
2. Ejecuta la clase `Main`.
3. La consola mostrará los resúmenes y los tiempos de entrega estimados.

## Ejemplo de salida
```
=======================================
ID Pedido: 1
Dirección de entrega: Av. Central 123
Distancia: 4.5 km
Tiempo estimado de entrega: 24 minutos

ID Pedido: 2
Dirección de entrega: Calle Norte 456
Distancia: 10.0 km
Tiempo estimado de entrega: 35 minutos

ID Pedido: 3
Dirección de entrega: Ruta Sur 789
Distancia: 6.0 km
Tiempo estimado de entrega: 15 minutos

Comparativa:
- Pedido Comida: 24 min
- Pedido Encomienda: 35 min
- Pedido Express: 15 min
```