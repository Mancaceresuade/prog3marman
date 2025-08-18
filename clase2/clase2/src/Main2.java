import java.util.*;

public class Main2 {
    static class Cliente {
        int id;
        String nombre;
        Cliente(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }
    }

    static class Factura {
        int idFactura;
        int idCliente;
        double importe;
        Factura(int idFactura, int idCliente, double importe) {
            this.idFactura = idFactura;
            this.idCliente = idCliente;
            this.importe = importe;
        }
    }

    static class ResumenCliente {
        int idCliente;
        String nombre;
        double sumaImportes;
        ResumenCliente(int idCliente, String nombre, double sumaImportes) {
            this.idCliente = idCliente;
            this.nombre = nombre;
            this.sumaImportes = sumaImportes;
        }
        @Override
        public String toString() {
            return "ID: " + idCliente + ", Nombre: " + nombre + ", Total: " + sumaImportes;
        }
    }

    public static void main(String[] args) {
        List<Cliente> clientes = Arrays.asList(
            new Cliente(1, "Juan"),
            new Cliente(2, "Ana"),
            new Cliente(3, "Luis")
        );

        List<Factura> facturas = Arrays.asList(
            new Factura(101, 1, 100.0),
            new Factura(102, 2, 200.0),
            new Factura(103, 1, 150.0),
            new Factura(104, 3, 300.0),
            new Factura(105, 2, 50.0)
        );

        Map<Integer, Double> sumaImportesPorCliente = new HashMap<>();
        for (Factura f : facturas) {
            sumaImportesPorCliente.put(f.idCliente,
                sumaImportesPorCliente.getOrDefault(f.idCliente, 0.0) + f.importe);
        }  // consto lineal O(n)

        List<ResumenCliente> resumen = new LinkedList<>();
        for (Cliente c : clientes) {
            double total = sumaImportesPorCliente.getOrDefault(c.id, 0.0);
            resumen.add(new ResumenCliente(c.id, c.nombre, total));
        } // consto lineal O(n)

        for (ResumenCliente r : resumen) {
            System.out.println(r);
        } // consto lineal O(n)
    } // consto lineal O(n)
}
