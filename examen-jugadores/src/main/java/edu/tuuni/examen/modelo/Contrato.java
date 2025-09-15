package edu.tuuni.examen.modelo;

public class Contrato {
    private Jugador jugador;
    private Equipo equipo;
    private int costo;

    public Contrato(Jugador jugador, Equipo equipo, int costo) {
        this.jugador = jugador;
        this.equipo = equipo;
        this.costo = costo;
    }

    public Jugador getJugador() { return jugador; }
    public Equipo getEquipo() { return equipo; }
    public int getCosto() { return costo; }
}
