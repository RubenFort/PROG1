package codigo;

import java.util.Vector;

public class Principal {

    public static void main(String[] args) {

        //Creamos un ArrayList de String con capacidad inicial de 10
        //Y como aun no hemos agregado elementos su tamaño es 0
        System.out.println("Creamos vector vacío con capacidad 10");
        Vector<String> listaNombres = new Vector(4);
        System.out.println("Capacidad: " + listaNombres.capacity());
        System.out.println("Capacidad: " + listaNombres.size());
        System.out.println("");
        muestraLista(listaNombres);
        System.out.println("-------------------------------------------------");
        System.out.println("");

        //Añadimos unos cuantos nombrea a la lista y mostramos capacidad 
        //y tamaño
        System.out.println("Añadimos 3 nombrea a la lista");
        listaNombres.add("Alejandro");
        listaNombres.add("David");
        listaNombres.add("Diego Chenlo");
        System.out.println("Capacidad: " + listaNombres.capacity());
        System.out.println("Capacidad: " + listaNombres.size());
        System.out.println("");
        muestraLista(listaNombres);
        System.out.println("-------------------------------------------------");
        System.out.println("");

        //Añadimos 2 nombrea a la lista y mostramos capacidad 
        //y tamaño
        System.out.println("Añadimos 2 nombrea a la lista");
        listaNombres.add("Diego Conde");
        listaNombres.add("Marcos");
        System.out.println("Capacidad: " + listaNombres.capacity());
        System.out.println("Capacidad: " + listaNombres.size());
        System.out.println("");
        muestraLista(listaNombres);
        System.out.println("-------------------------------------------------");
        System.out.println("");

        for (int i = 0; i < 10; i++) {

        }
    }

    private static void muestraLista(Vector<String> v) {

        if (v.isEmpty()) {
            System.out.println("La lista está vacía");
        } else {
            for (int i = 0; i < v.size(); i++) {
                System.out.println("En el índice " + i + " está " + v.get(i));
            }
        }
        
    }
}
