package ejercicio1;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> alumnos = new ArrayList<>();
public static void main(String[] args) {
        try {
            int numeroAlumnos = nAlumnosFichero();
            System.out.println("Número total de alumnos: " + numeroAlumnos);
            System.out.println("Media de edades: "+ mediaEdades());
            System.out.println("El alumno mas joven tiene esta edad: " + alumnoMasJoven(encontrarEdadesEnBinario()));
            System.out.println("El alumno mas viejo tiene esta edad: "+ alumnoMasViejo(encontrarEdadesEnBinario()));
            System.out.println("Hay "+ alumnosMenoresDeEdad(encontrarEdadesEnBinario())+" menores de edad.");
            System.out.println("La desviancion estadar es: " + desviacionEstandar(encontrarEdadesEnBinario()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int nAlumnosFichero() throws IOException {
        File file = new File("ficheros/src/ejercicios/entrada801.dat");
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        int contadorAlumnos = 0;

        try {
            // Leer datos hasta que se alcance el final del archivo
            while (true) {
                dataInputStream.readInt();  // Leer cada entero que representa un alumno
                contadorAlumnos++;        // Incrementar el contador por cada lectura exitosa
            }
        } catch (EOFException e) {
            // EOFException se lanza cuando alcanzamos el final del archivo, lo cual es normal
        } finally {
            // Cerrar el stream de datos para evitar fugas de recursos
            dataInputStream.close();
        }

        return contadorAlumnos;
    }

    public static double mediaEdades() throws IOException{

        return sumarElementos(encontrarEdadesEnBinario())/nAlumnosFichero();

    }
    public static int alumnoMasJoven(ArrayList<Integer> lista) throws IOException{

        int masJoven = lista.get(0);

        // Recorremos la lista y buscamos el menor valor
        for (int edad : lista) {
            if (edad < masJoven) {
                masJoven = edad;
            }
        }

        return masJoven;
    }

    public static int alumnoMasViejo(ArrayList<Integer> lista) throws IOException{

        int masViejo = lista.get(0);

        // Recorremos la lista y buscamos el menor valor
        for (int edad : lista) {
            if (edad > masViejo) {
                masViejo = edad;
            }
        }

        return masViejo;
    }
    public static int alumnosMenoresDeEdad(ArrayList<Integer> lista) throws IOException{

        int menorEdad = 0;

        // Recorremos la lista y buscamos el menor valor
        for (int edad : lista) {
            if (edad < 18) {
                menorEdad++;
            }
        }

        return menorEdad;
    }

    public static double desviacionEstandar(ArrayList<Integer> lista)throws IOException{
        int n = lista.size();
        // 2. Calcular la suma de los cuadrados de las diferencias con respecto a la media
        double sumaCuadrados = 0;
        for (int num : lista) {
            sumaCuadrados += Math.pow(num - mediaEdades(), 2);
        }

        // 3. Calcular la varianza (media de las diferencias al cuadrado)
        double varianza = sumaCuadrados / n;

        // 4. Calcular la desviación estándar (raíz cuadrada de la varianza)
        return Math.sqrt(varianza);
    }

    private static ArrayList<Integer> encontrarEdadesEnBinario() throws IOException {
        File file = new File("ficheros/src/ejercicios/entrada801.dat");
        FileInputStream fileInputStream = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fileInputStream);
        ArrayList<Integer> edades = new ArrayList<>();

        try {
            // Leer las edades (almacenadas como enteros) hasta llegar al final del archivo
            while (dataInputStream.available() > 0) {
                int edad = dataInputStream.readInt();  // Leer cada entero
                edades.add(edad);  // Agregar la edad a la lista
            }
        } finally {
            dataInputStream.close();  // Cerrar el stream
        }

        return edades;
    }

    private static int sumarElementos(ArrayList<Integer> lista) {
        int suma = 0;

        // Recorrer todos los elementos de la lista y sumarlos
        for (int numero : lista) {
            suma += numero;
        }

        return suma;
    }
    
    
}
