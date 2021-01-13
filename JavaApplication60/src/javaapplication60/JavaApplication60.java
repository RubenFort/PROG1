package javaapplication60;

import java.util.Calendar;
import java.util.Date;

public class JavaApplication60 {

    public static void main(String[] args) {
       
       Calendar ahora =  Calendar.getInstance();
       Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
               .setWeekDate(2013, 1, 1).build();
       System.out.println(ahora);
        System.out.println(cal);
    }
    
}
