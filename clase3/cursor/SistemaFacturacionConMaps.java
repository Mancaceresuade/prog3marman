import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaFacturacionConMaps {
    
    /**
     * Genera un resumen de clientes con la suma de importes de sus facturas
     * USANDO Maps para optimizar la búsqueda
     * 
     * @param clientes Lista de clientes
     * @param facturas Lista de facturas
     * @return Lista de resúmenes de clientes con suma de importes
     */
    public static List<ResumenCliente> generarResumenConMaps(List<Cliente> clientes, List<Factura> facturas) {
        List<ResumenCliente> resumenes = new ArrayList<>();
        
        // Crear un Map para acceder rápidamente a los clientes por ID
        Map<Integer, Cliente> mapaClientes = new HashMap<>();
        for (Cliente cliente : clientes) {
            mapaClientes.put(cliente.getIdCliente(), cliente);
        }
        
        // Crear un Map para acumular los importes por cliente
        Map<Integer, Double> importesPorCliente = new HashMap<>();
        
        // Inicializar todos los clientes con importe 0
        for (Cliente cliente : clientes) {
            importesPorCliente.put(cliente.getIdCliente(), 0.0);
        }
        
        // Sumar importes de facturas
        for (Factura factura : facturas) {
            int idCliente = factura.getIdCliente();
            if (importesPorCliente.containsKey(idCliente)) {
                double importeActual = importesPorCliente.get(idCliente);
                importesPorCliente.put(idCliente, importeActual + factura.getImporte());
            }
        }
        
        // Generar resúmenes
        for (Cliente cliente : clientes) {
            double sumaImportes = importesPorCliente.get(cliente.getIdCliente());
            
            ResumenCliente resumen = new ResumenCliente(
                cliente.getIdCliente(), 
                cliente.getNombreCliente(), 
                sumaImportes
            );
            resumenes.add(resumen);
        }
        
        return resumenes;
    }
    
    /**
     * Implementación alternativa más eficiente usando un solo Map
     */
    public static List<ResumenCliente> generarResumenConMapsEficiente(List<Cliente> clientes, List<Factura> facturas) {
        // Crear un Map que mapea ID de cliente a un objeto con nombre y suma de importes
        Map<Integer, ResumenCliente> resumenesMap = new HashMap<>();
        
        // Inicializar el Map con todos los clientes
        for (Cliente cliente : clientes) {
            resumenesMap.put(cliente.getIdCliente(), 
                new ResumenCliente(cliente.getIdCliente(), cliente.getNombreCliente(), 0.0));
        }
        
        // Procesar facturas y acumular importes
        for (Factura factura : facturas) {
            int idCliente = factura.getIdCliente();
            if (resumenesMap.containsKey(idCliente)) {
                ResumenCliente resumen = resumenesMap.get(idCliente);
                resumen.setSumaImportes(resumen.getSumaImportes() + factura.getImporte());
            }
        }
        
        // Convertir el Map a Lista
        return new ArrayList<>(resumenesMap.values());
    }
}
