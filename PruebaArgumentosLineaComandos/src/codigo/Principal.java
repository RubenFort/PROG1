package codigo;

public class Principal {

    public static void main(String[] args) {
        int numeroArgumentos = args.length;
        
        System.out.println("Se han pasado " + numeroArgumentos + " argumentos por la linea de comandos");
        
        for (int i = 0; i < numeroArgumentos; i++) {
            System.out.println("Argumento " + i + ": " + args[i]);
        }
        
    }
    
}
