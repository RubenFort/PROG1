package conversion;

public class Conversion {

    public static void main(String[] args) {
        double x, y;
        byte b;
        int i;
        char ch;

        x = 10.0;
        y = 3.0;

        i = (int) (x / y); // cast double to int 
        System.out.println("Integer outcome of x / y: " + i);

        i = 100;
        b = (byte) i;
        System.out.println("Value of b: " + b);

        i = 257;
        b = (byte) i;
        System.out.println("Value of b: " + b);

        b = 88; // ASCII code for X 
        ch = (char) b;
        System.out.println("ch: " + ch);
        System.out.println();

        //Conversion automática de Byte a int
        b = 10;
        i = b * b;//El programa interpreta y convierte los operandos(tipo byte) a tipo int

        b = 10;
        b = (byte) (b * b);//El programa interpreta y convierte los operandos(tipo byte) a tipo int

        System.out.println("i and b: " + i + " " + b);

        char ch1 = 'a', ch2 = 'b';

        ch1 = (char) (ch1 + ch2);

        System.out.println("ch1: " + ch1);
        System.out.println();

        for (i = 0; i < 5; i++) {
            System.out.println(i + " / 3 sin decimales: " + i / 3);
            System.out.println(i + " / 3 con decimales: "
                    + (double) i / 3);
            System.out.println();
        }
    }
}
