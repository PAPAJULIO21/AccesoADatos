public class NEmail extends Notificacion {

    private String direccion;

    public NEmail(Long id, String mensaje, String direccion) {
        super(id, mensaje);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "NEmail [direccion=" + direccion + "]";
    }

    
}
