
package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
       
        Color ficha;//Solo puede ser ROJO, AZUL, VERDE ó AMARILLO
        
        //ficha = Color.AMARILLO;
        
        ficha = Color.valueOf("Verde".toUpperCase());
        
        switch(ficha){
            case AMARILLO: 
                System.out.println("Es amarillo");
                break;
                
            case ROJO: 
                System.out.println("Es rojo");
                break;
                
            case AZUL: 
                System.out.println("Es azul");
                break;
                
            case VERDE: 
                System.out.println("Es verde");
                break;    
        }
        
        System.out.println("El valor de la variable ficha es: " + ficha);
        
        /*-----------------------------------------------------------*/
        
        Turno jornada;
        String linea;
        Scanner teclado = new Scanner(System.in);
        
        System.out.println("En que turno quieres trabajar: ");
        linea = teclado.nextLine().toUpperCase();//Devolvemos un String que convierte lo introducido por teclado en mayusculas
        
        jornada = Turno.valueOf(linea);
        System.out.println("El turno escogido es "+jornada);
        
    }
    
}
