
package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        Socket conexion;
        InputStream entrada;
        int valor;
        
        try {
            //Creamos unas conexion con el servidor DayTime
            conexion = new Socket("localhost", 13);
            
            System.out.println("Este cliente esta usando el puerto local: " + conexion.getLocalPort());
            
            //Obtenemos el "punto" de entrada
            entrada = conexion.getInputStream();
            
            //Leemos byte hasta que el servidor cierre el flujo
            while ((valor=entrada.read()) != -1) {
                System.out.print((char)valor);
            }
            
            //Cerramos el "punto" de entrada
            entrada.close();
            
            //Cerramos la conexion
            conexion.close();
 
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
