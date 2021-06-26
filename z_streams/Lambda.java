package one.digitalinnovation.classes.z_streams;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

/*
    É uma função sem declaração (nome, retorno e acesso)
    Usada no mesmo lugar que declarada.
    Sintaxe:
        (argumento) -> (corpo)
    Quase uma simplificação da função anônima
 */
public class Lambda {

    public static void main(String[] args){
        ordenacaoSemLambda();
        ordenacaoComLambda();
    }

    static void ordenacaoSemLambda(){
        List<Gato> meusGatos = criaGatos();
        meusGatos.sort(Comparator.comparing(new Function<Gato, String>(){
            //comparando anonimamente de acordo com o nome:
            @Override
            public String apply(Gato gato){
                return gato.getNome();
            }
        }));
        System.out.println(meusGatos);
    }

    static void ordenacaoComLambda(){
        List<Gato> meusGatos = criaGatos();
        meusGatos.sort(Comparator.comparing((Gato gato) -> gato.getIdade()));
        System.out.println(meusGatos);
    }

    static public List<Gato> criaGatos(){
        List<Gato> meusGatos = new ArrayList(){{
            add(new Gato("John",12,"preto"));
            add(new Gato("Odie",12,"preto"));
            add(new Gato("Garfield",12,"preto"));
        }};
        return meusGatos;
    }
}
