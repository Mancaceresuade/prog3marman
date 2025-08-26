public class Torneo {
    public static void main(String[] args) {
        String[] equipos = {"River","Boca","Independiente","Racing"};
        // imprimirPartidos(equipos);
        fixtureTorneo(equipos);
    }
    private static void imprimirPartidos(String[] equipos) {
        for (int i = 0; i < equipos.length; i++) {
            for (int j = i+1; j < equipos.length; j++) { // gaus n (n-1)/2
                System.out.println(equipos[i]+" vs "+ equipos[j]);
            }
        }
    }   
    public static void fixtureTorneo(String[] equipos) {
        int n = equipos.length;
        if ((n & (n - 1)) != 0) {
            System.out.println("El número de equipos no es potencia de 2.");
            return;
        }
        String[] tempEquipos = equipos.clone();
        for (int ronda = 0; ronda < n - 1; ronda++) {
            System.out.println("Jornada " + (ronda + 1) + ":");
            for (int i = 0; i < n / 2; i++) {
                System.out.println(tempEquipos[i] + " vs " + tempEquipos[n - 1 - i]);
            }
            // Rotación de los equipos (excepto el primero)
            String ultimo = tempEquipos[n - 1];
            for (int i = n - 1; i > 1; i--) {
                tempEquipos[i] = tempEquipos[i - 1];
            }
            tempEquipos[1] = ultimo;
            System.out.println();
        }
    }
}
