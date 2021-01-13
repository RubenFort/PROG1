package codigo;

public class Principal {

    public static final int MAX_CONTACTOS = 10;
    public static int ocupacion = 0;
    public static int siguienteID = 0;
    
    private static Contacto[] contactos;   
    
    public static void main(String[] args) {
        
        contactos = new Contacto[MAX_CONTACTOS];
        
       //Como dos variables distintas apunta al mismo sitio
        Contacto c1, c2;
        c1= new Contacto(20, "Luisa", "23/05/1989", 981123123, 'A', true);
        c2=c1;
        
        System.out.println("c1 "+c1);
        System.out.println("c2 "+c2);
        System.out.println("");
        
        contactos[ocupacion] = new Contacto(siguienteID, "Ruben", "10/05/1999", 677454645, 'A', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Luis", "22/08/2005", 677223223, 'E', true);
        ocupacion++;
        siguienteID++;

        contactos[ocupacion] = new Contacto(siguienteID, "Ana", "04/1/1982", 981789456, 'T', false);
        ocupacion++;
        siguienteID++;
        
        /*Este formato de "for" se denomina "for each".
        Solo se puede usar en modo lectura, y hay que recorrer el array completamente
        Los 3 primeros elementos del array son son objetos de la clase Contacto que están en el paquete Codigo
        @4554617c es el indicador único del objeto (similar a un puntero).
        Se trata de un Codigo hexadecimal de 32 bits, pq usamos un Java de 32 bits.*/
        for (Contacto c : contactos) {
            System.out.println(c);
        }
    }
}
