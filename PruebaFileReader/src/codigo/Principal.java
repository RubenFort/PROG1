
package codigo;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        FileReader lector = new FileReader("pruebalectura.txt");
        int i;
        char c;
        
        while( (i=lector.read()) != -1 ){
            c = (char)i;
            System.out.print(c);
        }
        
        lector.close();
        
    }
    
}
