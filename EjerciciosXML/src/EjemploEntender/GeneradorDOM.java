package EjemploEntender;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;;

public class GeneradorDOM {

    private Document documentoXML;

    public GeneradorDOM() throws ParserConfigurationException{
        DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder =  factoria.newDocumentBuilder();
        documentoXML = builder.newDocument();
    }
    
    public void generarDocumento(){
        //Creamos primer alumno
        Element alumnos = documentoXML.createElement("alumnos");
        documentoXML.appendChild(alumnos);//Elemento raiz

        //Crear alumno
        Element alumno = documentoXML.createElement("alumno");//Etiqueta alumno 
        alumnos.appendChild(alumno);
        alumno.setAttribute("id", "A01");//Le damos valor


        Element nombre = documentoXML.createElement("nombre");//Etiqueta nombre dentro de alumno
        alumno.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Pepe"));

        Element appellido = documentoXML.createElement("appellido");//Etiqueta apellido dentro de alumno
        alumno.appendChild(appellido);
        appellido.appendChild(documentoXML.createTextNode("Garcia"));

        


        //Crear segundo alumno
        alumno = documentoXML.createElement("alumno");
        alumnos.appendChild(alumno);
        alumno.setAttribute("id", "A02");


        nombre = documentoXML.createElement("nombre");
        alumno.appendChild(nombre);
        nombre.appendChild(documentoXML.createTextNode("Mario"));

        appellido = documentoXML.createElement("appellido");
        alumno.appendChild(appellido);
        appellido.appendChild(documentoXML.createTextNode("Nena "));
    }

    public void generarXML() throws IOException, TransformerException{
        //Crar origen xml
        Source origen = new DOMSource(documentoXML);
        //Creamos salida
        File ruta = new File("./alumnos.xml");
        FileWriter fw = new FileWriter(ruta);
        PrintWriter pw = new PrintWriter(fw);
        StreamResult result = new StreamResult(pw);


        TransformerFactory factoria = TransformerFactory.newInstance();
        Transformer transformer = factoria.newTransformer();
        transformer.transform(origen, result);//Origen y Destino
    }

}
