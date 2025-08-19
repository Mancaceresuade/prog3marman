public class Factura {
    private int idFactura;
    private int idCliente;
    private double importe;
    
    public Factura(int idFactura, int idCliente, double importe) {
        this.idFactura = idFactura;
        this.idCliente = idCliente;
        this.importe = importe;
    }
    
    // Getters
    public int getIdFactura() {
        return idFactura;
    }
    
    public int getIdCliente() {
        return idCliente;
    }
    
    public double getImporte() {
        return importe;
    }
    
    // Setters
    public void setIdFactura(int idFactura) {
        this.idFactura = idFactura;
    }
    
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void setImporte(double importe) {
        this.importe = importe;
    }
    
    @Override
    public String toString() {
        return "Factura{idFactura=" + idFactura + ", idCliente=" + idCliente + ", importe=" + importe + "}";
    }
}
