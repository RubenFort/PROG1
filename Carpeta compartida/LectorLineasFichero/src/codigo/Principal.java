package codigo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException {
       
        //Construímos un Scanner para leer desde un fichero de caracteres
        //Esta forma de hacerlo no es muy correcta (peligrosa) ya que tenemos 
        //dos formas de acceder al fichero, una directa (usando fr.read() )
        //y otra indirecta (usando lectorFichero.next??()        
        //FileReader fr = new FileReader("pruebalectura.txt");
        //Scanner lectorFichero = new Scanner(fr);
        
        //Para evitar esa tentación lo que se hace es crear el fileReader como 
        //un "objeto anónimo" (un objeto sin nombre)
        Scanner lectorFichero = new Scanner(new FileReader("pruebalectura.txt"));
        String linea;
        while(lectorFichero.hasNextLine()){
            linea = lectorFichero.nextLine();          
            System.out.println(linea);
        }
    }
    
}
