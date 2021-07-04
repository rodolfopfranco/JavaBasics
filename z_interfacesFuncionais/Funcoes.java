package one.digitalinnovation.classes.z_interfacesFuncionais;

import java.util.function.Function;

public class Funcoes {
    public static void main (String[] args){
        //Passa um dado mas retorna outro. O segundo parâmetro indica o tipo do retorno.
        Function<String,String> retornarNomeAoContrario = texto -> new StringBuilder(texto).reverse().toString();
        Function<String,Integer> converteStringParaInteiro = string -> Integer.valueOf(string);
        System.out.println(retornarNomeAoContrario.apply("Jojo"));
    }
}
