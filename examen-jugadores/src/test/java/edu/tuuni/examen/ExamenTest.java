package edu.tuuni.examen;

import org.junit.jupiter.api.Test;
import edu.tuuni.examen.modelo.*;
import edu.tuuni.examen.grafo.*;
import edu.tuuni.examen.servicio.Completar;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class ExamenTest {
    @Test
    void testMatrizPD() {
        Grafo grafo = new Grafo();
        Jugador j1 = new Jugador("Jugador1", 60);
        Jugador j2 = new Jugador("Jugador2", 50);
        Jugador j3 = new Jugador("Jugador3", 40);
        Equipo e1 = new Equipo("EquipoA");
        grafo.agregarJugador(j1);
        grafo.agregarJugador(j2);
        grafo.agregarJugador(j3);
        grafo.agregarEquipo(e1);

        grafo.agregarContrato(new Contrato(j1, e1, 6));
        grafo.agregarContrato(new Contrato(j2, e1, 3));
        grafo.agregarContrato(new Contrato(j3, e1, 4));

        Conversion conversion = new Conversion();
        int[] costos = conversion.obtenerCostos(grafo);
        int[] rendimientos = conversion.obtenerRendimientos(grafo);

        MatrizPD matrizPD = new MatrizPD(costos, rendimientos);
        int max = matrizPD.resolver(8);
        assertEquals(90, max);

        Completar buscador = new Completar();
        List<Integer> seleccion = buscador.reconstruirSolucion(matrizPD.getDpTable(), costos, rendimientos, 8);

        assertFalse(seleccion.contains(0));
        assertTrue(seleccion.contains(1));
        assertTrue(seleccion.contains(2));
    }

    @Test
    void testRecorrido() {
        // Crear un grafo con múltiples nodos para probar Dijkstra
        Grafo grafo = new Grafo();
        
        // Crear jugadores
        Jugador j1 = new Jugador("Jugador1", 60);
        Jugador j2 = new Jugador("Jugador2", 50);
        Jugador j3 = new Jugador("Jugador3", 40);
        Jugador j4 = new Jugador("Jugador4", 35);
        
        // Crear equipos
        Equipo e1 = new Equipo("EquipoA");
        Equipo e2 = new Equipo("EquipoB");
        Equipo e3 = new Equipo("EquipoC");
        
        // Agregar nodos al grafo
        grafo.agregarJugador(j1);
        grafo.agregarJugador(j2);
        grafo.agregarJugador(j3);
        grafo.agregarJugador(j4);
        grafo.agregarEquipo(e1);
        grafo.agregarEquipo(e2);
        grafo.agregarEquipo(e3);
        
        // Crear contratos que forman un grafo conectado
        // Estructura del grafo:
        // J1 --(2)-- E1 --(3)-- J2 --(1)-- E2 --(4)-- J3 --(2)-- E3 --(1)-- J4
        grafo.agregarContrato(new Contrato(j1, e1, 2));
        grafo.agregarContrato(new Contrato(j2, e1, 3));
        grafo.agregarContrato(new Contrato(j2, e2, 1));
        grafo.agregarContrato(new Contrato(j3, e2, 4));
        grafo.agregarContrato(new Contrato(j3, e3, 2));
        grafo.agregarContrato(new Contrato(j4, e3, 1));
        
        // Probar Dijkstra desde Jugador1
        Map<String, Integer> distancias = grafo.calcularRecorridoDesde("Jugador1");
        
        // Verificar distancias desde Jugador1
        assertEquals(0, distancias.get("Jugador1"), "La distancia de un nodo a sí mismo debe ser 0");
        assertEquals(2, distancias.get("EquipoA"), "Distancia de J1 a E1 debe ser 2");
        assertEquals(5, distancias.get("Jugador2"), "Distancia de J1 a J2 debe ser 5 (2+3)");
        assertEquals(6, distancias.get("EquipoB"), "Distancia de J1 a E2 debe ser 6 (2+3+1)");
        assertEquals(10, distancias.get("Jugador3"), "Distancia de J1 a J3 debe ser 10 (2+3+1+4)");
        assertEquals(12, distancias.get("EquipoC"), "Distancia de J1 a E3 debe ser 12 (2+3+1+4+2)");
        assertEquals(13, distancias.get("Jugador4"), "Distancia de J1 a J4 debe ser 13 (2+3+1+4+2+1)");
        
        // Probar método obtenerDistanciaMinima
        assertEquals(0, grafo.obtenerDistanciaMinima("Jugador1", "Jugador1"), 
                    "Distancia mínima de J1 a J1 debe ser 0");
        assertEquals(5, grafo.obtenerDistanciaMinima("Jugador1", "Jugador2"), 
                    "Distancia mínima de J1 a J2 debe ser 5");
        assertEquals(13, grafo.obtenerDistanciaMinima("Jugador1", "Jugador4"), 
                    "Distancia mínima de J1 a J4 debe ser 13");
        
        // Probar Dijkstra desde EquipoB
        Map<String, Integer> distanciasDesdeE2 = grafo.calcularRecorridoDesde("EquipoB");
        assertEquals(0, distanciasDesdeE2.get("EquipoB"), "Distancia de E2 a sí mismo debe ser 0");
        assertEquals(1, distanciasDesdeE2.get("Jugador2"), "Distancia de E2 a J2 debe ser 1");
        assertEquals(4, distanciasDesdeE2.get("Jugador3"), "Distancia de E2 a J3 debe ser 4");
        assertEquals(6, distanciasDesdeE2.get("EquipoC"), "Distancia de E2 a E3 debe ser 6");
        assertEquals(7, distanciasDesdeE2.get("Jugador4"), "Distancia de E2 a J4 debe ser 7");
        assertEquals(4, distanciasDesdeE2.get("EquipoA"), "Distancia de E2 a E1 debe ser 4");
        assertEquals(6, distanciasDesdeE2.get("Jugador1"), "Distancia de E2 a J1 debe ser 6");
        
        // Verificar que todos los nodos son alcanzables
        assertTrue(distancias.values().stream().allMatch(d -> d != Integer.MAX_VALUE), 
                  "Todos los nodos deben ser alcanzables desde Jugador1");
    }

    @Test
    void testPropagacionValores() {
        // Crear grafo con nodos de tipo Jugador y Equipo
        Grafo grafo = new Grafo();

        Jugador j1 = new Jugador("J1", 60);
        Jugador j2 = new Jugador("J2", 50);
        Jugador j3 = new Jugador("J3", 40);
        Jugador j4 = new Jugador("J4", 35);

        Equipo e1 = new Equipo("E1");
        Equipo e2 = new Equipo("E2");
        Equipo e3 = new Equipo("E3");

        grafo.agregarJugador(j1);
        grafo.agregarJugador(j2);
        grafo.agregarJugador(j3);
        grafo.agregarJugador(j4);

        grafo.agregarEquipo(e1);
        grafo.agregarEquipo(e2);
        grafo.agregarEquipo(e3);

        // Conexiones con costos variados (no siempre acumulativos)
        grafo.agregarContrato(new Contrato(j1, e1, 2));
        grafo.agregarContrato(new Contrato(j2, e1, 2));
        grafo.agregarContrato(new Contrato(j2, e2, 0)); // arista con costo 0
        grafo.agregarContrato(new Contrato(j3, e2, 5));
        grafo.agregarContrato(new Contrato(j3, e3, 1));
        grafo.agregarContrato(new Contrato(j4, e3, 2));

        // Ejecutar el método de propagación desde J1
        Map<String, Integer> valores = grafo.simularConexiones("J1");

        // Validar algunos resultados esperados
        assertEquals(0, valores.get("J1"), "Valor de J1 a sí mismo debe ser 0");
        assertEquals(2, valores.get("E1"), "Valor de J1 a E1 debe ser 2");
        assertEquals(4, valores.get("J2"), "Valor de J1 a J2 debe ser 4 (2+2)");
        assertEquals(4, valores.get("E2"), "Valor de J1 a E2 debe ser 4 (2+2+0)");
        assertEquals(9, valores.get("J3"), "Valor de J1 a J3 debe ser 9 (2+2+0+5)");
        assertEquals(10, valores.get("E3"), "Valor de J1 a E3 debe ser 10 (9+1)");
        assertEquals(12, valores.get("J4"), "Valor de J1 a J4 debe ser 12 (10+2)");

        // Verificar que todos los nodos son alcanzables
        assertTrue(valores.values().stream().allMatch(v -> v != Integer.MAX_VALUE), 
                   "Todos los nodos deben tener un valor calculado");
    }
}
