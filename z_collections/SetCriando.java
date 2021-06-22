package one.digitalinnovation.classes.z_collections;

//hashset, linkedset (extende hashset), treeset
//Não permite elementos duplicados
//Não tem índice
//Não tem get, set, index of

import java.util.*;

public class SetCriando {

    public static void main(String[] Args){
/*        Set notasOld = new HashSet();                         //antes do Java 5
        HashSet<Double> NotasGeneric = new HashSet<>();         //RECOMENDAVEL
        Set<Double> notasNao = new HashSet<>();                 //Não recomendavel. Interface antes da implementação (SOLID)
        Set<Double> notasComElementos = Set.of(7d,8.5,9.3,5d,7d,0d,3.6); //Já com elementos
*/
        System.out.println("Criando conjunto e adicionando notas:");
        Set<Double> notas = new HashSet<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));
        System.out.println(notas);

        System.out.println("Não é possível obter a nota da posição 5 pois não existe posição em set");
        System.out.println("Não é possível exibir a terceira nota também");
        System.out.println("Não é possível remover nota em uma posição pelo mesmo motivo");

        System.out.println("Substituindo a nota 5.0 pela 6.0: ");
        //Não é possível substituir. Mas daria para remover a 5 e subir a 6?

        System.out.println("Verificando se a nota 5.0 está no conjunto: "+notas.contains(5.0));

        System.out.println("Exibindo a menor nota: "+Collections.min(notas));
        System.out.println("Exibindo a maior nota: "+Collections.max(notas));

        System.out.println("Somando os valores: ");
            Iterator<Double> iterator = notas.iterator();
            Double soma = 0d;
            while(iterator.hasNext()){
                soma += iterator.next();
            }
            System.out.println(soma);
        System.out.println("Calculando média: "+soma/notas.size());

        System.out.println("Removendo a nota 0: ");
            notas.remove(0d);
            System.out.println(notas);
        System.out.println("Removendo notas menores que 7:");
            Iterator<Double> iterator1 = notas.iterator();
            while(iterator1.hasNext()){
                Double next = iterator1.next();
                if (next < 7.0) { iterator1.remove();}
            }
            System.out.println(notas);

        System.out.println("Exibir tudo na ordem: ");
        //Não há uma ordem no set, somente em linkedHashSet. Por isso:
            Set<Double>notas2 = new LinkedHashSet<>();
            notas2.add(7d);
            notas2.add(8.5);
            notas2.add(9.3);
            notas2.add(5d);
            notas2.add(7d);//Não vai pois não permite duplicado
            notas2.add(0d);
            notas2.add(3.6);
            System.out.println(notas2);

        System.out.println("Exibir todas as notas em ordem crescente: ");
            //TREESET organiza de acordo com a ordem natural: (comparable)
            Set<Double> notas3 = new TreeSet<>(notas2);
            System.out.println(notas3);

        System.out.println("Apagando todo o conjunto: ");
        notas.clear();

        System.out.println("Confirmando se está vazio:"+ notas.isEmpty());
    };

}
