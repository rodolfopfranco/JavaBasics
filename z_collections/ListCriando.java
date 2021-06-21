package one.digitalinnovation.classes.z_collections;

import java.util.*;

public class ListCriando {
        public static void main(String[] args){
            //Formas de iniciar um list:

            List notasOld = new ArrayList();                        //Antes do Java 5
            List <Double> notasGenerics = new ArrayList<>();        //Generics pós Java 5, Diamond Operator (pós Java 7) RECOMENDAVEL
            ArrayList<Double> notasNao = new ArrayList<>();         //Não recomendável. Interface antes da implementação (SOLID)
            List <Double> notasComElementos = new ArrayList<>(Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6));  //Já com elementos

            List<Double> notasLimitada = Arrays.asList(7d,8.5,9.3,5d,7d,0d,3.6);    //Não dá pra adicionar e remover elementos
            List<Double> notasLimitada2 = List.of(7d,8.5,9.3,5d,7d,0d,3.6);         //Também é imutável

            //EXERCICIO:
            System.out.println("Crie uma lista e adicione 7 notas:");
            List <Double> notas = new ArrayList<>();
            //Adicionando elementos:
            notas.add(7.0);
            notas.add(8.5);
            notas.add(9.3);
            notas.add(5.0);
            notas.add(7.0);
            notas.add(0.0);
            notas.add(3.6);
            //Imprimindo:
            System.out.println(notas);
            System.out.println(notas.toString());
            System.out.println("Obtendo posição da nota 5.0: "+notas.indexOf(5.0));
            System.out.println("Adicionando 8.0 na posição 4: ");
                notas.add(4,8.0);
                System.out.println(notas);
            System.out.println("Substituindo nota 5.0 por 6.0");
                notas.set(notas.indexOf(5.0),6.0);
                System.out.println(notas);
            System.out.println("Verificar se nota 5.0 está na lista: "+ notas.contains(5.0));
            System.out.println("Exibir notas na ordem informada: ");
                for (Double nota : notas) System.out.print(nota+" , ");
            System.out.println("\nExibir a terceira nota: "+notas.get(2));

            //Usando a Collections:
            System.out.println("Identificar a menor nota: "+ Collections.min(notas));
            System.out.println("Identificar a maior nota: "+ Collections.max(notas));
            System.out.print("Somar os valores: ");
                //ctrl+alt+v, gera uma variável refatorando:
                Iterator<Double> iterator = notas.iterator();
                Double soma = 0d;
                while(iterator.hasNext()){
                    soma += iterator.next();
                }
                System.out.println(soma);

            System.out.println("Média das notas: "+ (soma/notas.size()));
            System.out.println("Remover a nota 0: ");
                notas.remove(0d);
                System.out.println(notas);
            System.out.print("Remover a nota da posição 0: ");
                notas.remove(0);
                System.out.println(notas);
            System.out.println("Remover notas menores que 7: ");
                Iterator<Double> iterator1 = notas.iterator();
                while(iterator1.hasNext()){
                    Double next = iterator1.next();
                    if(next<7) iterator.remove();
                }
                System.out.println(notas);

            //Lista zerada:
            System.out.print("Apagar lista: ");
                notas.clear();
                System.out.println(notas);
            System.out.println("Está vazia? "+notas.isEmpty());
        }
}
