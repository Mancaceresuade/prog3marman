public class RedSocilaMatriz {
    private int[][] matrizAdyacencia;
    private int numNodos;

    public RedSocilaMatriz(int numNodos) {
        this.numNodos = numNodos;
        matrizAdyacencia = new int[numNodos][numNodos];
    }

    // Agrega una arista entre nodo origen y destino
    public void agregarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 1;
        matrizAdyacencia[destino][origen] = 1; // Si es no dirigido
    }

    // Elimina una arista
    public void eliminarArista(int origen, int destino) {
        matrizAdyacencia[origen][destino] = 0;
        matrizAdyacencia[destino][origen] = 0; // Si es no dirigido
    }

    // Imprime la matriz de adyacencia
    public void imprimirMatriz() {
        for (int i = 0; i < numNodos; i++) {
            for (int j = 0; j < numNodos; j++) {
                System.out.print(matrizAdyacencia[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Ejemplo de uso
    public static void main(String[] args) {
        RedSocilaMatriz grafo = new RedSocilaMatriz(5);
        grafo.agregarArista(0, 1);
        grafo.agregarArista(0, 2);
        grafo.agregarArista(1, 3);
        grafo.agregarArista(3, 4);
        grafo.imprimirMatriz();
    }
}
