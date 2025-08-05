public class Jugador implements IContratable{
    private int id;
    private String nombre;

    public static void metodoEstatico() {
        System.out.println("Este es un método estático de la clase Jugador");
    }
    
    public Jugador(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public String saludar() throws Exception {
        throw new Exception("error");
        //return "Hola, soy " + nombre;
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
        return "Jugador{id=" + id + ", nombre='" + nombre + "'}";
    }

    @Override
    public void contratar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'contratar'");
    }


}
