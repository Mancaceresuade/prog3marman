public class Main {
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
        String nombreCliente;
        double sumaImportes;

        ResumenCliente(int idCliente, String nombreCliente, double sumaImportes) {
            this.idCliente = idCliente;
            this.nombreCliente = nombreCliente;
            this.sumaImportes = sumaImportes;
        }

        @Override
        public String toString() {
            return idCliente + " - " + nombreCliente + " - " + sumaImportes;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Juan"),
            new Cliente(2, "Ana"),
            new Cliente(3, "Luis")
        };

        Factura[] facturas = {
            new Factura(101, 1, 100.0),
            new Factura(102, 2, 200.0),
            new Factura(103, 1, 150.0),
            new Factura(104, 3, 300.0),
            new Factura(105, 2, 50.0)
        };

        ResumenCliente[] resumenes = new ResumenCliente[clientes.length];

        for (int i = 0; i < clientes.length; i++) {
            double suma = 0;
            for (Factura f : facturas) {
                if (f.idCliente == clientes[i].id) {
                    suma += f.importe;
                }
            }
            resumenes[i] = new ResumenCliente(clientes[i].id, clientes[i].nombre, suma);
        }  // pertenece a O(n^2)

        for (ResumenCliente r : resumenes) {
            System.out.println(r);
        }  // pertenece a O(n)
    } // O(n^2) + O(n)  => O(n^2)
}
