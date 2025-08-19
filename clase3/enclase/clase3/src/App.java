public class App {
    public static void main(String[] args) throws Exception {
        int[][] matriz = {{3,4,5},{5,4,1},{1,7,9}};
        // calculo de complejidad suponiendo matriz cuadrada
        // todas las filas con todos los elementos multiplos de 2
        System.out.println(todosLasFilasAlgunMultiploDe(matriz,2));
    }    
        
    private static boolean todosLasFilasAlgunMultiploDe(int[][] matriz, int elemento) {
        boolean rta = true; // 1
        for (int j = 0; j < matriz.length; j++) { // 1 + 2n + 1 + n = 3n + 2 
            rta = rta && algunElementoMultiplo(matriz[j],elemento); // 1n + 1n + n(h(n)) => 
            // 1n + 1n + n( 8n + 4 ) = 2n + 8n^2 + 4n = 6n + 8n^2
         }
        return rta; // 1
    } // f(n) = 8n^2+9n+2
    // f(n) <= c g(n)
    // 8n^2+9n+2 <= 9n^2  // termino dominante mas 1
    // 8n^2/n^2+9n/n^2+2/n^2 <= 9n^2/n^2 // divido por n^2
    // 8 + 9n/n^2 + 2/n^2 <= 9 // 
    // para n0 = 1 no cumple  (8+ 9*1/1*2 + 2/1*2 = 8+9+2 = 19)   19 no es menor que 9
    // para n0 = 2  no cumple  (8+ 9*2/2*2 + 2/2*2 = 13)    13 no es menor que 9
    // para n0 = 10 cumple  , entonces f(n) pertenece a O(n^2) para c = 9 y n0 >= 10

    private static boolean algunElementoMultiplo(int[] fila, int elemento) {
        boolean rta = false; // 1
        for (int j = 0; j < fila.length; j++) { // 1 + 2n + 1 + n = 3n + 2
            rta = rta || fila[j]%elemento==0; // 5n 
        }
        return rta; // 1
    } // h(n) = 8n + 4

    private static boolean algunElementoMultiploRecursivo(int[] fila, int elemento) {
        // caso base tam fila  => suponiendo constante k=0
        // llamado recursivo, algunElementoMultiploRecursivo(fila, elemento,i+1)
    } // a = 1, b= 1 , k=0
    
}
