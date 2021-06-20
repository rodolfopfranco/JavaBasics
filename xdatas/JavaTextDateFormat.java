package one.digitalinnovation.classes.xdatas;
//https://docs.oracle.com/javase/8/docs/api/java/text/DateFormat.html
//https://docs.oracle.com/javase/8/docs/api/java/text/SimpleDateFormat.html
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JavaTextDateFormat {
    public static void main(String[] args){
        //DateFormat e SimpleDateFormat parseiam a saída da data:
        Date agora = new Date();
        System.out.println(agora);
        //Sun Jun 20 13:22:19 BRT 2021

        String dateToStr = DateFormat.getInstance().format(agora);
        System.out.println(dateToStr);
        //20/06/2021 13:22

        dateToStr = DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.SHORT).format(agora);
        System.out.println(dateToStr);
        //20 de junho de 2021 13:22

        //Formatando:___________________________________________

        Date depois = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        String dataFormatada = formatador.format(depois);
        System.out.println(dataFormatada);
        //20/06/2021

        //-------------------------------------------

        Date teste = new Date();
        SimpleDateFormat formatador2 = new SimpleDateFormat("HH:MM:SS:mmm");
        String dataFormataTeste = formatador2.format(teste);
        System.out.println(dataFormataTeste);
        //13:06:735:036

    }
}
