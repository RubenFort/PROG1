package codigo;

public class Principal {

    public static void main(String[] args) {
       
        //Generamos un aleatorio en el rango [0.0 .. 1.0)
        double aleatorio = Math.random();
        System.out.println("El aleatorio generado es: " + aleatorio);
        
        //Al hacer 10 x [0.0 .. 1.0) obtenemos [0.0 .. 10.0)
        //y al hacer "casteo" (promoción) a int, perdemos los decimales 
        int aleatorioEntero = (int) (aleatorio * 10);
        System.out.println("El entero generado es: " + aleatorioEntero);
        
        //Generamos un entero aleatorio en el rango [1 .. 6]
        int dadoParchis = ((int) (aleatorio * 6)) + 1;
        System.out.println("El lanzamiento del dado resultó ser: " + dadoParchis);
    }
    
}
