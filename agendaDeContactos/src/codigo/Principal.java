
package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        String opcion;
        
        System.out.println("(A)lta");
        System.out.println("(B)aja");
        System.out.println("(L)istar todos");
        System.out.println("(D)etalle");
        System.out.println("(S)alir");
        System.out.println("Elije una opcion: ");
        
        opcion = teclado.nextLine();
        
        switch (opcion) {
            case "A": 
                String prueba = "Hola Mundo";
                System.out.println(prueba);
                prueba=nuevoContacto(prueba);
                System.out.println(prueba);     
                System.out.println("nuevo contacto");
                break;
            case "B":
                System.out.println("baja contacto");
                break;
            case "L":
                System.out.println("listar contactor");
                break;
            case "D":
                System.out.println("detalle");
                break;
            case "S":    
                System.out.println("salir");
                break;
            default:
                System.out.println("Opcion incorrecta");
                
        }
       
    }
     private static String nuevoContacto (String prueba){
            prueba="Hello World";
            return prueba;
        }
}
