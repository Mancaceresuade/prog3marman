package edu.tuuni.examen.servicio;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Completar {

    public List<Integer> reconstruirSolucion(int[][] d, int[] c, int[] r, int pr) {
        if (d == null || c == null || r == null) return Collections.emptyList();
        int n = c.length;
        if (n == 0 || d.length < n + 1 || pr < 0) return Collections.emptyList();
        int presupuesto = Math.min(pr, d[0].length - 1);

        List<Integer> seleccion = new ArrayList<>();
        int i = n;
        int p = presupuesto;
        while (i > 0 && p >= 0) {
            if (d[i][p] == d[i - 1][p]) {
                i = i - 1;
                continue;
            }
            int costo = c[i - 1];
            int valor = r[i - 1];
            if (costo <= p && d[i][p] == valor + d[i - 1][p - costo]) {
                seleccion.add(i - 1);
                p = p - costo;
                i = i - 1;
            } else {
                i = i - 1;
            }
        }
        Collections.sort(seleccion);
        return seleccion;
    }

    
}
