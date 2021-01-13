package codigo;

import java.util.TreeSet;

public class Principal {

    public static void main(String[] args) {
        
        Vivienda v0 = new Vivienda(2005, 150.5, "32111231M");
        Vivienda v1 = new Vivienda(1990, 66.6, "22567831R");
        Vivienda v2 = new Vivienda(2005, 250.0, "32998551M");
        
        System.out.println("Comparación con compareTo v0 con v1: " + v0.compareTo(v1));
        System.out.println("Comparación con compareTo v1 con v2: " + v1.compareTo(v2));
        System.out.println("Comparación con compareTo v0 con v2: " + v0.compareTo(v2));
        /*        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        System.out.println("Comparación con equals v0 con v1: " + v0.equals(v1));
        System.out.println("Comparación con equals v1 con v2: " + v1.equals(v2));
        System.out.println("Comparación con equals v0 con v2: " + v0.equals(v2));*/
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        
        //Construimos un TreeSet para guardar viviendas
        TreeSet<Vivienda> viviendas = new TreeSet<>();
        
        viviendas.add(v1);
        viviendas.add(v0);
        viviendas.add(v2);
        
        for (Vivienda v : viviendas) {
            System.out.println(v);
        }
        
        System.out.println("");
        System.out.println("--------------------------------------------------------");
        System.out.println("");
        
        Vivienda v3 = new Vivienda(1900, 2000.0, "32777751M");
        
        viviendas.add(v3);
        
        for (Vivienda v : viviendas) {
            System.out.println(v);
        }
    }
}
