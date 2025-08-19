# Sistema de Clasificación GameScore con Árbol AVL

## 📋 Descripción del Problema

La empresa GameScore necesita un sistema de clasificación que permita búsquedas complejas de manera óptima. El sistema debe:

- Mantener un ranking de jugadores con sus puntajes
- Permitir búsquedas por rango de puntajes [p_min, p_max]
- Devolver los k mejores jugadores en ese rango
- Ser más eficiente que un recorrido lineal
- Implementar búsquedas recursivas
- Usar un árbol AVL personalizado (sin librerías externas)

## 🏗️ Arquitectura del Sistema

### **Clases Principales:**

1. **`Jugador`** - Entidad con ID, nombre y puntaje
2. **`AVL<T>`** - Árbol binario de búsqueda balanceado genérico
3. **`SistemaClasificacion`** - Lógica de negocio del sistema
4. **`DemoSistemaClasificacion`** - Demostración del funcionamiento

### **Estructura del Árbol AVL:**

```
        Jugador(94.3)
       /            \
Jugador(92.8)    Jugador(95.5)
   /      \         /      \
...      ...     ...      ...
```

## 🔍 Implementación de la Búsqueda por Rango

### **Método Principal:**
```java
public List<Jugador> obtenerMejoresEnRango(double pMin, double pMax, int k)
```

### **Algoritmo de Búsqueda Recursiva:**
```java
private void buscarEnRango(AVL<Jugador>.Nodo nodo, double pMin, double pMax, List<Jugador> resultado)
```

**Lógica del algoritmo:**
1. **Navegación inteligente**: Solo visita nodos relevantes al rango
2. **Exploración condicional**: 
   - Si `puntaje > pMin` → explorar subárbol izquierdo
   - Si `puntaje < pMax` → explorar subárbol derecho
3. **Recolección eficiente**: Agrega jugadores en rango al resultado
4. **Ordenamiento final**: Ordena por puntaje y retorna top-k

## ⚡ Análisis de Complejidad

### **¿Por qué AVL es la estructura adecuada?**

| Aspecto | AVL | Array | HashMap |
|---------|-----|-------|---------|
| **Altura** | O(log n) | O(1) | O(1) |
| **Ordenamiento** | Automático | Manual | No |
| **Búsqueda por rango** | O(log n + k) | O(n) | O(n) |
| **Inserción** | O(log n) | O(n) | O(1) |
| **Eliminación** | O(log n) | O(n) | O(1) |

### **Complejidad de la Búsqueda por Rango:**

**TIEMPO: O(log n + k)**
- **O(log n)**: Navegación al rango en el árbol balanceado
- **O(k)**: Recolección de k jugadores en el rango

**ESPACIO: O(k)**
- Solo almacena los jugadores del rango solicitado

### **Ventajas del AVL:**

1. **Balanceo automático**: Altura siempre O(log n)
2. **Ordenamiento inherente**: Jugadores ordenados por puntaje
3. **Búsquedas eficientes**: Aprovecha la estructura ordenada
4. **Flexibilidad**: Fácil implementar consultas complejas

## 🚀 Características del Sistema

### **Funcionalidades Principales:**
- ✅ Agregar jugadores
- ✅ Eliminar jugadores
- ✅ Obtener ranking completo
- ✅ Búsqueda por rango de puntajes
- ✅ Búsqueda por nombre
- ✅ Estadísticas del sistema

### **Búsquedas por Rango:**
- **Top-k jugadores** en rango específico
- **Ordenamiento automático** por puntaje
- **Filtrado eficiente** sin visitar nodos innecesarios

### **Manejo de Datos:**
- **Sin duplicados**: Un jugador por ID
- **Ordenamiento estable**: Mismo puntaje = orden por ID
- **Validaciones**: Parámetros de entrada verificados

## 📊 Ejemplos de Uso

### **Búsqueda de Top 3 entre 90-95 puntos:**
```java
List<Jugador> top3 = sistema.obtenerMejoresEnRango(90.0, 95.0, 3);
```

### **Búsqueda de Top 5 entre 85-93 puntos:**
```java
List<Jugador> top5 = sistema.obtenerMejoresEnRango(85.0, 93.0, 5);
```

### **Ranking completo ordenado:**
```java
List<Jugador> ranking = sistema.obtenerRankingCompleto();
```

## 🔧 Implementación Técnica

### **Árbol AVL Personalizado:**
- **Sin librerías externas** (TreeMap, TreeSet)
- **Control total** sobre la lógica de balanceo
- **Métodos públicos** para acceso controlado
- **Implementación completa** de rotaciones AVL

### **Búsqueda Recursiva:**
- **Algoritmo eficiente** que evita nodos irrelevantes
- **Navegación condicional** basada en valores del rango
- **Recolección optimizada** de resultados

### **Ordenamiento:**
- **Comparable<Jugador>** implementado
- **Orden descendente** por puntaje (mejores primero)
- **Orden estable** por ID en caso de empate

## 📈 Escalabilidad

### **Para n jugadores:**
- **Inserción**: O(log n)
- **Eliminación**: O(log n)
- **Búsqueda por rango**: O(log n + k)
- **Ranking completo**: O(n)

### **Casos de Uso:**
- **Pocos jugadores (< 100)**: Cualquier estructura es eficiente
- **Muchos jugadores (100-10000)**: AVL muestra ventajas claras
- **Sistemas masivos (> 10000)**: AVL es significativamente superior

## 🎯 Ventajas sobre Soluciones Alternativas

### **vs. Array Ordenado:**
- ✅ Inserción/eliminación O(log n) vs O(n)
- ✅ Búsqueda por rango O(log n + k) vs O(n)

### **vs. HashMap:**
- ✅ Ordenamiento automático vs no ordenado
- ✅ Búsquedas por rango eficientes vs O(n)

### **vs. Librerías Externas:**
- ✅ Control total sobre la implementación
- ✅ Personalización para consultas específicas
- ✅ Sin dependencias externas

## 🚀 Ejecución

```bash
# Compilar
javac *.java

# Ejecutar demostración
java DemoSistemaClasificacion
```

## 🔮 Mejoras Futuras

- **Índices secundarios** para búsquedas por nombre
- **Persistencia de datos** en base de datos
- **API REST** para integración web
- **Cache distribuido** para sistemas masivos
- **Métricas de rendimiento** en tiempo real
