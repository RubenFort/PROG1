package codigo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Principal {

    public static void main(String[] args) {
        
        Properties propiedades = new Properties();
        
        //Añadimos unos cuantos pares nombres = valor
        propiedades.setProperty("color-fondo", "rojo");
        propiedades.setProperty("color-fuente", "verde");
        propiedades.setProperty("tamaño", "14");
        propiedades.setProperty("fuente", "arial");
        propiedades.setProperty("cursiva", "off");
        
        //En depuracion hacemos una salida por pantalla
        propiedades.list(System.out);
        
        try {
            propiedades.storeToXML(new FileOutputStream("propiedades.xml"), "Ejemplo de prueba de properties");
        } catch (IOException ex) {
            System.out.println("No se pudo crear el fichero de configuración");
        }
        
        System.out.println("-------------------------------------------------");
        
        //creamos un objeto Properties para recuperar las propiedades 
        Properties leidas = new Properties();
        
        try {
            //Leemos de un fichero en texto plano las propiedades
            leidas.loadFromXML(new FileInputStream("propiedades.xml"));
            
            //En depuracion hacemos una salida a pantalla
            leidas.list(System.out);
            System.out.println("---------------------------------------------");

            String nombre;
            String valor;
            
            //Otra forma de hacer lo anterior es obteniendo un conjunto(Set) con
            //los nombres de las propiedades y a partir de un iterador
            Set<String> names = leidas.stringPropertyNames();
            for (String name : names) {
                valor = leidas.getProperty(name);
                //Mostramos el par nombre:valor
                System.out.println(name + ": " + valor);
            }
            
        } catch (IOException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
