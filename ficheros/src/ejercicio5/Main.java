package ejercicio5;

import java.io.*;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String rutaString = "/Users/padrejulian/Documents/accesoADatos/ficheros/src/ejercicio5/numeros.txt";
         try {
           calculadora(rutaString);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }
    

    private static void calculadora(String ruta) throws IOException{

        FileReader fileReader = new FileReader(ruta);
        ArrayList <Character> arrayList = new ArrayList<>();
        

        int i;

        while ((i = fileReader.read())!= -1) {
            arrayList.add((char) i);
        }

        int numero = 1;
        int suma = 0;


        for(int b = 0; b < arrayList.size(); b++){

            if (arrayList.get(b) == '\n') {
                numero++;
            }

            suma += Character.getNumericValue(arrayList.get(b));

        }

        double media = suma/numero;

        System.out.println("Hay "+ numero + " numeros.");
        System.out.println("La media es "+ media);

        fileReader.close();

    }
    
}
