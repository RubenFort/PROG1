
package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        Socket conexion;
        String mensaje;
        int valor;
        Scanner lector;
        
        try {
            //Creamos unas conexion con el servidor DayTime
            conexion = new Socket("localhost", 13);
            
            //Obtenemos el "punto" de entrada
            lector = new Scanner(conexion.getInputStream());
            
            //Leo una linea desde la entreda y muestro
            mensaje = lector.nextLine();
            System.out.println(mensaje);
            
            //Cerramos el "punto" de entrada
            lector.close();
            
            //Cerramos la conexion
            conexion.close();
 
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
