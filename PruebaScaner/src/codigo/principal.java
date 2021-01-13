package codigo;

import java.util.Scanner;

public class principal {

    public static void main(String[] args) {

        int unidades;
        double precioUnidad;
        double total;

        //Construimos un Scanner papa leer desde el teclado
        Scanner teclado;
        teclado = new Scanner(System.in);

        //Pedimos y leemos "unidades"
        System.out.print("Unidades: ");
        unidades=teclado.nextInt();

        //Pedimos y leemos "precioUnidad"
        System.out.print("Precio unidad: ");
        precioUnidad=teclado.nextDouble();

        //Calculamos e imprimimos "total"
        total=unidades*precioUnidad;

        System.out.println("El total es " + total);
    }
    
}
