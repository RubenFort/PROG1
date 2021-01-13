
package codigo;

import java.util.Date;

public class Principal {

    public static void main(String[] args) {
        
        //Construimos y mostramos date con fecha y hora de ahora
        System.out.println("Construimos y mostramos date con fecha y hora de ahora");
        Date ahora = new Date();
        System.out.println("Ahora es: "+ahora); //muestra el formato que muestra el toString de la API
        System.out.println("Año: "+ ahora.getYear());
        System.out.println("Mes: "+ ahora.getMonth());
        System.out.println("Dia mes: "+ ahora.getDate());
        System.out.println("Dia semana: "+ ahora.getDay());
        System.out.println("Hora: "+ ahora.getHours());
        System.out.println("Minuto: "+ ahora.getMinutes());
        System.out.println("Segundo: "+ ahora.getSeconds());
        System.out.println("Desde el 1/1/1970 han transcurrido " +ahora.getTime()+ " ms");
        
        System.out.println("---------------------------------------------------------------");
        //Construimos un Date con la fecha de nacimiento
        System.out.println("Construimos un Date con la fecha de nacimiento");
        Date elDiaQueNaci = new Date(80, 3, 10); //(10/4/1980)
        System.out.println("El dia que nací: " + elDiaQueNaci);
        
        long diasVividos = ((ahora.getTime() - elDiaQueNaci.getTime())/(1000*60*60*24));
        System.out.println("En este mundo llevo: " + diasVividos + " días");
        
    }
    
}
