package EjercicioUno;
public class Persona {
    
    private  String nombre;
    private  String DNI;
    private String telefono;
    private int edad;

    public Persona(String nombre, String dNI, String telefono, int edad) {
        this.nombre = nombre;
        DNI = dNI;
        this.telefono = telefono;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String dNI) {
        DNI = dNI;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "Persona [nombre=" + nombre + ", DNI=" + DNI + ", telefono=" + telefono + ", edad=" + edad + "]";
    }

    


    

}
