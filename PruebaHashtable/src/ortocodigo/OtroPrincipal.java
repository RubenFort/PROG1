package ortocodigo;

import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;

public class OtroPrincipal {
    
    private static Hashtable<Persona, Direccion> tabla;
    
    public static void main(String[] args) {
        
        //Tabla con capacidad inicial 11 (por defecto del constructor)
        tabla = new Hashtable<>();
        
        //Añadimos 3 pares clave-valor en la tabla
        System.out.println("Añadimos 3 pares clave-valor a la tabla");
        tabla.put(new Persona("32111111A", "Eva Rey", new Date(60, 5, 23)), new Direccion("15002", "Luna", 1, 1, 'D'));
        tabla.put(new Persona("32222222W", "Luis Pita", new Date(75, 10, 4)), new Direccion("15001", "Amargura", 2, 2, 'I'));
        tabla.put(new Persona("33333333G", "Ana López", new Date(90, 45, 12)), new Direccion("15003", "Juan Florez", 22, 4, 'C'));
        System.out.println(tabla);
        muestraTabla();
        System.out.println("-----------------------------------------------------");
        
        //Añadimos el par Luis Pita con una nueva dirección(sustituirá el anterior par)
        System.out.println("Añadimos el par Luis Pita con una nueva dirección");
        tabla.put(new Persona("32222222W", "Luis Pita", new Date(75, 10, 4)), new Direccion("15001", "Trompeta", 2, 2, 'I'));
        //Añadimos el par Luis Pita con un nuevo dni(añadirá un nuevo par, pq
        //hemos reescrito el equals y 2 Personas son iguales cuando coinciden en el nif)
        tabla.put(new Persona("32222222X", "Luis Pita", new Date(75, 10, 4)), new Direccion("15001", "Trompeta", 2, 2, 'I'));
        muestraTabla();
        System.out.println("-----------------------------------------------------");
        
        //Borramos la entrada de la tabla de clave Eva Rey (por su nif)
        System.out.println("Borramos la entrada de la tabla de clave Eva Rey (por su nif)");
        tabla.remove(new Persona("32111111A", "Eva Rey", new Date(60, 5, 23)));
        muestraTabla();
        System.out.println("-----------------------------------------------------");
        
    }
        private static void muestraTabla(){
        Persona clave;
        Direccion valor;
        //Interfaz Enumeration
        Enumeration<Persona> claves;
        
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