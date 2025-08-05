import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public int sumar(int[] numeros) {
        int suma = 0;  // 1
        int i = 0; // 1
        while( i < numeros.length) {  // 2 (n+1)
            suma = suma + numeros[i]; // 3n
            i++; // n
        }
        /*
        for(int i=0; i < numeros.length; i++) { // 1 + 2 (n+1) + n 1
            suma = suma + numeros[i]; // 3n
        }
         */    
        return suma; // 1
    } // f(n) = 1 + 1+ 2(n+1) + 3n + n + 1 = 1+1+2n+2+3n+n+1 = 6n+5
    // f(n) = 6n+5
    // f(n) <= c g(n)
    // 6n + 5 <= c.n
    // 6n + 5 <= 7n   // tomamos 7n porque es mayor a 6n
    // 6n/n + 5/n <= 7n/n
    // 6 + 5/n <= 7
    // para n = 1 , no se cumple  =>  6 + 5/1 <= 7 =>  11 no es menor 
    // para n = 2 , no se cumple
    // para n = 3 , no se cumple
    // para n = 5 , 6 + 5/5 <= 7  =>  7 <= 7   => se cumple  
    // f(n) pertenece a O(n)  para n >= 5  y c = 7


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
