public class App {
    public static void main(String[] args) throws Exception {
        int[] numeros = {4,7,2,9,10};
    }

    public static int maximo(int[] array) {
        int max = array[0]; // 2
        int aux = array.length; // 2
        for (int i = 1; i < aux; i++) { // 1 + n + 1 + n
            if (array[i] > max) { // 2 n
                max = array[i]; // 2n
            }            
        }
        return max; // 1
    } // f(n) = 2 + 2 + 1 + n + 1 + n + 2n + 2n + 1
    // f(n) = 7 + 6n
    // f(n) <= c g(n)
    // 7 + 6n  <= 7n   // termino dominante mas 1
    // 7/n + 6n/n <= 7n/n      // divido por n y simplifico
    // 7/n + 6 <= 7    // 
    // probar valores de n para que cumpla
    // n = 1 cumple ?   no cumple
    // ....
    // a partir de 7 cumple, por lo que f(n) pertenece a O(n)
}
