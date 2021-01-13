package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        int entero = 0;
        boolean valido;
        
        //Parseamos un String que debería "contiene" un entero
        do {            
            System.out.print("Escribe un entero: ");
            linea = teclado.nextLine();
            try {
                entero = Integer.parseInt(linea);
                valido =  true;          
            } catch (NumberFormatException numberFormatException) {
                valido = false;
            }
        } while (!valido);
        
                System.out.println("El entero parseado es: " + entero);   
    }
}
