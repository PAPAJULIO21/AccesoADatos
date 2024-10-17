package EjercicioUno;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.*;

public class CrearFicheroDat {


    public static void main(String[] args) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("FichPersona.dat"))) {
            // Crear varias personas
            Persona p1 = new Persona("Juan Pérez", "12345678A", "987654321", 30);
            Persona p2 = new Persona("María López", "87654321B", "912345678", 25);
            Persona p3 = new Persona("Carlos Sánchez", "56781234C", "998877665", 35);

            // Guardar los objetos en el archivo binario
            oos.writeObject(p1);
            oos.writeObject(p2);
            oos.writeObject(p3);

            System.out.println("Archivo 'FichPersona.dat' creado y personas guardadas con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
