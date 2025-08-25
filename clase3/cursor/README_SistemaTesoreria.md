# Sistema de Tesorería - Algoritmo Greedy

## Descripción del Problema

Un sistema de tesorería tiene a disposición una variedad de comprobantes que incluyen monedas, cheques, bonos y otros documentos financieros. Cada comprobante tiene un valor específico. El objetivo es realizar una compra de moneda extranjera **minimizando el número de comprobantes utilizados**.

## Solución Implementada

### Algoritmo Greedy

Se implementó un algoritmo greedy que sigue la siguiente estrategia:

1. **Ordenar** los comprobantes de mayor a menor valor
2. **Seleccionar** siempre el comprobante de mayor valor que no exceda el valor restante
3. **Repetir** hasta alcanzar el valor objetivo o agotar los comprobantes

### Pseudocódigo

```
ALGORITMO ComprarMonedaExtranjera
ENTRADA: comprobantes[], valorObjetivo
SALIDA: Lista de comprobantes utilizados

1. ORDENAR comprobantes[] de mayor a menor valor
2. INICIALIZAR comprobantesUtilizados = []
3. INICIALIZAR valorRestante = valorObjetivo
4. INICIALIZAR i = 0

5. MIENTRAS valorRestante > 0 Y i < longitud(comprobantes)
   a. SI comprobantes[i] <= valorRestante ENTONCES
      - AGREGAR comprobantes[i] a comprobantesUtilizados
      - valorRestante = valorRestante - comprobantes[i]
   b. SINO
      - i = i + 1
   FIN MIENTRAS

6. SI valorRestante == 0 ENTONCES
   - RETORNAR comprobantesUtilizados
   SINO
   - RETORNAR "No es posible realizar la compra"
FIN ALGORITMO
```

## Análisis de Complejidad Algorítmica

### Complejidad Asintótica: O(n log n)

#### Desglose de la Complejidad:

1. **Ordenamiento**: O(n log n)
   - Se utiliza `sort()` que implementa un algoritmo de ordenamiento eficiente
   - n = número de comprobantes disponibles

2. **Selección Greedy**: O(n)
   - En el peor caso, se recorre toda la lista de comprobantes
   - Cada iteración del bucle while toma tiempo constante

3. **Total**: O(n log n) + O(n) = **O(n log n)**

#### Conteo de Instrucciones:

Para n comprobantes, el algoritmo ejecuta aproximadamente:

- **Verificaciones iniciales**: 3 instrucciones
- **Creación de ArrayList**: 1 instrucción
- **Ordenamiento**: n log n comparaciones
- **Inicializaciones**: 3 instrucciones
- **Bucle principal**: 
  - Máximo n iteraciones
  - Por iteración: 2-5 instrucciones (while + if + operaciones)
  - Total bucle: O(n) instrucciones
- **Verificación final**: 1-2 instrucciones

**Total de instrucciones**: O(n log n) + O(n) = **O(n log n)**

### Ventajas del Algoritmo Greedy

1. **Simplicidad**: Fácil de implementar y entender
2. **Eficiencia**: Complejidad O(n log n) es aceptable para la mayoría de casos
3. **Optimalidad**: En muchos casos prácticos, encuentra la solución óptima

### Limitaciones del Algoritmo Greedy

1. **No siempre óptimo**: Para ciertas configuraciones de valores, puede no encontrar la solución con menor número de comprobantes
2. **Ejemplo de no optimalidad**:
   - Comprobantes: [1, 3, 4]
   - Valor objetivo: 6
   - Algoritmo greedy: [4, 1, 1] (3 comprobantes)
   - Solución óptima: [3, 3] (2 comprobantes)

## Estructura del Código

### Clases Principales

1. **`SistemaTesoreria`**: Clase principal que implementa el algoritmo
2. **`Comprobante`**: Representa un comprobante financiero
3. **`ResultadoCompra`**: Contiene el resultado de la operación
4. **`DemoSistemaTesoreria`**: Clase de demostración con casos de prueba

### Métodos Principales

- `comprarMonedaExtranjera(double valorObjetivo)`: Implementa el algoritmo greedy
- `agregarComprobante(Comprobante comprobante)`: Agrega comprobantes al sistema
- `getComprobantesDisponibles()`: Obtiene la lista de comprobantes
- `getValorTotalDisponible()`: Calcula el valor total disponible

## Casos de Prueba

### Escenario 1: Comprobantes Básicos
- Monedas de diferentes denominaciones ($1, $5, $10, $20, $50, $100)
- Prueba con valores objetivo: $157, $200, $75, $300

### Escenario 2: Comprobantes Mixtos
- Combinación de monedas, cheques y bonos
- Valores más complejos: $1275, $850, $2000, $125

### Escenario 3: Casos Límite
- Valor exacto disponible
- Valor mayor al disponible
- Valor negativo
- Valor cero

## Ejecución

Para ejecutar el sistema:

```bash
javac SistemaTesoreria.java DemoSistemaTesoreria.java
java DemoSistemaTesoreria
```

## Conclusiones

El algoritmo greedy implementado proporciona una solución eficiente y práctica para el problema de minimización de comprobantes en un sistema de tesorería. Aunque no garantiza la optimalidad en todos los casos, su simplicidad y eficiencia lo hacen adecuado para la mayoría de aplicaciones prácticas.

La complejidad O(n log n) es aceptable para sistemas que manejan hasta miles de comprobantes, y el algoritmo se puede optimizar aún más si se utilizan estructuras de datos más eficientes para casos específicos.

