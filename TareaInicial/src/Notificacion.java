import java.time.LocalDate;


public class Notificacion {
    
    protected long id;
    protected LocalDate fecha;
    protected String mensaje;

    public Notificacion(Long id, String mensaje) {
        this.id = id;
        this.fecha = LocalDate.now();
        this.mensaje = mensaje;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

    @Override
    public String toString() {
        return "Notificacion [id=" + id + ", fecha=" + fecha + ", mensaje=" + mensaje + "]";
    }

   
    

}
