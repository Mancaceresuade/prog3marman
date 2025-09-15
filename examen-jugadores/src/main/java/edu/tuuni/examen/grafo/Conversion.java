package edu.tuuni.examen.grafo;

import edu.tuuni.examen.modelo.Contrato;

public class Conversion {
    public int[] obtenerCostos(Grafo grafo) {
        return grafo.getContratos().stream().mapToInt(Contrato::getCosto).toArray();
    }

    public int[] obtenerRendimientos(Grafo grafo) {
        return grafo.getContratos().stream().mapToInt(c -> c.getJugador().getRendimiento()).toArray();
    }
}
