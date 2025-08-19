# Sistema de Facturación en Java

Este proyecto implementa un sistema de facturación que procesa listas de clientes y facturas para generar resúmenes de importes por cliente.

## Estructura del Proyecto

- `Cliente.java` - Clase que representa un cliente con ID y nombre
- `Factura.java` - Clase que representa una factura con ID, ID de cliente e importe
- `ResumenCliente.java` - Clase que contiene el resultado final con ID, nombre y suma de importes
- `SistemaFacturacionSinMaps.java` - Implementación sin usar Maps (búsqueda secuencial)
- `SistemaFacturacionConMaps.java` - Implementación usando HashMap para optimización
- `Main.java` - Clase principal con ejemplos de uso y comparación de rendimiento

## Funcionalidad

El sistema recibe:
- Una lista de clientes (ID, nombre)
- Una lista de facturas (ID, ID cliente, importe)

Y genera:
- Una lista de resúmenes con ID cliente, nombre y suma total de importes

## Implementaciones

### 1. Sin Maps (Búsqueda Secuencial)
- **Complejidad**: O(n²)
- **Algoritmo**: Para cada cliente, buscar en todas las facturas
- **Ventaja**: Simple de entender
- **Desventaja**: Ineficiente para grandes volúmenes de datos

### 2. Con Maps (HashMap)
- **Complejidad**: O(n)
- **Algoritmo**: Usar HashMap para acceso O(1) a clientes
- **Ventaja**: Muy eficiente, especialmente para grandes volúmenes
- **Desventaja**: Uso de memoria adicional

## Análisis de Complejidad

**Asumiendo n = cantidad de clientes ≈ cantidad de facturas:**

- **Sin Maps**: O(n²) - Complejidad cuadrática
- **Con Maps**: O(n) - Complejidad lineal

**Diferencia**: Para n grande, Maps es significativamente más eficiente.

## Ejecución

```bash
# Compilar
javac *.java

# Ejecutar
java Main
```

## Ejemplo de Salida

```
=== SISTEMA DE FACTURACIÓN EN JAVA ===

Datos de entrada:
Clientes: [Cliente{idCliente=1, nombreCliente='Juan Pérez'}, ...]
Facturas: [Factura{idFactura=1, idCliente=1, importe=100.5}, ...]

--- IMPLEMENTACIÓN SIN MAPS ---
Resultado:
ResumenCliente{idCliente=1, nombreCliente='Juan Pérez', sumaImportes=475.75}
...

--- IMPLEMENTACIÓN CON MAPS ---
Resultado:
ResumenCliente{idCliente=1, nombreCliente='Juan Pérez', sumaImportes=475.75}
...

--- COMPARACIÓN DE RENDIMIENTO ---
Sin Maps: 45000 ns
Con Maps: 12000 ns
Mejora: 3.75x más rápido con Maps
```

## Casos de Uso

- **Pocos datos (< 100 clientes/facturas)**: Ambas implementaciones son similares en rendimiento
- **Muchos datos (> 1000 clientes/facturas)**: Maps es significativamente más eficiente
- **Sistemas en producción**: Siempre usar Maps para escalabilidad

## Mejoras Futuras

- Implementar con Stream API de Java 8+
- Agregar persistencia de datos
- Implementar interfaz gráfica
- Agregar validaciones de datos
- Implementar tests unitarios
