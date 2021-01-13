package codigo;

import java.util.Enumeration;
import java.util.Hashtable;

public class Principal {
    
    private static Hashtable<Integer,String> tabla;
    
    public static void main(String[] args) {
        
        //Tabla con capacidad inicial 11 (por defecto del constructor)
        //Su clave(key) no se puede repetir
        tabla = new Hashtable<>();
        
        //Añadimos 3 pares clave-valor en la tabla
        System.out.println("Añadimos 3 pares clave-valor a la tabla");
        tabla.put(4, "Eva");
        tabla.put(6, "Luis");
        tabla.put(2, "Ana");
        System.out.println(tabla);
        muestraTabla();
        System.out.println("-----------------------------------------------------");
        
        //Añadimos el par 2-Juan y como ya existe la clave 2, solo se sustituye el valor
        System.out.println("Añadimos el par 2-Juan y como ya existe la clave 2, solo se sustituye el valor");
        tabla.put(2, "Juan");
        muestraTabla();
        System.out.println("-----------------------------------------------------");
        
        //Borramos la entrada de la tabla de clave 6
        System.out.println("Borramos la entrada de la tabla de clave 6");
        tabla.remove(6);
        muestraTabla();
        System.out.println("-----------------------------------------------------");
    }
    
    private static void muestraTabla(){
        Integer clave;
        String valor;
        //Interfaz Enumeration
        Enumeration<Integer> claves;
        
        System.out.println("El nº de filas de la tabla es: " + tabla.size());
        
        //Recuperamos una "lista" con las claves de la tabla (1ª columna)
        claves = tabla.keys();
        while(claves.hasMoreElements()){
             clave = claves.nextElement();
             valor = tabla.get(clave);
             System.out.println("Clave: " + clave + " Valor: " + valor);
        }
    }
}
