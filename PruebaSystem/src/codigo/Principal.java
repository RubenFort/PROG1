package codigo;

public class Principal {

    public static void main(String[] args) {
        
        //Prueba de metodo CurrentTimeMilis
        long milisegundosTranscurridosDesde1Enero1970 = System.currentTimeMillis();
        System.out.println(milisegundosTranscurridosDesde1Enero1970);
        
        //Prueba el método System.arraycopy
        
        //Declaramos y creamos un array "origen" de 10 enteros (ints)
        //y lo llenamos (bucle)con  valores del 100 al 109 y lo mostramos en horizontal
        int [] origen = new int[10];
        for (int i = 0; i < 10; i++) {
            origen [i] = 100 + i;
        }
        System.out.print("Origen: ");
        for (int i : origen) {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        //Declaramos y creamos un array "destino" de 10 enteros (ints)
        //y lo llenamos (bucle)con  valores del 100 al 109 y lo mostramos en horizontal
        int [] destino = new int[10];
        for (int i = 0; i < 10; i++) {
            destino [i] = 0;
        }
        System.out.print("Destino: ");
        for (int i : destino) {
            System.out.print(i + " ");
        }
        System.out.println("");
        
        //Copiar desde la posición 4 hasta la 8 (ambas incluidas) del array "origen"
        //hacia la posición 3 y siguientes y lo mostramos en horizontal
        System.arraycopy(origen, 4, destino, 3, 5);
        System.out.print("Destino: ");
        for (int i : destino) {
            System.out.print(i + " ");
        }
    }
    
}
