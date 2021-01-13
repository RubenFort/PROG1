
package codigo;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {
    
    private static final int PUERTO_ESCUCHA = 6666; 

    public static void main(String[] args) throws IOException {
        
        ServerSocket escuchador;
        InputStream entrada;
        PrintStream salida;
        Socket conexion;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss 'del' dd/MM/yyyy");

        //Creamos un "escuchador" de peticiones de conexion en el puerto 6666
        escuchador = new ServerSocket(PUERTO_ESCUCHA);
            
        do {
            //Esperamos una petición de conexión entrante  
            //Un Socket es un conjunto MiIp:MiPuerto + SuIp:SuPuerto
            conexion = escuchador.accept();

            //Obtenemos los "puntos" de E(InputStream)/S(OutputStream)
            //En este ejemplo no necesitamos un InputStream, ya que no recibimos
            //nada del cliente
            entrada = conexion.getInputStream();
            salida = new PrintStream(conexion.getOutputStream());

            //Enviamos el mensaje al cliente
            salida.print("Bienvenida al Alberto`s Server\r\n");
            salida.print("Ahora son las: " + sdf.format(new Date()) + "\r\n");
            salida.print("Quedas fichad@!!! Bye, bye");

            //En general para formar el vaciado del buffer de datos hacemos flush()
            salida.flush();

            //Cerramos los elementos abiertos
            salida.close();
            entrada.close();
            conexion.close();
        } while (true);
        
            //escuchador.close();
        
        
    }
    
}
