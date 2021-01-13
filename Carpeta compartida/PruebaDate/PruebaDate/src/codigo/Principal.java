package codigo;

import java.util.Date;

public class Principal {

    public static void main(String[] args) {

        //Construímos y mostramos un Date con fecha/hora de ahora
        System.out.println("Construímos y mostramos un Date con fecha/hora de ahora");
        Date ahora = new Date();
        System.out.println("Ahora es: " + ahora);
        System.out.println("Año: " + ahora.getYear());
        System.out.println("Mes: " + ahora.getMonth());
        System.out.println("Dia: " + ahora.getDate());
        System.out.println("Día Semana: " + ahora.getDay());
        System.out.println("Hora: " + ahora.getHours());
        System.out.println("Minuto: " + ahora.getMinutes());
        System.out.println("Segundo: " + ahora.getSeconds());
        System.out.println("Desde 1/1/1970 han transcurrido " + ahora.getTime() + " milisegundos");

        System.out.println("--------------------------------------------------------------------------");
        //Contruímos un Date con la fecha de nacimiento
        System.out.println("Contruímos un Date con la fecha de nacimiento");
        Date elDiaQueNaci = new Date(62, 8, 5); //5/9/1962
        System.out.println("El día que nací:" + elDiaQueNaci);

        System.out.println("--------------------------------------------------------------------------");
        long milisegundosVividos = ahora.getTime() - elDiaQueNaci.getTime();
        long dias = (((milisegundosVividos / 1000)/60)/60)/24;

        System.out.println("Llevo en este mundo " + dias + " días");

    }

}
