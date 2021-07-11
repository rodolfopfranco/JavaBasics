package one.digitalinnovation.classes.z_novidades11;

import java.util.function.Function;
import java.util.stream.Collectors;

/*
A partir da versão 11, pode usar inferência (var) na Lambda
 */
public class InferenciaLambda {
    public static void main(String[] args) {
        //Exemplo de inferência de tipo:
        var nome = "Joao";
        //Na Lambda:
        Function<Integer,Double> divisaoPor2 = (var numero) ->numero/2.0 ;
        System.out.println(divisaoPor2.apply(2));

        //Antes, para ver se estava vazia:
        String espaco = "                          ";
        StringTaVazia(espaco);
        //Mas agora:
        System.out.println(espaco.isBlank());

        //Separando linhas:
        var paragrafos = "<html> \n <head> \n</head> \n<body> \n</body> \n</html>";
        StringLines(paragrafos);

        //Repetindo Strings:
        StringRepeat("Beetlejuice");
    }

    private static void StringTaVazia(String espaco){
        System.out.println(espaco == null || espaco != null && espaco.length()==0 && espaco.chars().allMatch(c -> c==' '));
    }

    private static void StringLines(String paragrafos){
        //Lines() retorna o conteúdo buscado pela Lambda
        System.out.println(paragrafos.lines().map(s->"Tag: "+s).collect(Collectors.toList()));
    }

    private static void StringRepeat(String nome){
        System.out.println(nome.repeat(3));
    }

}
