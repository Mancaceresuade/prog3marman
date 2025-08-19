import java.util.ArrayList;
import java.util.List;

public class SistemaClasificacion {
    private AVL<Jugador> arbolJugadores;
    
    public SistemaClasificacion() {
        this.arbolJugadores = new AVL<>();
    }
    
    /**
     * Agrega un jugador al sistema de clasificación
     */
    public void agregarJugador(Jugador jugador) {
        arbolJugadores.insertar(jugador);
    }
    
    /**
     * Elimina un jugador del sistema
     */
    public void eliminarJugador(Jugador jugador) {
        arbolJugadores.eliminar(jugador);
    }
    
    /**
     * Obtiene el ranking completo de jugadores ordenado por puntaje
     */
    public List<Jugador> obtenerRankingCompleto() {
        return arbolJugadores.inOrden();
    }
    
    /**
     * Obtiene los k mejores jugadores en un rango de puntajes [p_min, p_max]
     * 
     * @param pMin puntaje mínimo del rango (inclusive)
     * @param pMax puntaje máximo del rango (inclusive)
     * @param k número de mejores jugadores a retornar
     * @return Lista de los k mejores jugadores en el rango especificado
     */
    public List<Jugador> obtenerMejoresEnRango(double pMin, double pMax, int k) {
        if (pMin > pMax || k <= 0) {
            return new ArrayList<>();
        }
        
        List<Jugador> jugadoresEnRango = new ArrayList<>();
        buscarEnRango(arbolJugadores.obtenerRaiz(), pMin, pMax, jugadoresEnRango);
        
        // Ordenar por puntaje (descendente) y tomar los k mejores
        jugadoresEnRango.sort(null); // usa compareTo de Jugador
        
        // Retornar solo los k primeros
        if (jugadoresEnRango.size() <= k) {
            return jugadoresEnRango;
        } else {
            return jugadoresEnRango.subList(0, k);
        }
    }
    
    /**
     * Búsqueda recursiva en el árbol AVL para encontrar jugadores en el rango [pMin, pMax]
     * Esta implementación es más eficiente que un recorrido completo porque:
     * 1. No visita nodos fuera del rango cuando es posible
     * 2. Aprovecha la propiedad de ordenamiento del árbol
     * 3. Es recursiva como se solicita
     */
    private void buscarEnRango(AVL<Jugador>.Nodo nodo, double pMin, double pMax, List<Jugador> resultado) {
        if (nodo == null) {
            return;
        }
        
        double puntajeActual = nodo.elem.getPuntaje();
        
        // Si el puntaje actual es mayor que pMin, explorar subárbol izquierdo
        // (puede haber jugadores con puntajes más altos en el rango)
        if (puntajeActual > pMin) {
            buscarEnRango(nodo.izq, pMin, pMax, resultado);
        }
        
        // Si el puntaje actual está en el rango, agregarlo al resultado
        if (puntajeActual >= pMin && puntajeActual <= pMax) {
            resultado.add(nodo.elem);
        }
        
        // Si el puntaje actual es menor que pMax, explorar subárbol derecho
        // (puede haber jugadores con puntajes más bajos en el rango)
        if (puntajeActual < pMax) {
            buscarEnRango(nodo.der, pMin, pMax, resultado);
        }
    }
    
    /**
     * Obtiene estadísticas del sistema
     */
    public String obtenerEstadisticas() {
        StringBuilder stats = new StringBuilder();
        stats.append("=== ESTADÍSTICAS DEL SISTEMA ===\n");
        stats.append("Total de jugadores: ").append(arbolJugadores.size()).append("\n");
        stats.append("Altura del árbol: ").append(arbolJugadores.altura()).append("\n");
        stats.append("¿Está vacío?: ").append(arbolJugadores.estaVacio() ? "Sí" : "No").append("\n");
        
        if (!arbolJugadores.estaVacio()) {
            stats.append("Mejor puntaje: ").append(arbolJugadores.maximo().getPuntaje()).append("\n");
            stats.append("Peor puntaje: ").append(arbolJugadores.minimo().getPuntaje()).append("\n");
        }
        
        return stats.toString();
    }
    
    /**
     * Busca jugadores por nombre (búsqueda lineal - para demostración)
     */
    public List<Jugador> buscarPorNombre(String nombre) {
        List<Jugador> todos = arbolJugadores.inOrden();
        List<Jugador> resultado = new ArrayList<>();
        
        for (Jugador jugador : todos) {
            if (jugador.getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                resultado.add(jugador);
            }
        }
        
        return resultado;
    }
}
