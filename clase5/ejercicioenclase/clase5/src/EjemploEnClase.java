import java.util.HashMap;

public class EjemploEnClase {
    public static void main(String[] args) {
        System.out.println(fibonacciA(8));
    }

    private static HashMap<Integer, Long> fibMap = new HashMap<>();
    public static long fibonacciA(int n) {
        // Caso base: fib(0) = 0, fib(1) = 1
        if (n <= 1) {
            fibMap.put(n, (long) n); // Guarda el resultado en el HashMap
            return n;
        }
        // PROGRAMACIÓN DINÁMICA: aquí se utiliza memoización para evitar cálculos repetidos
        // Si el valor ya fue calculado, lo retorna directamente del HashMap
        if (fibMap.containsKey(n)) {
            return fibMap.get(n);
        }
        // Si no está calculado, lo calcula recursivamente y lo almacena
        // RECURSIVIDAD: aquí la función se llama a sí misma para resolver subproblemas
        long value = fibonacci(n - 1) + fibonacci(n - 2);
        fibMap.put(n, value); // Guarda el resultado para futuras llamadas
        return value;
    }  // a= 2 b=1 k=0  metodo sustraccion =>   O(n)

    // fibonacci con programacion dinamica, guardando en un hashmap
    // utilar un hashmap, para guardar los resultados ya cualculados
    // en el algoritmo recursivo



    private static int fibonacci(int numero) {
        if(numero==0) return 0;
        if(numero==1) return 1;
        return fibonacci(numero-1) + fibonacci(numero-2);
    } // a=2, b=1, k=0 metodo=sustraccion, caso tercer caso   O(2**n)

    public static int fibonacciIterativo(int n) {
        if (n == 0) return 0; // 1
        if (n == 1) return 1; // 1
        int a = 0, b = 1, c = 0; // 3
        for (int i = 2; i <= n; i++) { // 1+2n+n  
            c = a + b; //  n
            a = b;// n
            b = c;// n
        }
        return c; // 1
    } // f(n) = 7+6n

}
