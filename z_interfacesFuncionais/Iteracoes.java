package one.digitalinnovation.classes.z_interfacesFuncionais;
//Stream do paradigma funcional é um pouco mais lento que for imperativo
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Iteracoes {
    public static void main(String[] args){
        String[] nomes = { "João", "Paula", "Irene", "Palmer", "Plutarco", "João","Yuusei"};
        Integer[] numeros = {1,2,3,4,5};
        imprimirNomesFiltrados(nomes);
        imprimirTodosOsNomes(nomes);
        imprimirDobroDeCadaNumero(numeros);

        List<String> profissoes = new ArrayList<>();
        profissoes.add("Desenvolvedor");
        profissoes.add("Gerente");
        profissoes.add("Assegurador de Qualidade");
        profissoes.stream()
                .filter(profissao -> profissao.startsWith("G"))
                .forEach(System.out::println);
    }

    //modo normal:
    public static void imprimirNomesFiltrados(String... nomes){
        String nomesParaImprimir = "";
        for (int i = 0; i< nomes.length; i++){
            if (nomes[i].equals("João")){
                nomesParaImprimir += " "+nomes[i];
            }
        }
        //Paradigma funcional:
        String nomesStream =
                Stream.of(nomes)
                .filter(nome -> nome.equals("João"))
                .collect(Collectors.joining()); //Transforma o obtido em uma String única sem espaços

        System.out.println("Nomes do for: "+nomesParaImprimir);
        System.out.println("Nomes do Stream: "+nomesStream);
    }

    public static void imprimirTodosOsNomes(String... nomes){
        System.out.print("Todos os nomes - for: ");
        for (String nome : nomes){
            System.out.println(nome);
        }
        System.out.println("Todos os nomes - Stream: ");
        Stream.of(nomes)
                .forEach(nome -> System.out.println(nome));

    }

    public static void imprimirDobroDeCadaNumero(Integer... numeros){
        System.out.println("Números dobrados via for: ");
        for (Integer numero : numeros){
            System.out.println(numero*2);
        }
        System.out.println("Números dobrados via stream: ");
        Stream.of(numeros)
                .map(numero -> numero*2)
                .forEach(numero -> System.out.println(numero));
    }
}
