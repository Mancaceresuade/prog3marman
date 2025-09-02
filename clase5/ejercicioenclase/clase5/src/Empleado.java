public class Empleado implements Comparable<Empleado>{
    private int id;
    private String nombre;
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
        return "Empleado [id=" + id + ", nombre=" + nombre + "]";
    }
    public Empleado(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    @Override
    public int compareTo(Empleado empleado) {
        // return Integer.compare(this.id, empleado.id);
        return this.nombre.compareTo(empleado.nombre);
    }
        
}
