package edu.tuuni.examen.grafo;

import edu.tuuni.examen.modelo.Contrato;
import edu.tuuni.examen.modelo.Equipo;
import edu.tuuni.examen.modelo.Jugador;
import java.util.*;

public class Grafo {
    private List<Jugador> jugadores = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();
    private List<Contrato> contratos = new ArrayList<>();
    private Map<String, Map<String, Integer>> matrizAdyacencia = new HashMap<>();

    public void agregarJugador(Jugador j) { 
        jugadores.add(j); 
        matrizAdyacencia.putIfAbsent(j.getNombre(), new HashMap<>());
    }
    
    public void agregarEquipo(Equipo e) { 
        equipos.add(e); 
        matrizAdyacencia.putIfAbsent(e.getNombre(), new HashMap<>());
    }
    
    public void agregarContrato(Contrato c) { 
        contratos.add(c);
        // Agregar arista bidireccional entre jugador y equipo
        String jugador = c.getJugador().getNombre();
        String equipo = c.getEquipo().getNombre();
        int costo = c.getCosto();
        
        matrizAdyacencia.get(jugador).put(equipo, costo);
        matrizAdyacencia.get(equipo).put(jugador, costo);
    }

    public List<Jugador> getJugadores() { return jugadores; }
    public List<Equipo> getEquipos() { return equipos; }
    public List<Contrato> getContratos() { return contratos; }
    
    public Map<String, Integer> simularConexiones(String origen) {
        Map<String, Integer> distancias = new HashMap<>();
        return distancias;
    }
    
}
