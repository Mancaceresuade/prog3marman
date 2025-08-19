public class ResumenCliente {
    private int idCliente;
    private String nombreCliente;
    private double sumaImportes;
    
    public ResumenCliente(int idCliente, String nombreCliente, double sumaImportes) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.sumaImportes = sumaImportes;
    }
    
    // Getters
    public int getIdCliente() {
        return idCliente;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    public double getSumaImportes() {
        return sumaImportes;
    }
    
    // Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    public void setSumaImportes(double sumaImportes) {
        this.sumaImportes = sumaImportes;
    }
    
    @Override
    public String toString() {
        return "ResumenCliente{idCliente=" + idCliente + 
               ", nombreCliente='" + nombreCliente + "'" + 
               ", sumaImportes=" + sumaImportes + "}";
    }
}
