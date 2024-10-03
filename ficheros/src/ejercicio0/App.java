package ejercicio0;
import java.io.*;
import java.io.File;


public class App {
    public static void main(String[] args) throws IOException {
        //verDir();
        unoACien();
        leer();
    }

    private static void verDir(){
        String dir = "/Users/padrejulian/Documents/accesoADatos/ficheros/home/Documents";
        File f = new File(dir);
        String [] archivos = f.list();
        File f2;
        int tam = archivos.length;

        System.out.println("Tamaño del array: "+ tam);

        for(int i =0; i < tam;i++){
            f2 = new File(f, archivos[i]);
            if (f2.isDirectory()) {
                System.out.println("El " + archivos[i]+ " es un directorio.");
            }
            if (f2.isFile()) {
                System.out.println("El " + archivos[i]+ " es un archivo.");
            }
        }
        
        
    }

    private static void leer()throws IOException{
        File fichero = new File("ficheroUnoACien.txt");
        FileInputStream fos = new FileInputStream(fichero);

        int i;
        
        while ((i = fos.read()) != -1) {
            System.out.println(fos.read());
        }
        fos.close();
    }

    private static void unoACien() throws IOException{
        File fichero = new File("ficheroUnoACien.txt");
        FileOutputStream fos = new FileOutputStream(fichero);

        for(int i = 1;1<=100;i++){
            fos.write(i); 
        }

    }
}
