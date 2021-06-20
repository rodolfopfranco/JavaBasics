package one.digitalinnovation.classes.xdatas;
import java.time.Instant;
import java.util.Date;


public class JavaUtilDate {
    public static void main(String[] args) {
        //criada desde a 1.0. É a mais básica
        //https://docs.oracle.com/javase/8/docs/api/java/util/Date.html
        Date a = new Date();
        //Gera uma data com o milissegundo mais próximo do período de execução
        System.out.println(a);
        //Sat Jun 19 21:34:32 BRT 2021

        //Usando padrão epoch, quantidade de milissegundos desde 1/1/1970 às 00:00:00
        //System.currentTimeMillis(); pega o milissegundo mais próximo
        Long currentTime = System.currentTimeMillis();
        Date b = new Date(currentTime);
        System.out.println(b);

        //métodos úteis:
        a.after(b); //a vem depois de b?
        a.before(b); //a vem antes de b?
        a.compareTo(b); //retorna um int <0 se for antes, >0 se for depois e 0 se for igual
        a.equals(b); //compara se objetos são iguais
        a.getTime(); //retorna a data em milissegundos epoch
        a.setTime(10000L); //define uma data em milissegundos epoch

        Instant instant = b.toInstant();
        System.out.println(instant);


        /* DEPRECATED:
        Date b =  new Date(int year, int month, int date);
        Date b =  new Date(int year, int month, int date, int hrs, int min);
        Date b =  new Date(int year, int month, int date, int hrs, int min, int sec);
        Date b =  new Date(String s);
        */
    }
}
