import java.util.*;

/**
 * Clase de demostración para el Sistema de Tesorería
 * Muestra diferentes escenarios de uso del algoritmo greedy
 */
public class DemoSistemaTesoreria {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE TESORERÍA - ALGORITMO GREEDY ===\n");
        
        // Crear instancia del sistema
        SistemaTesoreria tesoreria = new SistemaTesoreria();
        
        // Escenario 1: Comprobantes básicos
        System.out.println("ESCENARIO 1: Comprobantes básicos");
        System.out.println("----------------------------------------");
        
        // Agregar comprobantes disponibles
        List<SistemaTesoreria.Comprobante> comprobantes = Arrays.asList(
            new SistemaTesoreria.Comprobante("Moneda", 100.0, "Billete de $100"),
            new SistemaTesoreria.Comprobante("Moneda", 50.0, "Billete de $50"),
            new SistemaTesoreria.Comprobante("Moneda", 20.0, "Billete de $20"),
            new SistemaTesoreria.Comprobante("Moneda", 10.0, "Billete de $10"),
            new SistemaTesoreria.Comprobante("Moneda", 5.0, "Billete de $5"),
            new SistemaTesoreria.Comprobante("Moneda", 1.0, "Moneda de $1")
        );
        
        tesoreria.agregarComprobantes(comprobantes);
        
        // Mostrar comprobantes disponibles
        System.out.println("Comprobantes disponibles:");
        for (SistemaTesoreria.Comprobante comp : tesoreria.getComprobantesDisponibles()) {
            System.out.println("  " + comp.toString());
        }
        System.out.println("Valor total disponible: $" + String.format("%.2f", tesoreria.getValorTotalDisponible()));
        System.out.println();
        
        // Probar diferentes valores objetivo
        double[] valoresObjetivo = {157.0, 200.0, 75.0, 300.0};
        
        for (double valor : valoresObjetivo) {
            System.out.println("Intentando comprar por valor: $" + String.format("%.2f", valor));
            SistemaTesoreria.ResultadoCompra resultado = tesoreria.comprarMonedaExtranjera(valor);
            System.out.println(resultado.toString());
            System.out.println();
        }
        
        // Escenario 2: Comprobantes mixtos (monedas, cheques, bonos)
        System.out.println("ESCENARIO 2: Comprobantes mixtos");
        System.out.println("----------------------------------------");
        
        tesoreria.limpiarComprobantes();
        
        List<SistemaTesoreria.Comprobante> comprobantesMixtos = Arrays.asList(
            new SistemaTesoreria.Comprobante("Bono", 1000.0, "Bono del Tesoro"),
            new SistemaTesoreria.Comprobante("Cheque", 500.0, "Cheque bancario"),
            new SistemaTesoreria.Comprobante("Moneda", 100.0, "Billete de $100"),
            new SistemaTesoreria.Comprobante("Cheque", 250.0, "Cheque personal"),
            new SistemaTesoreria.Comprobante("Moneda", 50.0, "Billete de $50"),
            new SistemaTesoreria.Comprobante("Bono", 200.0, "Bono corporativo"),
            new SistemaTesoreria.Comprobante("Moneda", 25.0, "Billete de $25"),
            new SistemaTesoreria.Comprobante("Moneda", 10.0, "Billete de $10")
        );
        
        tesoreria.agregarComprobantes(comprobantesMixtos);
        
        System.out.println("Comprobantes mixtos disponibles:");
        for (SistemaTesoreria.Comprobante comp : tesoreria.getComprobantesDisponibles()) {
            System.out.println("  " + comp.toString());
        }
        System.out.println("Valor total disponible: $" + String.format("%.2f", tesoreria.getValorTotalDisponible()));
        System.out.println();
        
        // Probar con valores más complejos
        double[] valoresComplejos = {1275.0, 850.0, 2000.0, 125.0};
        
        for (double valor : valoresComplejos) {
            System.out.println("Intentando comprar por valor: $" + String.format("%.2f", valor));
            SistemaTesoreria.ResultadoCompra resultado = tesoreria.comprarMonedaExtranjera(valor);
            System.out.println(resultado.toString());
            System.out.println();
        }
        
        // Escenario 3: Casos límite
        System.out.println("ESCENARIO 3: Casos límite");
        System.out.println("----------------------------------------");
        
        // Caso 1: Valor exacto disponible
        System.out.println("Caso 1: Valor exacto disponible");
        SistemaTesoreria.ResultadoCompra resultadoExacto = tesoreria.comprarMonedaExtranjera(1000.0);
        System.out.println(resultadoExacto.toString());
        System.out.println();
        
        // Caso 2: Valor mayor al disponible
        System.out.println("Caso 2: Valor mayor al disponible");
        SistemaTesoreria.ResultadoCompra resultadoMayor = tesoreria.comprarMonedaExtranjera(5000.0);
        System.out.println(resultadoMayor.toString());
        System.out.println();
        
        // Caso 3: Valor negativo
        System.out.println("Caso 3: Valor negativo");
        SistemaTesoreria.ResultadoCompra resultadoNegativo = tesoreria.comprarMonedaExtranjera(-100.0);
        System.out.println(resultadoNegativo.toString());
        System.out.println();
        
        // Caso 4: Valor cero
        System.out.println("Caso 4: Valor cero");
        SistemaTesoreria.ResultadoCompra resultadoCero = tesoreria.comprarMonedaExtranjera(0.0);
        System.out.println(resultadoCero.toString());
        System.out.println();
        
        System.out.println("=== FIN DE LA DEMOSTRACIÓN ===");
    }
}

