package codigo;

public class principal {

    public static void main(String[] args) {
       
        System.out.println("Pi: " + Math.PI);
        System.out.println("e: " + Math.E);
        
        System.out.println("Hipotenusa de catetos 3 y 4: " + Math.hypot(3, 4));
        System.out.println("Valor Ceil de 5.3 es: " + Math.ceil(5.3));
        System.out.println("Valor Floor de 5.3 es: " + Math.floor(5.3));
        System.out.println("Valor Round de 5.3 es: " + Math.round(5.3));
        System.out.println("Valor Round de 5.7 es: " + Math.round(5.7));
        System.out.println("Double generado aleatoriamente en el rango [0.0 .. 1.0) : " + Math.random());
        System.out.println("Double generado aleatoriamente en el rango [0.0 .. 100.0) : " + 100*Math.random());
        System.out.println("Double generado aleatoriamente en el rango [25.0 .. 70.0) : " + (25 + (45*Math.random())));
        
        
    }
    
}
