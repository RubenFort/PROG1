package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Color ficha; //Sólo puede ser ROJO, VERDE, AZUL ó AMARILLO

        //ficha = Color.AMARILLO;
        ficha = Color.valueOf("VeRdE".toUpperCase());

        switch (ficha) {
            case AMARILLO:
                System.out.println("Es amarillo");
                break;
            case AZUL:
                System.out.println("Es azul");
                break;
            case ROJO:
                System.out.println("Es rojo");
                break;
            case VERDE:
                System.out.println("Es verde");
                break;
        }
        
        System.out.println("El valor de la variable ficha es: " + ficha);
        
        //-----------------------------------------------------------------
        
        Turno jornada;
        String linea;
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Dime en que turno quieres trabajar (MADRUGADA, TARDE, NOCHE): ");
        linea = teclado.nextLine().toUpperCase();
        jornada = Turno.valueOf(linea);
        System.out.println("El turno escogido es " + jornada);
        
   

    }

}
