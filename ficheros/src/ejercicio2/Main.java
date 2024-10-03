package ejercicio2;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Dame una ruta para leerte el txt: ");
        String ruta = sc.next();

        // Llamar al método para leer el contenido del archivo
        try {
            leerFichero(ruta);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

    }


    // Método para leer el archivo y escribir su contenido en la consola
    public static void leerFichero(String nombreArchivo) throws IOException {
        // Crear un BufferedReader para leer el archivo
        FileReader br = new FileReader(nombreArchivo);
        int linea;

        // Leer cada línea del archivo y escribirla en la consola
        while ((linea = br.read()) != -1) {

            if ((char) linea == ' ') {
                System.out.print("-");
                continue;
            }

            System.out.print(Character.toUpperCase((char)linea));
        }

        // Cerrar el BufferedReader
        br.close();
    }

    
    
}
