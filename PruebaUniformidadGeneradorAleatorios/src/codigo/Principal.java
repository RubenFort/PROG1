package codigo;

import java.util.Random;

public class Principal {
    
    private static int LANZAMIENTOS =6000000;

    public static void main(String[] args) {
        //Construir un programa que cuente las veces y el porcentaje que sale cada
        //cara de un dado de 6 en 6.000.000 tiradas
        
        //Construimos un generador de aleatorios
        Random dado = new Random();
        
        //Construimos un array de ints para guardar el número de apariciones de cada valor
        //La posición 0 no se usa
        //En la posicion 1 se guardaría el numero de apariciones del 1
        //.
        //.
        //En la posicion 6 se guardaría el numero de apariciones del 6
        int[] apariciones= new int[7];
       
        int cara;
        
        //Inicializamos los valores a 0
        for (int i = 0; i <7; i++) {
            apariciones[i]=0;
        }
        //Lanzamos el dado
        for (int i = 0; i < LANZAMIENTOS; i++) {
            cara = dado.nextInt(6) + 1;
            apariciones [cara]++;
        }
        
        //Imprimimos la tiradas y el porcentage
        for (int i = 1; i < 7; i++) {
            System.out.println("Veces " + i + ":" + apariciones[i] + "\t" + 
                    "{" + ((float)apariciones[i]/LANZAMIENTOS)*100  + "%}");
        }   
    }
}
