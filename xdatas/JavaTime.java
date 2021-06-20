package one.digitalinnovation.classes.xdatas;

//Usa LocalDate, LocalTime, LocalDateTime
//"Substitui" Date e Calendar
//LocalDate é Imutável

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class JavaTime {
    public static void main(String[] args){

        //LocalDate:_______________________
        //Formato: yyyy-MM-dd
        LocalDate hoje = LocalDate.now();
        System.out.println("hoje: "+hoje);
        //2021-06-20

        LocalDate ontem = hoje.minusDays(1);
        System.out.println("ontem: "+ontem);
        //2021-06-19

        //LocalTime:________________________
        //Formato: hh:mm:ss:mmm

        LocalTime agora = LocalTime.now();
        System.out.println("Agora: "+agora);
        //14:00:11.442801100

        LocalTime depois = agora.plusHours(1);
        System.out.println("Depois: "+depois);

        //LocalDateTime:_____________________
        LocalDateTime presente = LocalDateTime.now();
        System.out.println("Presente: "+presente);
        //2021-06-20T14:00:11.443798300

        LocalDateTime futuro = presente.plusHours(1).plusDays(2).plusSeconds(12);
        System.out.println("Futuro: "+futuro);

        LocalDateTime exercicio =  LocalDateTime.parse("2010-06-15T10:00:00");
        LocalDateTime alterada = exercicio.plusHours(13).plusMonths(6).plusYears(4);
        System.out.println("Data alterada: "+alterada);


    }
}
