public class App {

    private static boolean estaOrdenada(String s, int i) {
        // Caso base: ya comparé hasta el penúltimo carácter
        if (i >= s.length() - 1) return true;
 
        // Si encuentro una pareja desordenada, corto
        if (s.charAt(i) > s.charAt(i + 1)) return false;
 
        // Llamada recursiva sobre el subproblema de tamaño n-1
        return estaOrdenada(s, i + 1);
    } // a = 1  b = 1  k= 0  =>   O(n)
 
    public static boolean estaOrdenada(String s) {
        return estaOrdenada(s, 0);
    }
 
    public static void main(String[] args) {
        String ejemplo1 = "abcde";   // ordenado
        String ejemplo2 = "abczxy";  // no ordenado
        String ejemplo3 = "a";       // ordenado
        String ejemplo4 = "mnopq";   // ordenado
 
        System.out.println(ejemplo1 + " -> " + estaOrdenada(ejemplo1));
        System.out.println(ejemplo2 + " -> " + estaOrdenada(ejemplo2));
        System.out.println(ejemplo3 + " -> " + estaOrdenada(ejemplo3));
        System.out.println(ejemplo4 + " -> " + estaOrdenada(ejemplo4));
    }
}
