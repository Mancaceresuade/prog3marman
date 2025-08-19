import java.util.ArrayList;
import java.util.List;

public class SistemaFacturacionSinMaps {
    
    /**
     * Genera un resumen de clientes con la suma de importes de sus facturas
     * SIN usar Maps - implementación con listas anidadas
     * 
     * @param clientes Lista de clientes
     * @param facturas Lista de facturas
     * @return Lista de resúmenes de clientes con suma de importes
     */
    public static List<ResumenCliente> generarResumenSinMaps(List<Cliente> clientes, List<Factura> facturas) {
        List<ResumenCliente> resumenes = new ArrayList<>();
        
        // Para cada cliente, buscar sus facturas y sumar importes
        for (Cliente cliente : clientes) {
            double sumaImportes = 0.0;
            
            // Buscar todas las facturas de este cliente
            for (Factura factura : facturas) {
                if (factura.getIdCliente() == cliente.getIdCliente()) {
                    sumaImportes += factura.getImporte();
                }
            }
            
            // Crear el resumen del cliente
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
     * Método alternativo que optimiza la búsqueda de facturas por cliente
     * usando un enfoque de búsqueda secuencial mejorada
     */
    public static List<ResumenCliente> generarResumenSinMapsOptimizado(List<Cliente> clientes, List<Factura> facturas) {
        List<ResumenCliente> resumenes = new ArrayList<>();
        
        // Crear una lista de facturas agrupadas por cliente
        List<List<Factura>> facturasPorCliente = new ArrayList<>();
        for (int i = 0; i < clientes.size(); i++) {
            facturasPorCliente.add(new ArrayList<>());
        }
        
        // Agrupar facturas por cliente
        for (Factura factura : facturas) {
            for (int i = 0; i < clientes.size(); i++) {
                if (clientes.get(i).getIdCliente() == factura.getIdCliente()) {
                    facturasPorCliente.get(i).add(factura);
                    break;
                }
            }
        }
        
        // Generar resúmenes
        for (int i = 0; i < clientes.size(); i++) {
            Cliente cliente = clientes.get(i);
            double sumaImportes = 0.0;
            
            for (Factura factura : facturasPorCliente.get(i)) {
                sumaImportes += factura.getImporte();
            }
            
            ResumenCliente resumen = new ResumenCliente(
                cliente.getIdCliente(), 
                cliente.getNombreCliente(), 
                sumaImportes
            );
            resumenes.add(resumen);
        }
        
        return resumenes;
    }
}
