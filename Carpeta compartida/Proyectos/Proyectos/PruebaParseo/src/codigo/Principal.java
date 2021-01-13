
package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
      
        Scanner teclado = new Scanner(System.in);
        
        //Pedimos y leemos una cadena que convertiremos (parsearemos) a int
        System.out.print("Escribe un entero: ");
        String strEntero = teclado.nextLine();
        int entero = Integer.parseInt(strEntero);
        System.out.println("El entero leído es " + entero);
        
        //Pedimos y leemos una cadena que convertiremos (parsearemos) a double
        System.out.print("Escribe un número con decimales: ");
        String strDouble = teclado.nextLine();
        double decimal = Double.parseDouble(strDouble);
        System.out.println("El decimal leído es " + decimal);
        
         //Pedimos y leemos una cadena que convertiremos (parsearemos) boolean
        System.out.print("Escribe un valor lógico (true ó false): ");
        String strBoolean = teclado.nextLine();
        boolean logico = Boolean.parseBoolean(strBoolean);
        System.out.println("El valor lógico leído es " + logico);       
        
    }
    
}
