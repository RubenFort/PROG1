package codigo;

import java.util.Vector;
import modelo.Parlanchin;
import modelo.Perro;
import modelo.Persona;
import modelo.Robot;

public class Principal {

    public static void main(String[] args) {
        
        Persona manolo = new Persona("Manolo", "Español", "Músico");
        Perro toby = new Perro("Toby", "Caniche", 123456789);
        Robot HAl900 = new Robot("HAL900", "HALL", 900);
        
        Parlanchin p0, p1, p2;
        
        //Las variables de tipo Parlanchín puede "apuntar" y referencias a cualquier
        //objeto de cualquier clase que implemente Parlanchín
        p0 = manolo;
        p1 = toby;
        p2 = HAl900;
        
        //Un Vector de objetos de clase que implementan Parlanchín
        Vector <Parlanchin> parlanchines = new Vector();
        parlanchines.add(manolo);
        parlanchines.add(toby);
        parlanchines.add(HAl900);
        
         //Recorremos el Vector y hacemos que den la bienvenida
         for (Parlanchin p : parlanchines) {
             System.out.println(p.daBienvenida());
        }
         
         System.out.println("------------------------------------------------");
         
         for (Parlanchin p : parlanchines) {
             System.out.println(p.despidete());
        }
    }
    
}