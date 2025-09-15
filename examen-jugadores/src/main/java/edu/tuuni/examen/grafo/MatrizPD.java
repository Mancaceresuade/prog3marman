package edu.tuuni.examen.grafo;

public class MatrizPD {
    private int[] costos;
    private int[] rendimientos;
    private int[][] dp;

    public MatrizPD(int[] costos, int[] rendimientos) {
        this.costos = costos;
        this.rendimientos = rendimientos;
    }

    public int resolver(int presupuesto) {
        int n = costos.length;
        dp = new int[n + 1][presupuesto + 1];
        for (int i = 0; i <= n; i++) {
            for (int p = 0; p <= presupuesto; p++) {
                if (i == 0 || p == 0) {
                    dp[i][p] = 0;
                } else if (costos[i - 1] <= p) {
                    dp[i][p] = Math.max(
                        rendimientos[i - 1] + dp[i - 1][p - costos[i - 1]],
                        dp[i - 1][p]
                    );
                } else {
                    dp[i][p] = dp[i - 1][p];
                }
            }
        }
        return dp[n][presupuesto];
    }

    public int[][] getDpTable() { return dp; }
}
