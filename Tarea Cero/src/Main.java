import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Cliente cl = new Cliente();
        cl.nuevoCliente();
        System.out.println(cl);
        //Insertar nombre de nuevo cliente

        /*boolean validarN = false;
        String nombre = null;

        do{

            System.out.print("Escribeme tu nombre: ");
            String nombreV = sc.nextLine();

            if(nombreV.length()==0){
                System.out.println("Error en introducir el nombre.");
            }else{
                System.out.println("Tu nombre se ha introducido perfectamente.");
                validarN = true;
                nombre = nombreV;
            }

        }while(!validarN);*/

       /* boolean validarD = false;
        String direccion = null;

        do{

            System.out.print("Escribeme tu direccion: ");
            String direccionV = sc.nextLine();

            if(direccionV.length() < 5){
                System.out.println("Error en introducir el dirrecion.");
            }else{
                System.out.println("Tu direccion se ha introducido perfectamente.");
                direccion = direccionV;
                validarD = true;
            }

        }while(!validarD);*/ 
        /* 
        boolean validarT = false;
        String telefono = null;

        do{

            System.out.print("Escribeme tu telefono sin ningun +34 ni ningun +algo (solo los 9 digitos): ");
            String telefonoV = sc.nextLine();

            //Ayuda de ChatGPT
            if(!telefonoV.chars().allMatch(Character::isDigit)){
                System.out.println("Error en introducir tu telefono.");
            }else{
                System.out.println("Tu telefono se ha introducido perfectamente.");
                telefono = telefonoV;
                validarT = true;
            }

        }while(!validarT);*/

        /*String fechaNacimientoStr;
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

        } while (!fechaValida);*/

        /*boolean validarID = false;
        Documentacion id = null;

        do{

            System.out.print("Que quieres escribir el NIE o el NIF: ");
            String NIEF = sc.nextLine();

            if(NIEF.toUpperCase().equals("NIE") || NIEF.toUpperCase().equals("NIF")){
                System.out.println("Es correcto");
                validarID = true;

            }else{
                System.out.println("No es correcto");
            }

        }while(!validarID);*/


       /*  boolean validarID = false;
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

        System.out.println(id);*/



        
    }
    
}
