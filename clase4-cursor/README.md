# Red Social con Grafo

Este proyecto implementa una red social simple usando un grafo con listas de adyacencia en Java.

## Descripción

La clase `RedSocial` representa una red social donde:
- Cada usuario puede seguir a otros usuarios
- Se utiliza un grafo dirigido implementado con un `HashMap<String, List<String>>`
- Cada nodo del grafo representa un usuario
- Cada arista representa una relación de "seguir"

## Estructura del Proyecto

```
red-social-grafo/
├── pom.xml                          # Configuración de Maven
├── README.md                        # Este archivo
└── src/
    └── main/
        └── java/
            └── com/
                └── redsocial/
                    ├── RedSocial.java    # Clase principal de la red social
                    └── Main.java         # Clase con método main para demostración
```

## Funcionalidades

### RedSocial.java
- `agregarUsuario(String usuario)`: Agrega un nuevo usuario a la red
- `seguir(String seguidor, String seguido)`: Establece una relación de seguimiento
- `obtenerSeguidos(String usuario)`: Obtiene la lista de usuarios que sigue un usuario
- `obtenerSeguidores(String usuario)`: Obtiene la lista de seguidores de un usuario
- `mostrarRed()`: Muestra toda la red social en consola
- `obtenerNumeroUsuarios()`: Obtiene el número total de usuarios
- `existeUsuario(String usuario)`: Verifica si un usuario existe en la red

## Compilación y Ejecución

### Requisitos
- Java 11 o superior
- Maven 3.6 o superior

### Compilar el proyecto
```bash
mvn compile
```

### Ejecutar el programa
```bash
mvn exec:java -Dexec.mainClass="com.redsocial.Main"
```

### Crear JAR ejecutable
```bash
mvn package
```

### Ejecutar el JAR
```bash
java -jar target/red-social-grafo-1.0-SNAPSHOT.jar
```

## Ejemplo de Uso

El programa de demostración crea una red social con los siguientes usuarios:
- Ana, Luis, Maria, Carlos, Elena

Y establece las siguientes relaciones:
- Ana sigue a Luis y Maria
- Luis sigue a Maria
- Maria sigue a Ana
- Carlos sigue a Ana y Luis
- Elena sigue a Maria y Carlos

## Salida Esperada

```
=== DEMOSTRACIÓN DE RED SOCIAL CON GRAFO ===

Agregando usuarios...
Estableciendo relaciones de seguimiento...

=== RED SOCIAL COMPLETA ===
Ana sigue a [Luis, Maria]
Luis sigue a [Maria]
Maria sigue a [Ana]
Carlos sigue a [Ana, Luis]
Elena sigue a [Maria, Carlos]

=== CONSULTAS ===
Ana sigue a: [Luis, Maria]
Maria es seguida por: [Ana, Luis, Elena]
Luis sigue a: [Maria]
Carlos es seguido por: [Elena]

=== INFORMACIÓN ADICIONAL ===
Número total de usuarios: 5
¿Existe el usuario 'Ana'? true
¿Existe el usuario 'Pedro'? false

=== AGREGANDO NUEVOS USUARIOS ===
Después de agregar Pedro:
Número total de usuarios: 6
Ana sigue a: [Luis, Maria, Pedro]
Pedro es seguido por: [Ana]

=== FIN DE LA DEMOSTRACIÓN ===
```

## Características Técnicas

- **Estructura de datos**: Grafo dirigido usando `HashMap<String, List<String>>`
- **Complejidad temporal**:
  - Agregar usuario: O(1)
  - Seguir usuario: O(1)
  - Obtener seguidos: O(1)
  - Obtener seguidores: O(n) donde n es el número de usuarios
- **Complejidad espacial**: O(n + e) donde n es el número de usuarios y e es el número de relaciones

