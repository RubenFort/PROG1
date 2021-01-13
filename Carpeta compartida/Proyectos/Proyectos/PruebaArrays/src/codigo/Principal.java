package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        //Array de enteros
        int[] lista = new int[20];
        int suma;

        //Insertar elementos en el array
        lista[0] = 22;
        lista[1] = 10;
        lista[2] = -3;

        suma = lista[0] + lista[1] + lista[2];

        System.out.println("La suma de los 3 primeros elelmtos del array es " + suma);

        //Llenamos el array con un bucle for poniendo como valor su índice
        for (int i = 0; i < 20; i++) {
            lista[i] = i;
        }
        //Lo mostramos
        for (int i = 0; i < lista.length; i++) {
            System.out.println("En lista[" + i + "] hay " + lista[i]);
        }
        
        //Declaramos y creamos un array para guardar cadenas
        String[] nombres = new String[5];
        //Creamos un Scanner para leer del teclado
        Scanner teclado = new Scanner(System.in);
        
        for (int i = 0; i < nombres.length; i++) {
            System.out.print("Dame un nombre?:");
            String cadenaLeida = teclado.nextLine();
            nombres[i] = cadenaLeida;
        }
        
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("En la posición " + i + " está " + nombres[i]);
        }
        
        System.out.println("Los elementos del array son: ");
        for(String nombre : nombres){
            System.out.println(nombre);
        }
        
        System.out.println(nombres);
        
    }

}
