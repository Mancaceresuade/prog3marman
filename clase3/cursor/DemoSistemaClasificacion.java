import java.util.List;

public class DemoSistemaClasificacion {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CLASIFICACIÓN GAMESCORE ===\n");
        
        // Crear el sistema de clasificación
        SistemaClasificacion sistema = new SistemaClasificacion();
        
        // Agregar jugadores de ejemplo
        System.out.println("Agregando jugadores al sistema...");
        sistema.agregarJugador(new Jugador(1, "Ana", 95.5));
        sistema.agregarJugador(new Jugador(2, "Bob", 87.2));
        sistema.agregarJugador(new Jugador(3, "Carlos", 92.8));
        sistema.agregarJugador(new Jugador(4, "Diana", 89.1));
        sistema.agregarJugador(new Jugador(5, "Elena", 94.3));
        sistema.agregarJugador(new Jugador(6, "Fernando", 91.7));
        sistema.agregarJugador(new Jugador(7, "Gabriela", 88.9));
        sistema.agregarJugador(new Jugador(8, "Hector", 93.2));
        sistema.agregarJugador(new Jugador(9, "Isabel", 90.5));
        sistema.agregarJugador(new Jugador(10, "Juan", 96.1));
        
        // Mostrar estadísticas del sistema
        System.out.println(sistema.obtenerEstadisticas());
        
        // Mostrar ranking completo
        System.out.println("--- RANKING COMPLETO ---");
        List<Jugador> rankingCompleto = sistema.obtenerRankingCompleto();
        for (int i = 0; i < rankingCompleto.size(); i++) {
            Jugador jugador = rankingCompleto.get(i);
            System.out.printf("%d. %s - Puntaje: %.1f (ID: %d)\n", 
                i + 1, jugador.getNombre(), jugador.getPuntaje(), jugador.getId());
        }
        
        // Demostrar búsqueda por rango
        System.out.println("\n--- BÚSQUEDA POR RANGO DE PUNTAJES ---");
        
        // Ejemplo 1: Top 3 jugadores entre 90 y 95 puntos
        System.out.println("Top 3 jugadores con puntaje entre 90.0 y 95.0:");
        List<Jugador> top3_90_95 = sistema.obtenerMejoresEnRango(90.0, 95.0, 3);
        for (int i = 0; i < top3_90_95.size(); i++) {
            Jugador jugador = top3_90_95.get(i);
            System.out.printf("%d. %s - Puntaje: %.1f\n", 
                i + 1, jugador.getNombre(), jugador.getPuntaje());
        }
        
        // Ejemplo 2: Top 5 jugadores entre 85 y 93 puntos
        System.out.println("\nTop 5 jugadores con puntaje entre 85.0 y 93.0:");
        List<Jugador> top5_85_93 = sistema.obtenerMejoresEnRango(85.0, 93.0, 5);
        for (int i = 0; i < top5_85_93.size(); i++) {
            Jugador jugador = top5_85_93.get(i);
            System.out.printf("%d. %s - Puntaje: %.1f\n", 
                i + 1, jugador.getNombre(), jugador.getPuntaje());
        }
        
        // Ejemplo 3: Top 2 jugadores entre 88 y 92 puntos
        System.out.println("\nTop 2 jugadores con puntaje entre 88.0 y 92.0:");
        List<Jugador> top2_88_92 = sistema.obtenerMejoresEnRango(88.0, 92.0, 2);
        for (int i = 0; i < top2_88_92.size(); i++) {
            Jugador jugador = top2_88_92.get(i);
            System.out.printf("%d. %s - Puntaje: %.1f\n", 
                i + 1, jugador.getNombre(), jugador.getPuntaje());
        }
        
        // Demostrar búsqueda por nombre
        System.out.println("\n--- BÚSQUEDA POR NOMBRE ---");
        System.out.println("Jugadores con nombre que contiene 'a':");
        List<Jugador> jugadoresConA = sistema.buscarPorNombre("a");
        for (Jugador jugador : jugadoresConA) {
            System.out.printf("- %s (ID: %d, Puntaje: %.1f)\n", 
                jugador.getNombre(), jugador.getId(), jugador.getPuntaje());
        }
        
        // Demostrar eliminación
        System.out.println("\n--- ELIMINACIÓN DE JUGADOR ---");
        Jugador jugadorAEliminar = new Jugador(5, "Elena", 94.3);
        System.out.println("Eliminando a Elena...");
        sistema.eliminarJugador(jugadorAEliminar);
        
        System.out.println("\nRanking después de eliminar a Elena:");
        List<Jugador> rankingActualizado = sistema.obtenerRankingCompleto();
        for (int i = 0; i < rankingActualizado.size(); i++) {
            Jugador jugador = rankingActualizado.get(i);
            System.out.printf("%d. %s - Puntaje: %.1f (ID: %d)\n", 
                i + 1, jugador.getNombre(), jugador.getPuntaje(), jugador.getId());
        }
        
        // Mostrar estadísticas finales
        System.out.println("\n" + sistema.obtenerEstadisticas());
        
        // Análisis de complejidad
        System.out.println("\n=== ANÁLISIS DE COMPLEJIDAD ===");
        analizarComplejidad();
    }
    
    private static void analizarComplejidad() {
        System.out.println("¿Por qué un AVL es la estructura adecuada para este problema?");
        System.out.println("1. BALANCEO AUTOMÁTICO: Mantiene el árbol balanceado, garantizando");
        System.out.println("   que la altura sea O(log n), donde n es el número de jugadores.");
        System.out.println("2. ORDENAMIENTO INHERENTE: Los jugadores se mantienen ordenados");
        System.out.println("   por puntaje automáticamente.");
        System.out.println("3. BÚSQUEDAS EFICIENTES: La búsqueda por rango aprovecha la");
        System.out.println("   estructura ordenada del árbol.");
        System.out.println("4. INSERCIÓN/ELIMINACIÓN: O(log n) para mantener el ranking actualizado.");
        System.out.println();
        
        System.out.println("Complejidad de la búsqueda por rango:");
        System.out.println("- TIEMPO: O(log n + k) donde:");
        System.out.println("  * log n: tiempo para navegar al rango en el árbol");
        System.out.println("  * k: número de jugadores en el rango");
        System.out.println("- ESPACIO: O(k) para almacenar los resultados");
        System.out.println();
        
        System.out.println("Comparación con otras estructuras:");
        System.out.println("- ARRAY ORDENADO: O(n) para búsqueda por rango");
        System.out.println("- HASHMAP: O(n) para búsqueda por rango (no ordenado)");
        System.out.println("- AVL: O(log n + k) para búsqueda por rango");
        System.out.println();
        
        System.out.println("El AVL es óptimo porque combina:");
        System.out.println("✓ Búsquedas eficientes O(log n)");
        System.out.println("✓ Ordenamiento automático");
        System.out.println("✓ Balanceo automático");
        System.out.println("✓ Flexibilidad para consultas complejas");
    }
}
