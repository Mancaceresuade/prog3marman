public class EjemploBusquedaBinaria {
    public static int busquedaBinariaRecursiva(int[] arr, int clave, int inicio, int fin) {
        if (inicio > fin) {
            return -1;
        }
        int medio = inicio + (fin - inicio) / 2;
        if (arr[medio] == clave) {
            return medio;
        } else if (arr[medio] > clave) {
            return busquedaBinariaRecursiva(arr, clave, inicio, medio - 1);
        } else {
            return busquedaBinariaRecursiva(arr, clave, medio + 1, fin);
        }
    }
}
