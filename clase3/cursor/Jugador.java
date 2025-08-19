public class Jugador implements Comparable<Jugador>{

    private int id;
    private String nombre;
    private double puntaje;
    
    

    public Jugador(int id, String nombre, double puntaje) {
        this.id = id;
        this.nombre = nombre;
        this.puntaje = puntaje;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public String toString() {
        return "Jugador [id=" + id + ", nombre=" + nombre + "]";
    }
    public double getPuntaje() {
        return puntaje;
    }
    public void setPuntaje(double puntaje) {
        this.puntaje = puntaje;
    }
    @Override
    public int compareTo(Jugador o) {
        // Ordenar por puntaje de mayor a menor (descendente)
        if (this.puntaje > o.puntaje) {
            return -1; // este jugador va antes (mayor puntaje)
        } else if (this.puntaje < o.puntaje) {
            return 1;  // este jugador va después (menor puntaje)
        } else {
            // Si tienen el mismo puntaje, ordenar por ID para estabilidad
            return Integer.compare(this.id, o.id);
        }
    }

    
}
