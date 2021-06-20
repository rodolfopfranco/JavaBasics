package one.digitalinnovation.classes.xdatas;

import java.util.Calendar;

public class JavaUtilCalendar {
    //criado na 1.1, contém campos específicos como MONTH, YEAR, HOUR, etc.
    public static void main(String[] args){
        Calendar agora = Calendar.getInstance();
        System.out.println(agora);
        //java.util.GregorianCalendar[time=1624151724804,areFieldsSet=true,areAllFieldsSet=true,lenient=true,
        // zone=sun.util.calendar.ZoneInfo[id="America/Sao_Paulo",
        // offset=-10800000,
        // dstSavings=0,
        // useDaylight=false,
        // transitions=93,
        // lastRule=null],
        // firstDayOfWeek=1,
        // minimalDaysInFirstWeek=1,
        // ERA=1,
        // YEAR=2021,
        // MONTH=5,
        // WEEK_OF_YEAR=25,
        // WEEK_OF_MONTH=3,
        // DAY_OF_MONTH=19,
        // DAY_OF_YEAR=170,
        // DAY_OF_WEEK=7,
        // DAY_OF_WEEK_IN_MONTH=3,
        // AM_PM=1,
        // HOUR=10,
        // HOUR_OF_DAY=22,
        // MINUTE=15,
        // SECOND=24,
        // MILLISECOND=804,
        // ZONE_OFFSET=-10800000,
        // DST_OFFSET=0]

        //Manipulando:
        System.out.println(agora.getTime());
        agora.add(Calendar.DATE, -15);
        System.out.println("15 dias atrás: "+agora.getTime());
        agora.add(Calendar.MONTH, 4);
        System.out.println("4 meses depois: "+agora.getTime());
        agora.add(Calendar.YEAR,2);
        System.out.println("2 anos depois: "+agora.getTime());
    }
}
