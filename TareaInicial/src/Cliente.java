import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import javax.sound.sampled.Line;

public class Cliente {

    private Documentacion id;
    private String nombre;
    private String direccion;
    private String telefono;
    private LocalDate fechaNac;
    private boolean suscripcion;
    private char pagoPref;

    public Cliente(){

    }

    public Cliente(Documentacion id, String nombre, String direccion, String telefono, LocalDate fechaNac) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaNac = fechaNac;
        this.suscripcion = false;
        this.pagoPref = 'E';
    }

    public Documentacion getId() {
        return id;
    }

    public void setId(Documentacion id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(LocalDate fechaNac) {
        this.fechaNac = fechaNac;
    }

    public boolean isSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(boolean suscripcion) {
        this.suscripcion = suscripcion;
    }

    public char getPagoPref() {
        return pagoPref;
    }

    public void setPagoPref(char pagoPref) {
        this.pagoPref = pagoPref;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono
                + ", fechaNac=" + fechaNac + ", suscripcion=" + suscripcion + ", pagoPref=" + pagoPref + "]";
    }


    public static Cliente nuevoCliente(){
        Scanner sc = new Scanner(System.in);

        //Insertar nombre de nuevo cliente

        boolean validarN = false;
        String nombre = null;

        do{

            System.out.print("Escribeme tu nombre: ");
            String nombreV = sc.nextLine();

            if(nombreV.length()==0){
                System.out.println("Error en introducir el nombre.");
            }else{
                System.out.println("Tu nombre se ha introducido perfectamente.");
                nombre = nombreV;
                validarN = true;
            }

        }while(!validarN);


        //Insertar direccion del nuevo cliente
        boolean validarD = false;
        String direccion = null;

        do{

            System.out.print("Escribeme tu direccion: ");
            String direccionV = sc.nextLine();

            if(direccionV.length() < 5){
                System.out.println("Error en introducir tu dirreccion.");
            }else{
                System.out.println("Tu dirreccion se ha introducido perfectamente.");
                direccion = direccionV;
                validarD = true;
            }

        }while(!validarD);

        //Introducir telefono
        boolean validarT = false;
        String telefono = null;

        do{

            System.out.print("Escribeme tu telefono sin ningun +34 ni ningun +algo (solo los 9 digitos): ");
            String telefonoV = sc.nextLine();

            //Ayuda de ChatGPT
            if(!telefonoV.chars().allMatch(Character::isDigit) && telefonoV.length() == 9){
                System.out.println("Error en introducir tu telefono.");
            }else{
                System.out.println("Tu telefono se ha introducido perfectamente.");
                telefono = telefonoV;
                validarT = true;
            }

        }while(!validarT);

        //Introducimos la fehca de Nacimiento
        //Echo por ChatGPT

        String fechaNacimientoStr;
        boolean fechaValida = false;
        LocalDate fechaNacimiento = null;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        do {
            System.out.println("Introduce tu fecha de nacimiento (dd/MM/yyyy): ");
            fechaNacimientoStr = sc.nextLine();

            try {
                fechaNacimiento = LocalDate.parse(fechaNacimientoStr, formatter);
                fechaValida = true;
            } catch (DateTimeParseException e) {
                System.out.println("La fecha no es válida. Por favor, intenta nuevamente.");
            }

        } while (!fechaValida);


        //Introducimos ID

        boolean validarID = false;
        Documentacion id = null;

        do{

            System.out.print("Que quieres escribir el NIE o el NIF: ");
            String NIEF = sc.nextLine();

            if(NIEF.toUpperCase().equals("NIE") || NIEF.toUpperCase().equals("NIF")){//Para ver si escribe bien NIE o NIF.

                if (NIEF.toUpperCase().equals("NIE")) { //Si escribe NIE que se meta aqui.
                    System.out.print("Escribeme la primera letra del NIE: ");
                    String primera = sc.nextLine();
                    char letraP = primera.charAt(0);
                    char letraPM = Character.toUpperCase(letraP);
                    System.out.println("Escribeme los numeros del NIE: ");
                    String numeros = sc.nextLine();
                    System.out.print("Escribeme la ultima letra del NIE: ");
                    String segunda = sc.nextLine();
                    char letraU = segunda.charAt(0);
                    char letraUM = Character.toUpperCase(letraU);

                    NIE nie = new NIE(numeros,letraPM,letraUM);

                    if (nie.validar() == true) {
                        System.out.println("El NIE es correcto.");
                        validarID = true;
                        id = nie;
                    }else{
                        System.out.println("El NIE es incorrecto. Tienes que volver a repetir el proceso.");
                    }
                    
                }else{ //SI escribe NIF que se meta aqui.
                    System.out.println("Escribeme los numeros del NIF: ");
                    String numeros = sc.nextLine();
                    System.out.print("Escribeme la ultima letra del NIF: ");
                    String segunda = sc.nextLine();
                    char letraU = segunda.charAt(0);
                    char letraUM = Character.toUpperCase(letraU);

                    NIF nif = new NIF(numeros,letraUM);

                    if (nif.validar() == true) {
                        System.out.println("El NIF es correcto.");
                        validarID = true;
                        id = nif;
                    }else{
                        System.out.println("El NIF es incorrecto. Tienes que volver a repetir el proceso.");
                    }
                }

            }else{
                System.out.println("No es correcto");
            }

        }while(!validarID);

        Cliente cl = new Cliente(id,nombre,direccion,telefono,fechaNacimiento);

        boolean validarS = false;
        boolean suscripcion = false;

        do{

            System.out.print("Te quieres suscribir escribe si o no: ");
            String SN = sc.nextLine();

            if (SN.toUpperCase().equals("SI")) {
                suscripcion = true;
                validarS = true;
                
            }else if(SN.toUpperCase().equals("NO")){
                suscripcion = false;
                validarS = true;
            }else{
                System.out.println("Escribeme si o no.");
            }

        }while (!validarS);

        if(suscripcion == true){
            cl.setSuscripcion(true);
        }
        
        return cl;
    }

    

    
}
