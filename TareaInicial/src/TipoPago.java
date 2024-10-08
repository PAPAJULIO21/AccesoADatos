public class TipoPago {

    private char codigo;
    private String nombre;

    public TipoPago(){
        
    }

    public TipoPago(char codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public char getCodigo() {
        return codigo;
    }

    public void setCodigo(char codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

    
    
}
