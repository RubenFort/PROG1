package codigo;

import java.util.Random;

public class Principal {

    private static int LANZAMIENTOS = 60000000;   
int[] apariciones = new int[7];
    public static void main(String[] args) {
        
        //Construímos un generador de aleatorios
        Random generador = new Random();
        int lanzamiento;
        
        //Construímos un array de 7 ints para guardar el nº de apariciones de cada valor
        //en la pos 0 no se guarda nada (no se usa)
        //en la pos 1 se guardaría el nº de apariciones del 1
        //.
        //.
        //en la pos 6 se guardaría el nº de apariciones del 6 
        //y lo inicializamos a 0s
        
        int[] apariciones = new int[7];
        for(int i=0; i<7; i++){
            apariciones[i] = 0;
        }
        
        //Lanzamos el dado LANZAMIENTOS veces y vamos incrementando los contadores
        for(int i=0; i<LANZAMIENTOS; i++){
            lanzamiento = 1 + generador.nextInt(6);
            apariciones[lanzamiento]++;
        }
        
        //Mostramos la estadística
        for(int i=1; i<=6; i++){
            System.out.println("Veces " + i + ":" + apariciones[i] + "  " +
                    "(" + (apariciones[i]/(float)LANZAMIENTOS)*100 + "%)");
        }
        
        
        
        
        
        
    }
    
}
