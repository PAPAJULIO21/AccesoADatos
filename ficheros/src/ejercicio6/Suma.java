package ejercicio6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Suma {
    public static void main(String[] args) {
        String nombreArchivo = "/Users/padrejulian/Documents/AccesoADatos/ficheros/src/ejercicio6/pepe.txt";
        int suma = sumarContenidoArchivo(nombreArchivo);
        if (suma != 0) {
            System.out.println("La suma del contenido del archivo es: " + suma);
        }
    }

    public static int sumarContenidoArchivo(String nombreArchivo) {
        int suma = 0;
        try (BufferedReader archivo = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = archivo.readLine()) != null) {
                String[] numeros = linea.split(" ");
                for (String num : numeros) {
                    suma += Integer.parseInt(num);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
            return 0;
        }
        return suma;
    }
}

