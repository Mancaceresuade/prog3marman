import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class App {
    public static void main(String[] args) throws Exception {
        
        Map<Integer,Jugador> jugadores = new HashMap<>();
        Jugador j1 = new  Jugador(1,"Armani",7.1);
        Jugador j2 = new Jugador(2, "Paulo Diaz",9.8);
        Jugador j3 = new Jugador(5, "Enzo Perez", 8.6);
        jugadores.put(5, j3);
        jugadores.put(2, j2);
        jugadores.put(1, j1);
        //jugadores.values().stream().forEach(j -> System.out.println(j));

        Map<Integer,Jugador> jugadores2 = new TreeMap<>();
        jugadores2.put(5, j3);
        jugadores2.put(2, j2);
        jugadores2.put(1, j1);

        //jugadores2.values().stream().forEach(j -> System.out.println(j));

        AVL<Jugador> avl = new AVL<>();
        avl.insertar(j3);
        avl.insertar(j2);
        avl.insertar(j1);
        avl.inOrden();
    }
}
