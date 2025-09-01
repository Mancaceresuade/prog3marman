import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CambioMonedas {
    // Función para encontrar la cantidad mínima de monedas
    //       n     n log n      2+2n
    // para 50     84         102
    // para 100    200        202
    public static List<Integer> encontrarMinimoMonedas(int[] monedas, int monto) {
        Arrays.sort(monedas); // 
        List<Integer> resultado = new ArrayList<>(); // n log n
        for (int i = monedas.length - 1; i >= 0; i--) {  // 2 + n + n
            while (monto >= monedas[i]) { // k en caso promedio
                monto -= monedas[i];
                resultado.add(monedas[i]);
            }
        }
        return resultado;
    } // complejidad ? caso promedio

    public static void main(String[] args) {
        int[] monedas = { 1, 5, 10, 25 };
        int monto = 36;
        List<Integer> resultado = encontrarMinimoMonedas(monedas, monto);
        System.out.println("Monedas usadas para hacer " + monto + ": " + resultado);
    }
}