package codigo;

import java.util.Random;

public class Principal {

    public static void main(String[] args) {
        
        //Generamos un aleatotio en el rango [0.0 .. 1.0)
        double aleatorio = Math.random();
        System.out.println("El aleatorio generado es: " + aleatorio);
        
        //Al multiplicar 10 x [0.0 .. 1.0) obtenemos [0.0 .. 10.0)
        //y al hacer "casteo" (promoción) a int, perdemos los decimales
        int aleatorioEntero = (int) (aleatorio * 10);
        System.out.println("El entero generado es: " + aleatorioEntero);
        
        //Generamos un entero aleatorio rango [1 .. 6]
        int dadoParchis = (int)(aleatorio * 6) + 1;
        System.out.println("La tirada de dado es: " + dadoParchis);
        
        System.out.println("---------------------------------------------");
        
        //Ahora vamos a hacer unas pruebas con la clase Random
        System.out.println("Aleatorio generados con Random");
        Random generador = new Random(1256);
        
        //Generamos 10 boleanos aleatorios
        System.out.println("Generamos 10 boleanos aleatorios");
        boolean b;
        for (int i = 0; i < 10; i++) {
            b = generador.nextBoolean();
            System.out.print(b + " "); 
        }
        System.out.println();
        
        //Generamos 10 enteros aleatorios en el rango de int
        System.out.println("Generamos 10 enteros aleatorios en el rango de int");
        int entero;
        for (int i = 0; i < 10; i++) {
             entero = generador.nextInt();
            System.out.print(entero + " "); 
        }
        System.out.println();
        
        //Generamos 10 enteros aleatorios en el rango 0 .. 3
        System.out.println("Generamos 10 enteros aleatorios en el rango 0 .. 3");
        int otroEntero;
        for (int i = 0; i < 10; i++) {
             otroEntero = generador.nextInt(4);
            System.out.print(otroEntero + " "); 
        }
        System.out.println();
        
        //Llenamos un array de 10 bytes con valores aleatorios [-128 .. 127]
        System.out.println("Llenamos un array de 10 bytes con valores aleatorios [-128 .. 127]");
        byte[] bytes = new byte[10];
        generador.nextBytes(bytes);
        for (byte b1 : bytes) {
            System.out.print(b1 + " ");
        }
        
        
    } 
}
