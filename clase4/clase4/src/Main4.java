public class Main4 {
    /**
     * Algoritmo de fixture de torneo usando divide y conquista.
     * Cada equipo juega exactamente una vez contra todos los demás en n-1 jornadas (si n es potencia de 2).
     *
     * Paso a paso:
     * 1. Si hay 2 equipos, se enfrentan entre sí.
     * 2. Si hay más, se divide el conjunto en dos mitades, se resuelve recursivamente cada mitad,
     *    y luego se cruzan los equipos de una mitad con los de la otra en las jornadas correspondientes.
     *
     * Es divide y conquista porque:
     * - Divide: Se parte el problema en dos subproblemas de tamaño n/2.
     * - Conquista: Se resuelve cada subproblema recursivamente.
     * - Combina: Se cruzan los equipos de ambas mitades para completar el fixture.
     *
     * Complejidad asintótica: T(n) = 2T(n/2) + O(n^2) => O(n^2)
     * Valores: a = 2 (subproblemas), b = 2 (división), k = 2 (combinación O(n^2))
     */
    public static void main(String[] args) {
        // Lista de equipos de la Primera División Argentina (puedes ajustar la lista según la temporada)
        String[] equipos = {
            "River Plate", "Boca Juniors", "Racing Club", "Independiente",
            "San Lorenzo", "Huracán", "Vélez Sarsfield", "Argentinos Juniors"
        };
        int n = equipos.length;
        if ((n & (n - 1)) != 0) {
            System.out.println("La cantidad de equipos debe ser potencia de 2.");
            return;
        }
        int[][] fixture = new int[n][n - 1];
        generarFixture(fixture, 0, n - 1, 0, n - 2);
        imprimirFixtureConNombres(fixture, equipos);
    }
 
    /**
     * Genera el fixture usando divide y conquista.
     * @param fixture Matriz de partidos [equipo][jornada]
     * @param desde Índice inicial de equipos
     * @param hasta Índice final de equipos
     * @param jornadaDesde Jornada inicial
     * @param jornadaHasta Jornada final
     */
    public static void generarFixture(int[][] fixture, int desde, int hasta, int jornadaDesde, int jornadaHasta) {
        int n = hasta - desde + 1;
        // Caso base: solo dos equipos
        if (n == 2) {
            fixture[desde][jornadaDesde] = hasta + 1;
            fixture[hasta][jornadaDesde] = desde + 1;
            return;
        }
        int mitad = n / 2;
        // Divide: resuelve para cada mitad
        generarFixture(fixture, desde, desde + mitad - 1, jornadaDesde, jornadaDesde + mitad - 2);
        generarFixture(fixture, desde + mitad, hasta, jornadaDesde, jornadaDesde + mitad - 2);
        // Combina: cruza los equipos de ambas mitades
        for (int i = 0; i < mitad; i++) {
            for (int j = 0; j < mitad; j++) {
                int equipoA = desde + i;
                int equipoB = desde + mitad + j;
                int jornada = jornadaDesde + mitad - 1 + j;
                fixture[equipoA][jornada] = equipoB + 1;
                fixture[equipoB][jornada] = equipoA + 1;
            }
        }
    }
 
    /**
     * Imprime el fixture generado.
     */
    public static void imprimirFixtureConNombres(int[][] fixture, String[] equipos) {
        int n = fixture.length;
        int jornadas = fixture[0].length;
        for (int j = 0; j < jornadas; j++) {
            System.out.println("Jornada " + (j + 1) + ":");
            for (int i = 0; i < n; i++) {
                int rival = fixture[i][j];
                if (i < rival - 1) { // Evita imprimir dos veces el mismo partido
                    System.out.println("  " + equipos[i] + " vs " + equipos[rival - 1]);
                }
            }
        }
    }
}