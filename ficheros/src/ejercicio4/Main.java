package ejercicio4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        String rutaString = "/Users/padrejulian/Documents/accesoADatos/ficheros/src/ejercicio4/prueba.txt";
         try {
           leer(rutaString);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }
    

    private static void leer(String ruta) throws IOException{

        FileReader fileReader = new FileReader(ruta);
         ArrayList <Character> pepe = new ArrayList<>();

        int linea;

        while ((linea = fileReader.read())!= -1) {
            pepe.add((char)linea);
        }
        int caracteres = 0;
        int palabras = 1;
        int espacios = 1;
        for(int i = 0; i < pepe.size(); i++){
            if (pepe.get(i) != ' ' && pepe.get(i) != '\n') {
                caracteres++;
            }
            if (pepe.get(i) == ' ' || pepe.get(i) == '\n' ) {
                palabras++;
            }
            if (pepe.get(i) == '\n') {
                espacios++;
            }
        }

        fileReader.close();

        System.out.println("El tamaño de caracteres que hay es "+ caracteres);
        System.out.println("El numero de palabras que hay es "+ palabras);
        System.out.println("El numero espacios que hay es "+ espacios);
    }
}
