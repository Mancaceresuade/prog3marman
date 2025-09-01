import java.util.*;

class Arista implements Comparable<Arista> {
    int destino, costo;
    public Arista(int destino, int costo) {
        this.destino = destino;
        this.costo = costo;
    }
    public int compareTo(Arista otra) {
        return Integer.compare(this.costo, otra.costo);
    }
}

public class RedElectrica {
    static int estaciones = 5; // Cambia según tus estaciones
    static String[] nombres = {"A", "B", "C", "D", "E"};

    public static void main(String[] args) {
        List<Arista>[] grafo = new ArrayList[estaciones];
        for (int i = 0; i < estaciones; i++) grafo[i] = new ArrayList<>();

        // Agregar conexiones (grafo no dirigido)
        agregarArista(grafo, 0, 1, 4); // A-B
        agregarArista(grafo, 0, 2, 3); // A-C
        agregarArista(grafo, 1, 2, 1); // B-C
        agregarArista(grafo, 1, 3, 2); // B-D
        agregarArista(grafo, 2, 3, 4); // C-D
        agregarArista(grafo, 2, 4, 2); // C-E
        agregarArista(grafo, 3, 4, 3); // D-E

        prim(grafo, 0); // Comenzar desde la estación 'A'
    }

    static void agregarArista(List<Arista>[] grafo, int origen, int destino, int costo) {
        grafo[origen].add(new Arista(destino, costo));
        grafo[destino].add(new Arista(origen, costo));
    }

    static void prim(List<Arista>[] grafo, int inicio) {
        boolean[] visitado = new boolean[estaciones];
        PriorityQueue<Arista> cola = new PriorityQueue<>();
        int costoTotal = 0;
        List<String> conexiones = new ArrayList<>();

        visitado[inicio] = true;
        for (Arista arista : grafo[inicio]) cola.add(new Arista(arista.destino, arista.costo));

        while (!cola.isEmpty()) {
            Arista actual = cola.poll();
            if (!visitado[actual.destino]) {
                visitado[actual.destino] = true;
                conexiones.add(nombres[inicio] + " - " + nombres[actual.destino] + " (costo: " + actual.costo + ")");
                costoTotal += actual.costo;
                for (Arista arista : grafo[actual.destino]) {
                    if (!visitado[arista.destino]) cola.add(new Arista(arista.destino, arista.costo));
                }
                inicio = actual.destino;
            }
        }

        System.out.println("Conexiones del Árbol de Recubrimiento Mínimo:");
        for (String c : conexiones) System.out.println(c);
        System.out.println("Costo total: " + costoTotal);
    }
}