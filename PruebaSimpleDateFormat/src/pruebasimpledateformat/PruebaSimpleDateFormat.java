package pruebasimpledateformat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PruebaSimpleDateFormat {
   
    public static void main(String[] args) throws ParseException  {
        
        //Construimos un formateador/parseador con patrón dd/MM/yyyy HH:mm:ss
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        //Construimos un Date con fecha y hora del ahora
        Date ahora = new Date();
        
        //Formateamos "ahora" para generar un texto que imprimimos
        String strAhora = sdf.format(ahora);
        System.out.println("Ahora es: " + strAhora);
        
        //Presentar la fecha y hora de ahora con el siguiente formato:
        //Hoy es Lunes 30 de Marzo de 2020
        SimpleDateFormat sdf2 =
                new SimpleDateFormat("'Hoy es' EEEE dd 'de' MMMM 'de' yyyy");
        String strAhora2 = sdf2.format(ahora);
        System.out.println(""+strAhora2);
        
        
        //Construimos un formateador/parseador con patrón dd/MM/yyyy
        System.out.println("Construimos un formateador/parseador con patrón dd/MM/yyyy");
        SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");
        
        String strAyer = "30/03/2020";
        Date ayer = sdf3.parse(strAyer);
        System.out.println("Ayer fue: " + ayer);
    }
    
}
