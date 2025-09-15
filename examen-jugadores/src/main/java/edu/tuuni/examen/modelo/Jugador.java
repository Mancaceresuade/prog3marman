package edu.tuuni.examen.modelo;

public class Jugador {
    private String nombre;
    private int rendimiento;

    public Jugador(String nombre, int rendimiento) {
        this.nombre = nombre;
        this.rendimiento = rendimiento;
    }

    public String getNombre() { return nombre; }
    public int getRendimiento() { return rendimiento; }
}
