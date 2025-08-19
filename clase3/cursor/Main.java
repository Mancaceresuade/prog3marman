import java.util.ArrayList;
import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE FACTURACIÓN EN JAVA ===\n");
        
        // Crear datos de ejemplo
        List<Cliente> clientes = crearClientesEjemplo();
        List<Factura> facturas = crearFacturasEjemplo();
        
        System.out.println("Datos de entrada:");
        System.out.println("Clientes: " + clientes);
        System.out.println("Facturas: " + facturas);
        System.out.println();
        
        // Probar implementación SIN Maps
        System.out.println("--- IMPLEMENTACIÓN SIN MAPS ---");
        long inicio = System.nanoTime();
        List<ResumenCliente> resumenesSinMaps = SistemaFacturacionSinMaps.generarResumenSinMaps(clientes, facturas);
        long fin = System.nanoTime();
        long tiempoSinMaps = fin - inicio;
        
        System.out.println("Resultado:");
        for (ResumenCliente resumen : resumenesSinMaps) {
            System.out.println(resumen);
        }
        System.out.println("Tiempo de ejecución: " + tiempoSinMaps + " nanosegundos");
        System.out.println();
        
        // Probar implementación CON Maps
        System.out.println("--- IMPLEMENTACIÓN CON MAPS ---");
        inicio = System.nanoTime();
        List<ResumenCliente> resumenesConMaps = SistemaFacturacionConMaps.generarResumenConMaps(clientes, facturas);
        fin = System.nanoTime();
        long tiempoConMaps = fin - inicio;
        
        System.out.println("Resultado:");
        for (ResumenCliente resumen : resumenesConMaps) {
            System.out.println(resumen);
        }
        System.out.println("Tiempo de ejecución: " + tiempoConMaps + " nanosegundos");
        System.out.println();
        
        // Comparación de rendimiento
        System.out.println("--- COMPARACIÓN DE RENDIMIENTO ---");
        System.out.println("Sin Maps: " + tiempoSinMaps + " ns");
        System.out.println("Con Maps: " + tiempoConMaps + " ns");
        System.out.println("Mejora: " + String.format("%.2f", (double)tiempoSinMaps/tiempoConMaps) + "x más rápido con Maps");
        System.out.println();
        
        // Análisis de complejidad asintótica
        System.out.println("--- ANÁLISIS DE COMPLEJIDAD ASINTÓTICA ---");
        System.out.println("Asumiendo n = cantidad de clientes ≈ cantidad de facturas:");
        System.out.println();
        System.out.println("SIN MAPS (búsqueda secuencial):");
        System.out.println("- Para cada cliente (n): buscar en todas las facturas (n)");
        System.out.println("- Complejidad: O(n²)");
        System.out.println();
        System.out.println("CON MAPS (HashMap):");
        System.out.println("- Construir Map de clientes: O(n)");
        System.out.println("- Procesar facturas: O(n)");
        System.out.println("- Búsqueda en Map: O(1) promedio");
        System.out.println("- Complejidad total: O(n)");
        System.out.println();
        System.out.println("DIFERENCIA:");
        System.out.println("- Sin Maps: O(n²) - cuadrática");
        System.out.println("- Con Maps: O(n) - lineal");
        System.out.println("- Para n grande, Maps es significativamente más eficiente");
        
        // Probar con más datos para demostrar la diferencia
        System.out.println("\n--- PRUEBA CON MÁS DATOS ---");
        probarConMasDatos();
    }
    
    private static List<Cliente> crearClientesEjemplo() {
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente(1, "Juan Pérez"));
        clientes.add(new Cliente(2, "María García"));
        clientes.add(new Cliente(3, "Carlos López"));
        return clientes;
    }
    
    private static List<Factura> crearFacturasEjemplo() {
        List<Factura> facturas = new ArrayList<>();
        facturas.add(new Factura(1, 1, 100.50));
        facturas.add(new Factura(2, 1, 75.25));
        facturas.add(new Factura(3, 2, 200.00));
        facturas.add(new Factura(4, 3, 150.75));
        facturas.add(new Factura(5, 2, 125.50));
        facturas.add(new Factura(6, 1, 300.00));
        return facturas;
    }
    
    private static void probarConMasDatos() {
        System.out.println("Creando 1000 clientes y 1000 facturas...");
        
        List<Cliente> muchosClientes = new ArrayList<>();
        List<Factura> muchasFacturas = new ArrayList<>();
        
        for (int i = 1; i <= 1000; i++) {
            muchosClientes.add(new Cliente(i, "Cliente " + i));
            muchasFacturas.add(new Factura(i, i, Math.random() * 1000));
        }
        
        // Probar implementación sin Maps
        long inicio = System.nanoTime();
        SistemaFacturacionSinMaps.generarResumenSinMaps(muchosClientes, muchasFacturas);
        long fin = System.nanoTime();
        long tiempoSinMaps = fin - inicio;
        
        // Probar implementación con Maps
        inicio = System.nanoTime();
        SistemaFacturacionConMaps.generarResumenConMaps(muchosClientes, muchasFacturas);
        fin = System.nanoTime();
        long tiempoConMaps = fin - inicio;
        
        System.out.println("Resultados con 1000 clientes y 1000 facturas:");
        System.out.println("Sin Maps: " + tiempoSinMaps + " ns (" + String.format("%.2f", tiempoSinMaps/1000000.0) + " ms)");
        System.out.println("Con Maps: " + tiempoConMaps + " ns (" + String.format("%.2f", tiempoConMaps/1000000.0) + " ms)");
        System.out.println("Mejora: " + String.format("%.2f", (double)tiempoSinMaps/tiempoConMaps) + "x más rápido con Maps");
    }
}
