package ejercicio6;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String rutaString = "/Users/padrejulian/Documents/AccesoADatos/ficheros/src/ejercicio6/pepe.txt";
         try {
            datosNumRe(rutaString);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }


    private static void datosNumRe(String ruta) throws IOException{

        FileReader fileReader = new FileReader(ruta);
        ArrayList <Character> arrayList = new ArrayList<>();

        int i;

        while ((i = fileReader.read()) !=-1) {
            arrayList.add((char)i);
        }

        int numero = 1;
        double suma = 0;
        double nMenor = arrayList.get(1);
        double nMayor = arrayList.get(1);
        
        for(int p = 0; p < arrayList.size(); p++){
            if (arrayList.get(p) == '\n') {
                numero++;
            }
        }
        suma = sumarContenidoArchivo(ruta);
       

        double media = suma/numero;


        System.out.println("La media es: "+ media);
        System.out.println("Este es el numero mayor: " + nMayor);
        System.out.println("Este es el numero menor: " + nMenor);
        
       
        fileReader.close();
    }


    private static int sumarContenidoArchivo(String nombreArchivo) {
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
