package codigo;

import java.util.Date;
import java.util.Vector;

public class Principal {

    public static void main(String[] args) {
        
        Trabajador t0 = new Trabajador("32111222K", "Edelmiro Miramontes", new Date(70, 4, 22), 2400);
        Trabajador t1 = new Trabajador("32222222F", "Juana Torrente", new Date(80, 0, 6), 2500);
        Trabajador t2 = new Trabajador("32222222F", "Ana Rey ", new Date(85, 2, 7), 2000);
        
        System.out.println("t0: " +t0.toString()); //toString = getClass().getName() + '@' + Integer.toHexString(hashCode())
        System.out.println("t1: " +t1.toString()); //hashCode() = Devuelve un identificador único (referencia de mémoria)
        System.out.println("t2: " +t2.toString());
        System.out.println("------------------------------------------");
        //t1 y t2 aunque  tienen las mismos valores, son diferentes
        
        System.out.println("¿Son iguales t0 y t1?: " + t0.equals(t1));
        System.out.println("¿Son iguales t1 y t2?: " + t1.equals(t2));
        
        
        System.out.println("==================================================================================================");
        
        Trabajador t4 = new Trabajador("32333333J", "Vicente Ruy", new Date(70,5,22), 1500);
        //Creamos un Vector de Trabajadores
        Vector<Trabajador> trabajadores = new Vector();
        
        trabajadores.add(t0);
        trabajadores.add(t1);
        trabajadores.add(t2);
        
        //Miramos si t0 está en el vector y en que posicion está
        System.out.println("Está t0 en le Vector?: " + trabajadores.contains(t0));
        System.out.println("t0 está en la posición (-1 quiere decir que no está):" + trabajadores.indexOf(t0));
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        //Miramos si t4 está en el vector y en que posicion está
        System.out.println("Está t4 en le Vector?: " + trabajadores.contains(t4));
        System.out.println("t4 está en la posición (-1 quiere decir que no está):" + trabajadores.indexOf(t4));
        
        System.out.println("-----------------------------------------------------------------------------------");
        
        //Borramos el objeto t0 y despues volvemos a preguntar si lo contiene
        System.out.println("Intentamos borrar t0: " + trabajadores.remove(t0));
        //Miramos si t0 está en el vector y en que posicion está
        System.out.println("Está t0 en le Vector?: " + trabajadores.contains(t0));
        System.out.println("t0 está en la posición (-1 quiere decir que no está):" + trabajadores.indexOf(t0));
        
        //Queremos saber si hay un trabajador con NIF:32444444R
        Trabajador buscado = new Trabajador("32444444R");
        //Miramos si buscado está en el vector y en que posicion está
        System.out.println("Está NIF:32444444R en le Vector?: " + trabajadores.contains(buscado));
        System.out.println("NIF:32444444R está en la posición (-1 quiere decir que no está):" + trabajadores.indexOf(buscado));
        
        //Queremos saber si hay un trabajador con NIF:32444444R
        Trabajador buscado1 = new Trabajador("32222222F");
        //Miramos si buscado está en el vector y en que posicion está
        System.out.println("Está NIF:32222222F en le Vector?: " + trabajadores.contains(buscado1));
        System.out.println("NIF:32222222F está en la posición (-1 quiere decir que no está):" + trabajadores.indexOf(buscado1));
        if(trabajadores.contains(buscado1)){
            int indexOf = trabajadores.indexOf(buscado1);
            Trabajador recuperado = trabajadores.get(indexOf);
            System.out.println(recuperado.getNombre());
            System.out.println(recuperado.getFechaNacimiento());
            System.out.println(recuperado.getSalario());
                    
        }
    }
    
}
