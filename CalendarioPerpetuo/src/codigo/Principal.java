package codigo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Principal {
    
    //Programa que pida mes y año en imprima los dias de la semana que tiene ese
    //con el formato mostrado en la fichero "notas.txt"
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        String linea;
        int mes=0, año=0;
        int i;
        int diasDelMes, diaDeLaSemana;
        int posicionInicialPrimerDia=0;
        int cont=0;
        boolean datos;
        
        System.out.println("BIENVENIDO AL CALENDARIO PERPETUO\n");
        
        //Utilizo un do while con condición siempre true para que el calendario
        //se repita constantemente(perpetuo)
        do {        
            //Pido mes y año que quiero mostrar, pongo condiciones para que la
            //petición se repita hasta introducir correctamente los datos
            //recordemos que el calendario es perpetuo.
            
            datos=false;
            do {                
                try {
                    
                    do {                        
                        System.out.print("Mes(1-12, Enero, Ene): ");
                        linea = teclado.nextLine();
                        
            //Con el Switch consigo que también se puedan introducir como datos
            //válidos los nombres de los meses y sus abreviaturas de 3 letras (Junio o Jun)            
                        switch (linea){
                            case "Enero": case"Ene":
                                mes=1;
                                break;
                            case "Febrero": case"Feb":
                                mes=2;
                                break;
                            case "Marzo": case"Mar":
                                mes=3;
                                break;
                            case "Abril": case"Abr":
                                mes=4;
                                break;
                            case "Mayo": case"May":
                                mes=5;
                                break;
                            case "Junio":case"Jun":
                                mes=6;
                                break;
                            case "Julio":case"Jul":
                                mes=7;
                                break;
                            case "Agosto":case"Ago":
                                mes=8;
                                break;
                            case "Septiembre":case"Sep":
                                mes=9;
                                break;
                            case "Octubre":case"Oct":
                                mes=10;
                                break;
                            case "Noviembre":case"Nov":
                                mes=11;
                                break;
                            case "Diciembre":case"Dic":
                                mes=12;
                                break;
                            default:
                                mes = Integer.parseInt(linea);
                        }

                    } while (mes<1||mes>12);
                    //Resto 1 a mes, porque los meses van de 0 a 11
                    mes--;
                    System.out.print("Año: ");
                    linea = teclado.nextLine();
                    año = Integer.parseInt(linea);
                    datos=true;
                } catch (NumberFormatException e) {
                    System.out.println("Formato erroneo\n");
                }
            } while (!datos);
 
            System.out.println();
            //Creo un objeto Calendar con la clase GregorianCalendar y lo inicializo
            //dondole los valores "mes" y "año" introducidos enterioemente por teclado
            //Al día le pongo valor 1, pq es el primer día que vamos a mostrar
            Calendar cal = new GregorianCalendar(año, mes, 1);
            
            diasDelMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
            
            //Obtengo el dia de la semana en valor númerico(Domingo=1,...,Sabado=7)
            diaDeLaSemana = cal.get(Calendar.DAY_OF_WEEK);
            
            //Doy un valor a "posicionInicialPrimerDia" que va a determinar el
            //número de tabulaciones previas con las que empezará amostrarse en 
            //pantala el día 1 del mes.
            //Doy un valor a "cont" que me va determinar cuando se realiza un 
            //salto de carro
            
            switch (diaDeLaSemana) {
                case 1:
                    posicionInicialPrimerDia = 6;
                    cont = 0;
                    break;
                case 2:
                    posicionInicialPrimerDia = 0;
                    cont = 1;
                    break;
                case 3:
                    posicionInicialPrimerDia = 1;
                    cont = 2;
                    break;
                case 4:
                    posicionInicialPrimerDia = 2;
                    cont = 3;
                    break;
                case 5:
                    posicionInicialPrimerDia = 3;
                    cont = 4;
                    break;
                case 6:
                    posicionInicialPrimerDia = 4;
                    cont = 5;
                    break;
                case 7:
                    posicionInicialPrimerDia = 5;
                    cont = 6;
                    break;
            }
            
            //Imprimo por pantalla la primera linea del calendario
            System.out.println("L\tM\tX\tJ\tV\tS\tD");
            
            //Imprimo las tabulaciones previas al dia 1
            for (int j = 0; j < posicionInicialPrimerDia; j++) {
                System.out.print("\t");
            }
            
            //Imprimo los dias de la semana, con la función "roll", el atributo
            //"DAY_OF_MONTH" y la variable "true" aumento los diás de uno en uno.
            //Al ser "cont" multiplo de 7 realizo un salto de carro.
            for (i = 1; i <= diasDelMes; i++) {
                
                System.out.print(cal.get(Calendar.DAY_OF_MONTH) + "\t");
                cal.roll(Calendar.DAY_OF_MONTH, true);
                
                if (cont % 7 == 0) {
                    System.out.println();
                }
                cont++;
            }
            System.out.println("\n");
        } while (true);
   
    }

}
