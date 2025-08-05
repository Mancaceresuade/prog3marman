import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Jugador.metodoEstatico();
        var jugador1 = new Jugador(1, "Juan");
        List<Jugador> jugadores = new ArrayList<>();
        jugadores.add(jugador1);
        for(Jugador j : jugadores) {
            System.out.println(j);
        }
        jugadores.forEach( j -> System.out.println(j));

        HashMap<Integer,Jugador> mapJugadores = new HashMap<>();
        mapJugadores.put(1, jugador1);
        mapJugadores.put(2, new  Jugador(2,"Pedro"));

        System.out.println(mapJugadores.get(2));

        
        mapJugadores.values().forEach(j ->  System.out.println(j) );
        // es similar
        for(Jugador k : mapJugadores.values()){
            System.out.println(k);
        }


        /*
        System.out.println(jugador1);

        try {
            jugador1.saludar();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        try {
            int i = 5;
            System.out.println(i/0);
        } catch (Exception e) {
            System.out.println("intente mas tarde");
        }
        try {
            FileReader fileReader = new FileReader("texto.txt");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         */
    }
}
