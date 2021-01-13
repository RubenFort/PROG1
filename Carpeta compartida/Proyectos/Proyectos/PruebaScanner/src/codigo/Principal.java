package codigo;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
         
        int unidades;
        double precioUnidad;
        double total;
        
        //Construímos un Scanner para leer desde el teclado
        Scanner teclado = new Scanner(System.in);
        
        //Pedimos y leemos las unidades
        System.out.print("Unidades:");
        unidades = teclado.nextInt();
        
        //Pedimos y leemos el precio unitario
        System.out.print("Precio Unidad:");
        precioUnidad = teclado.nextDouble();
        
        //Calculamos e imprimimos el total
        total = unidades * precioUnidad;
        System.out.println("El total es " + total);
        
        
    }
    
}
