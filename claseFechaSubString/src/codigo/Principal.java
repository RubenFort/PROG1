
package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner (System.in);
        Fecha [] fechas = new Fecha [10];
        
        fechas[0]=new Fecha(02, 07, 1985);
        fechas[1]=new Fecha(26, 01, 2001);
        fechas[2]=new Fecha(15, 06, 2007);
        
        System.out.println(""+fechas[0].getDia()+"/"+fechas[0].getMes()+"/"+fechas[0].getAño());
        System.out.println(""+fechas[1].getDia()+"/"+fechas[1].getMes()+"/"+fechas[1].getAño());
        System.out.println(""+fechas[2].getDia()+"/"+fechas[2].getMes()+"/"+fechas[2].getAño());
        
        
    }
    
}
