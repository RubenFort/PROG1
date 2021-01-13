package codigo;

/*
Este programa es una calculadora ejecutable desde la línea de comandos.
Las operaciones admitidas son: +, -, X, /.
Los operandos son enteros.
Unos ejemplos de uso son:
    3 + 4 tiene que devolver 7.
    3 - 5 que devolver -2.
    3 X 4 que devolver 12;
    20 / 3 tiene que devolver 6.
    -3 + -4 que devolver -7.
 */
public class Calculadora {

    public static void main(String[] args) {
        int resultado = 0;
        int num1, num2;
        boolean operacionValida;
        
        //Si el número de argumentos recibidos es direrente de 3 la peticion es erronea
        if (args.length != 3) {
            System.out.println("Argumentos introducidos incorrectos");
        } else {
            //Extraigo y parseo los argumentos
            num1 = Integer.parseInt(args[0]);
            num2 = Integer.parseInt(args[2]);
            
            //Dependiendo de la operación solicitada hacemos el cálculo correspondiente
            
            switch (args[1]) {
                case "+":
                    resultado = num1 + num2;
                    operacionValida = true;
                    break;
                case "-":
                    resultado = num1 - num2;
                    operacionValida = true;
                    break;
                case "X": case "x":
                    resultado = num1 * num2;
                    operacionValida = true;
                    break;
                case "/":
                    resultado = num1 / num2;
                    operacionValida = true;
                    break;
                default:
                    operacionValida = false;
            }
            
            if(operacionValida){
                System.out.println("Resultado: " + resultado);
            } else {
                System.out.println("Operación no válida");
            }
        }
    }
}

