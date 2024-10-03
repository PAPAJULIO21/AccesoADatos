package ejercicio6;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String rutaString = "/Users/padrejulian/Documents/accesoADatos/ficheros/src/ejercicio6/datos806.dat";
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

            suma += Character.getNumericValue(arrayList.get(p));

            if (arrayList.get(p) > nMayor) {
                nMayor = arrayList.get(p);
            }

            if (arrayList.get(p) < nMenor) {
                nMenor = arrayList.get(p);
            }

        }

        double media = suma/numero;


        System.out.println("La media es: "+ media);
        System.out.println("El numero mas grande es: "+ nMayor);
        System.out.println("El numero mas pequeño es: "+nMenor);
       
        fileReader.close();
    }


    
}
