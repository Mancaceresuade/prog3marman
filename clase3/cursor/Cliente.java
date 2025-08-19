public class Cliente {
    private int idCliente;
    private String nombreCliente;
    
    public Cliente(int idCliente, String nombreCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
    }
    
    // Getters
    public int getIdCliente() {
        return idCliente;
    }
    
    public String getNombreCliente() {
        return nombreCliente;
    }
    
    // Setters
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
    
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }
    
    @Override
    public String toString() {
        return "Cliente{idCliente=" + idCliente + ", nombreCliente='" + nombreCliente + "'}";
    }
}
