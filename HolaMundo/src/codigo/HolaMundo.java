package codigo;

public class HolaMundo {

    public static void main(String[] args) {
        int i = 10;
        int j = 20;
        double d = 22.2;
        boolean b = false;
        char c = 'X';
        String miNombre = "Ruben";
        
        System.out.println("Hola Mundo Java, soy " + miNombre + " ...nos vamos");
        System.out.println("i vale:" + 1 + ", d vale:" + d +", b vale:" + b + 
                " y c vale:" + c);
        System.out.println(i + j);
        System.out.println(i + " " + j);
        System.out.println("i:" + i + ", j:" + j + " y i+j vale:" + suma(i, j));
    }

    private static int suma(int x, int y) {
        return x + y;
    }

}
