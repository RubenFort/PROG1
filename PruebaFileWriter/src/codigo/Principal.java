
package codigo;

import java.io.FileWriter;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws IOException {
        
        // Creamos un fileWriter para escribir texto en un fichero
        FileWriter escritor = new FileWriter("prueba.txt");

        //Escribimos unas lineas en el fichero
        escritor.write("Hola Mundo Writer\n");
        escritor.write("Bye, bye");
        
        //Cerramos fichero
        escritor.close();
        
    }
    
}
