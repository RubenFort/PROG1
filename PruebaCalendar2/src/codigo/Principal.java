package codigo;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;
import java.util.SimpleTimeZone;
import java.util.TimeZone;

public class Principal {

    public static void main(String[] args) {
        
//        Scanner teclado = new Scanner(System.in);
//        String linea;
//        int mes, año;
//        
//        System.out.print("Mes: ");
//        linea = teclado.nextLine();
//        mes = Integer.parseInt(linea);
//        mes--;
//        System.out.print("Año: ");
//        linea = teclado.nextLine();
//        año = Integer.parseInt(linea);
//                
//        Calendar cal = Calendar.getInstance();
//        
//        System.out.println("hoy " + cal.getTime());

     // get the supported ids for GMT-08:00 (Pacific Standard Time)
 String[] ids = TimeZone.getAvailableIDs(-8 * 60 * 60 * 1000);
 // if no ids were returned, something is wrong. get out.
 if (ids.length == 0)
     System.exit(0);

  // begin output
 System.out.println("Current Time");

 // create a Pacific Standard Time time zone
 SimpleTimeZone pdt = new SimpleTimeZone(-8 * 60 * 60 * 1000, ids[0]);

 // set up rules for Daylight Saving Time
 pdt.setStartRule(Calendar.APRIL, 1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);
 pdt.setEndRule(Calendar.OCTOBER, -1, Calendar.SUNDAY, 2 * 60 * 60 * 1000);

 // create a GregorianCalendar with the Pacific Daylight time zone
 // and the current date and time
 Calendar calendar = new GregorianCalendar(pdt);
 Date trialTime = new Date();
 calendar.setTime(trialTime);

 // print out a bunch of interesting things
 System.out.println("ERA: " + calendar.get(Calendar.ERA));
 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
 System.out.println("DATE: " + calendar.get(Calendar.DATE));
 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
 System.out.println("DAY_OF_WEEK_IN_MONTH: "
                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
 System.out.println("ZONE_OFFSET: "
                    + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000)));
 System.out.println("DST_OFFSET: "
                    + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000)));

 System.out.println("Current Time, with hour reset to 3");
 calendar.clear(Calendar.HOUR_OF_DAY); // so doesn't override
 calendar.set(Calendar.HOUR, 3);
 System.out.println("ERA: " + calendar.get(Calendar.ERA));
 System.out.println("YEAR: " + calendar.get(Calendar.YEAR));
 System.out.println("MONTH: " + calendar.get(Calendar.MONTH));
 System.out.println("WEEK_OF_YEAR: " + calendar.get(Calendar.WEEK_OF_YEAR));
 System.out.println("WEEK_OF_MONTH: " + calendar.get(Calendar.WEEK_OF_MONTH));
 System.out.println("DATE: " + calendar.get(Calendar.DATE));
 System.out.println("DAY_OF_MONTH: " + calendar.get(Calendar.DAY_OF_MONTH));
 System.out.println("DAY_OF_YEAR: " + calendar.get(Calendar.DAY_OF_YEAR));
 System.out.println("DAY_OF_WEEK: " + calendar.get(Calendar.DAY_OF_WEEK));
 System.out.println("DAY_OF_WEEK_IN_MONTH: "
                    + calendar.get(Calendar.DAY_OF_WEEK_IN_MONTH));
 System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));
 System.out.println("HOUR: " + calendar.get(Calendar.HOUR));
 System.out.println("HOUR_OF_DAY: " + calendar.get(Calendar.HOUR_OF_DAY));
 System.out.println("MINUTE: " + calendar.get(Calendar.MINUTE));
 System.out.println("SECOND: " + calendar.get(Calendar.SECOND));
 System.out.println("MILLISECOND: " + calendar.get(Calendar.MILLISECOND));
 System.out.println("ZONE_OFFSET: "
        + (calendar.get(Calendar.ZONE_OFFSET)/(60*60*1000))); // in hours
 System.out.println("DST_OFFSET: "
        + (calendar.get(Calendar.DST_OFFSET)/(60*60*1000))); // in hours
        
    
 
    
    // Creamos una instancia del calendario
		Calendar now = Calendar.getInstance();
 
		System.out.println("Fecha actual : " + (now.get(Calendar.MONTH) + 1)
						+ "-"
						+ now.get(Calendar.DATE)
						+ "-"
						+ now.get(Calendar.YEAR));
 
		// Array con los dias de la semana
		String[] strDays = new String[]{
						"Domingo",
						"Lunes",
						"Martes",
						"Miercoles",
						"Jueves",
						"Viernes",
						"Sabado"};
 
		// El dia de la semana inicia en el 1 mientras que el array empieza en el 0
		System.out.println("Hoy es : " + strDays[now.get(Calendar.DAY_OF_WEEK) - 1]);
	
    
    
    
    }
}
