package ejercicio3;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ruta = "/Users/padrejulian/Documents/accesoADatos/ficheros/src/ejercicio2/pepe.txt";
        
        System.out.print("Dame la ruta del archivo que quieres clonar: ");
        String rutaDuplicar = sc.next();

        try {
            duplicar(ruta,rutaDuplicar);
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }

        sc.close();

    }

    private static void duplicar(String rutaPrincipal, String rutaFinal)throws IOException{
        FileReader fileReader = new FileReader(rutaPrincipal);
        FileWriter fileWriter = new FileWriter(rutaFinal);
        ArrayList <Character> pepe = new ArrayList<>();

        int linea;
       
            
        while ((linea = fileReader.read()) != -1) {
            pepe.add((char)linea);
            
        }

        fileReader.close();

        for(int i = 0; i <pepe.size();i++){
            fileWriter.write((pepe.get(i)));
        }
        
        fileWriter.close();
    }


}
