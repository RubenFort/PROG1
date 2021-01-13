package codigo;

public class Principal {

    public static void main(String[] args) {
        
        String s0 = "Hola Manolo";
        String s1 = "Hola Manola";
        String s2 = "Adios Juan";
        String s3 = "Hola Manolo";
        
        System.out.println("Compara s0 con s1: " + s0.compareTo(s1));
        System.out.println("Compara s1 con s0: " + s1.compareTo(s0));
        System.out.println("Compara s0 con s2: " + s0.compareTo(s2));
        System.out.println("Compara s1 con s2: " + s1.compareTo(s2));
        System.out.println("Compara s0 con s3: " + s0.compareTo(s3));
        System.out.println("Compara s1 con s3: " + s1.compareTo(s3));
        System.out.println("Compara s2 con s3: " + s2.compareTo(s3));
    }
}
