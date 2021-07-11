package one.digitalinnovation.classes.z_streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.*;
import java.util.stream.Collectors;
import java.util.zip.ZipInputStream;

public class ExerciciosStreams {
    /*Operações intermediárias: retornam um stream e poe ser encadeada
    Operações terminais: não podem ser uma atrás da outra, retornam objeto ou valor
     */

    public static void main(String[] args) {
        List<String> numerosAleatorios =
                Arrays.asList("1","0","4","1","2","3","9","9","6","5");
        imprimirElementosViaForEach(numerosAleatorios);
        coletarQuantiaDeElementos(numerosAleatorios);
        tronsformarEmOutroTipo(numerosAleatorios);
        verificarETransformar(numerosAleatorios);
        transformarEPegarMedia(numerosAleatorios);
        removerValoresImpares(numerosAleatorios);
    }

    public static void imprimirElementosViaForEach(List<String> numerosAleatorios){
        System.out.println("Imprimindo todos os elementos da lista:");
        //Forma simplificada
        numerosAleatorios.stream()
                .forEach(System.out::print);
        System.out.println("");
        //Forma intermediária:
        numerosAleatorios.stream()
                .forEach(s-> System.out.print(s));
        System.out.println("");
        //Froma complexa:
        numerosAleatorios.stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.print(s);
            }
        });
        System.out.println("");
        //A lista também tem o próprio forEach:
        numerosAleatorios.forEach(s -> System.out.print(s));
        System.out.println("");
    }

    public static void coletarQuantiaDeElementos(List<String> numerosAleatorios){
        System.out.println("Pegando os 5 primeiros números e colocando em um Set: ");
        //Forma Simplificada:
        numerosAleatorios.stream()
                .limit(5)
                //Collect pega objetos e coloca em algum lugar
                .collect(Collectors.toSet())
                .forEach(System.out::print);
        System.out.println("");
    }

    private static void tronsformarEmOutroTipo(List<String> numerosAleatorios) {
        System.out.println("Transformando a lista de String em uma lista de números inteiros: ");
        //Forma Complexa:
        numerosAleatorios.stream()
                .map(new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s);
                    }
                });
        //Forma intermediária:
        numerosAleatorios.stream()
                .map(s -> Integer.parseInt(s));
        //Forma simplificada:
        numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        //Transformando em uma variável:
        List<Integer> collectList = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static void verificarETransformar(List<String> numerosAleatorios) {
        //Forma Complexa:
        List<Integer> pares = numerosAleatorios.stream()
                .map(Integer::parseInt)
                //Filter executa um filtro com base em predicado:
                .filter(new Predicate<Integer>() {
                    @Override
                    public boolean test(Integer i) {
                        if(i%2 == 0 && i>2) return true;
                        return false;
                    }
                }).collect(Collectors.toList());
        //Forma Intermediária:
        List<Integer> pares2 = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .filter(i -> (i%2==0 && i>2))
                .collect(Collectors.toList());
        System.out.println(pares2);
    }

    public static void transformarEPegarMedia(List<String> numerosAleatorios){
        System.out.println("Mostrando média dos números: ");
        //Forma complexa:
        numerosAleatorios.stream()
                .mapToInt(new ToIntFunction<String>() {
                    @Override
                    public int applyAsInt(String s) {
                        return Integer.parseInt(s);
                    }
                });
        //Forma intermediaria:
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                .ifPresent(new DoubleConsumer() {
                    @Override
                    public void accept(double v) {
                        System.out.println(v);
                    }
                });
        //Forma simplificada:
        numerosAleatorios.stream()
                .mapToInt(Integer::parseInt)
                .average()
                //Se gerou resultado, apresenta:
                .ifPresent(System.out::println);
    }

    public static void removerValoresImpares(List<String> numerosAleatorios){
        List<Integer> numerosAleatoriosInteger = numerosAleatorios.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        //Forma Complexa:
        //RemoveIf aplicado em uma list altera ela diretamente
        //Diferente de Stream, que precisa ser atribuída a uma variável
        numerosAleatoriosInteger.removeIf(new Predicate<Integer>() {
            @Override
            public boolean test(Integer i) {
                if(i%2 !=0) return true;
                return false;
            }
        });
        System.out.println(numerosAleatoriosInteger);
        //Forma SImplificada:
        numerosAleatoriosInteger.removeIf(i -> (i%2!=0));
    }
}
