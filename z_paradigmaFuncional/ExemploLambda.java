package one.digitalinnovation.classes.z_paradigmaFuncional;
import java.util.Arrays;
import java.util.function.UnaryOperator;
/*
Programação Funcional é o processo de construção de software através de:
		Funções puras
		Evitamento de compartilhamento de estados
		Dados mutáveis
		Efeitos colaterais
	É declarativa ao invés de imperativa.
 */

public class ExemploLambda {
    public static void main(String[] args) {
        //Uma de exemplo
        UnaryOperator<Integer> calcularValorVezesTrinta = valor -> valor * 30;
        int valor = 10;
        System.out.println("Resultado: " + calcularValorVezesTrinta.apply(valor));

        //Outra criada do zero:
        //1º criar uma interface para ser aplicada
        FuncaoExemplo gerarUmaSaida = valor2 -> "Olá, "+valor2;
        System.out.println(gerarUmaSaida.gerar("Douglas"));

        //Lambda com mais de uma linha:
        FuncaoExemplo multiplasLinhas = valor3 -> {
            String a = valor3;
            a+= " Isso ";
            a+= "É um teste";
            return a;
        };

        System.out.println(multiplasLinhas.gerar("oi,"));
    }

}

//FunctionalInterface evita que seja modificada
@FunctionalInterface
//Classe Anônima:
interface FuncaoExemplo {
    String gerar(String valor);
}