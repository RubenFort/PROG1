
package codigo;

import java.util.Scanner;

public class Ejercicio9 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner (System.in);
        String linea;
        double gravedadLuna = 0.17;
        
        System.out.print("Cual es tu peso: ");
        linea = teclado.nextLine();
        double peso=Double.parseDouble(linea);
        
        System.out.println("Tu peso en la luna es: "+(peso*gravedadLuna));
    }
    
}
