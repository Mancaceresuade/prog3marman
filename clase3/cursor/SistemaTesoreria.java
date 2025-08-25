import java.util.*;

/**
 * Sistema de Tesorería que resuelve el problema de compra de moneda extranjera
 * minimizando el número de comprobantes utilizados mediante algoritmo greedy.
 * 
 * Complejidad algorítmica: O(n log n) donde n es el número de comprobantes
 * - Ordenamiento: O(n log n)
 * - Selección greedy: O(n)
 * - Total: O(n log n)
 */
public class SistemaTesoreria {
    
    /**
     * Clase que representa un comprobante financiero
     */
    public static class Comprobante {
        private String tipo;
        private double valor;
        private String descripcion;
        
        public Comprobante(String tipo, double valor, String descripcion) {
            this.tipo = tipo;
            this.valor = valor;
            this.descripcion = descripcion;
        }
        
        public String getTipo() { return tipo; }
        public double getValor() { return valor; }
        public String getDescripcion() { return descripcion; }
        
        @Override
        public String toString() {
            return String.format("%s - $%.2f (%s)", tipo, valor, descripcion);
        }
    }
    
    /**
     * Resultado de la operación de compra
     */
    public static class ResultadoCompra {
        private List<Comprobante> comprobantesUtilizados;
        private double valorTotal;
        private int cantidadComprobantes;
        private boolean exito;
        private String mensaje;
        
        public ResultadoCompra(List<Comprobante> comprobantes, double valorTotal, boolean exito, String mensaje) {
            this.comprobantesUtilizados = comprobantes;
            this.valorTotal = valorTotal;
            this.cantidadComprobantes = comprobantes != null ? comprobantes.size() : 0;
            this.exito = exito;
            this.mensaje = mensaje;
        }
        
        // Getters
        public List<Comprobante> getComprobantesUtilizados() { return comprobantesUtilizados; }
        public double getValorTotal() { return valorTotal; }
        public int getCantidadComprobantes() { return cantidadComprobantes; }
        public boolean isExito() { return exito; }
        public String getMensaje() { return mensaje; }
        
        @Override
        public String toString() {
            if (!exito) {
                return "Error: " + mensaje;
            }
            
            StringBuilder sb = new StringBuilder();
            sb.append("Compra exitosa!\n");
            sb.append("Valor objetivo: $").append(String.format("%.2f", valorTotal)).append("\n");
            sb.append("Comprobantes utilizados: ").append(cantidadComprobantes).append("\n");
            sb.append("Detalle:\n");
            
            for (Comprobante comp : comprobantesUtilizados) {
                sb.append("  - ").append(comp.toString()).append("\n");
            }
            
            return sb.toString();
        }
    }
    
    private List<Comprobante> comprobantesDisponibles;
    
    public SistemaTesoreria() {
        this.comprobantesDisponibles = new ArrayList<>();
    }
    
    /**
     * Agrega un comprobante al sistema
     */
    public void agregarComprobante(Comprobante comprobante) {
        comprobantesDisponibles.add(comprobante);
    }
    
    /**
     * Agrega múltiples comprobantes al sistema
     */
    public void agregarComprobantes(List<Comprobante> comprobantes) {
        comprobantesDisponibles.addAll(comprobantes);
    }
    
    /**
     * Algoritmo greedy para comprar moneda extranjera minimizando comprobantes
     * 
     * @param valorObjetivo El valor que se desea alcanzar
     * @return ResultadoCompra con los comprobantes utilizados
     */
    public ResultadoCompra comprarMonedaExtranjera(double valorObjetivo) {
        // Contador de instrucciones para análisis de complejidad
        int instrucciones = 0;
        
        // Verificación inicial
        if (valorObjetivo <= 0) {
            instrucciones += 2; // if + return
            return new ResultadoCompra(null, valorObjetivo, false, "El valor objetivo debe ser positivo");
        }
        
        if (comprobantesDisponibles.isEmpty()) {
            instrucciones += 2; // if + return
            return new ResultadoCompra(null, valorObjetivo, false, "No hay comprobantes disponibles");
        }
        
        instrucciones += 3; // verificaciones iniciales
        
        // Crear copia de la lista para no modificar la original
        List<Comprobante> comprobantesOrdenados = new ArrayList<>(comprobantesDisponibles);
        instrucciones += 1; // creación de ArrayList
        
        // Ordenar comprobantes de mayor a menor valor (O(n log n))
        comprobantesOrdenados.sort((c1, c2) -> Double.compare(c2.getValor(), c1.getValor()));
        instrucciones += 1; // sort
        
        List<Comprobante> comprobantesUtilizados = new ArrayList<>();
        double valorRestante = valorObjetivo;
        int i = 0;
        
        instrucciones += 3; // inicializaciones
        
        // Algoritmo greedy principal
        while (valorRestante > 0 && i < comprobantesOrdenados.size()) {
            Comprobante comprobanteActual = comprobantesOrdenados.get(i);
            
            if (comprobanteActual.getValor() <= valorRestante) {
                // Usar este comprobante
                comprobantesUtilizados.add(comprobanteActual);
                valorRestante -= comprobanteActual.getValor();
                instrucciones += 3; // get, add, resta
            } else {
                // Pasar al siguiente comprobante
                i++;
                instrucciones += 1; // incremento
            }
            
            instrucciones += 2; // while + if
        }
        
        // Verificar si se logró el objetivo
        if (valorRestante == 0) {
            instrucciones += 1; // if
            return new ResultadoCompra(comprobantesUtilizados, valorObjetivo, true, "Compra exitosa");
        } else {
            instrucciones += 1; // else
            return new ResultadoCompra(null, valorObjetivo, false, 
                "No es posible realizar la compra. Valor restante: $" + String.format("%.2f", valorRestante));
        }
    }
    
    /**
     * Obtiene todos los comprobantes disponibles
     */
    public List<Comprobante> getComprobantesDisponibles() {
        return new ArrayList<>(comprobantesDisponibles);
    }
    
    /**
     * Obtiene el valor total de todos los comprobantes disponibles
     */
    public double getValorTotalDisponible() {
        return comprobantesDisponibles.stream()
                .mapToDouble(Comprobante::getValor)
                .sum();
    }
    
    /**
     * Limpia todos los comprobantes del sistema
     */
    public void limpiarComprobantes() {
        comprobantesDisponibles.clear();
    }
}
