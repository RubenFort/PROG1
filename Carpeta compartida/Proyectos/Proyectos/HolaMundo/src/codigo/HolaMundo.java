package codigo;

public class HolaMundo {


    public static void main(String[] args) {
        
        int i = 10;
        int j = 20;
        double d = 22.2;
        boolean b = false;
        char c = 'X';
        String miNombre = "Alberto";

        System.out.println("Hola Mundo Java, soy " + miNombre  + " ... nos vamos");
        System.out.println("i vale:" + i + " y d vale:" + d + ", b vale: " + b + " c vale:" + c);
        System.out.println("i vale " + i + ", j vale " +
                            j + " y i+j vale " + suma(i,j)) ;       

    }
    
    private static int suma(int x, int y) {
        return x + y;
    }
}
