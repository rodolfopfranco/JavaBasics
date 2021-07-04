package one.digitalinnovation.classes.z_threads;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/*
Usado para tratamento genérico em listagens grandes (10mil+)
e que não dependam um do outro.
Usa os núcleos do processador para dividir as ações
 */
public class StreamParalela {

    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1,1000).forEach(num -> System.out.println(fatorial(num)));
        long fim = System.currentTimeMillis();

        //adiciona: parallel()
        long inicio2 = System.currentTimeMillis();
        IntStream.range(1,1000).parallel().forEach(num -> System.out.println(fatorial(num)));
        long fim2 = System.currentTimeMillis();

        System.out.println("Tempo de execução normal:: "+(fim-inicio));
        System.out.println("Tempo de execução paralelo:: "+(fim2-inicio2));

        List<String> nomes = Arrays.asList("Jones","Page","Plant","Bonhan");
        nomes.stream().parallel().forEach(nome -> System.out.println(nome));
        //mesmo que:
        nomes.parallelStream().forEach(nome -> System.out.println(nome));
    }

    public static BigInteger fatorial(long num){
        BigInteger fat = new BigInteger("1");
        for (int i=2; i<= num; i++){
            BigInteger j = new BigInteger(String.valueOf(i));
            fat = fat.multiply(j);
        }
        return fat;
    }

}
