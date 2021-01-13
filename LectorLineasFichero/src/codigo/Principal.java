
package codigo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;


public class Principal {


    public static void main(String[] args) throws FileNotFoundException {
        
        //Construimos un Scanner para leer desde un fichero de caracteres
        //Esta forma de hacerlo no es muy correcta ya q tenemos 2 formas de acceder al fichero
        //Una directa (usando fr.read()) y otra indirecta (usando lectorFichero.next??)
        //FileReader fr = new FileReader("pruebalectura.txt");
        //Scanner lectorFichero = new Scanner(fr);
        
        //Para evitar esta tentación lo q se hace es crear el foleReader como
        //un "objeto anonimo" (un objeto sin nombre)
        Scanner lectorFichero = new Scanner(new FileReader("pruebalectura.txt"));
        String linea;
        while (lectorFichero.hasNextLine()) {
            linea = lectorFichero.nextLine();
            System.out.println(linea);
        }
    }
    
}
