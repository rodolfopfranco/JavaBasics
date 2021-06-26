package one.digitalinnovation.classes.z_collections;

import org.w3c.dom.ls.LSOutput;

import java.util.*;

/*
    Map faz parte do Framework Collections mas não extende a Interface Collections, extende a Map
    Cada elemento tem Key e Value (key de valor único)
    Hashmap, LinkedHashMap - O(1)
    Treemap - O(log n)
 */
public class MapCriando {

    public static void main(String[] args){
        Map carrosPopulares2020Old = new HashMap() ; //Antes do java 5
        Map<String,Double> carrosPopularesGenerics = new HashMap<>(); //Generics RECOMENDAVEL
        HashMap<String,Double> carrosPopularesNao = new HashMap<>();
        Map<String, Double> carrosPopulares2020Populado = Map.of("gol",14.4,"uno",15.6);

        System.out.println("Criando um dicionário e relacionando dados:");
        //Usa-se o put ao invés de add:
            Map<String, Double> carrosPopulares = new HashMap<>(){
                {put("gol",14.4);
                    put("uno",15.6);
                    put("mobi",16.1);
                    put("hb20",14.5);
                    put("kwid",15.6);
                }
            };
            System.out.println(carrosPopulares.toString());

        System.out.println("Substituindo o consumo do gol por 15,2 km/l");
            carrosPopulares.put("gol",15.2);
            System.out.println(carrosPopulares);

        System.out.println("Conferindo se o modelo tucson está no dicionário: "+carrosPopulares.containsKey("tucson"));
        System.out.println("Exibindo consumo do Uno: "+carrosPopulares.get("uno"));
        //System.out.println("Exibindo o 3º modelo adicionar:"); Não há ordem no map
        System.out.println("Exibindo os modelos: ");
            System.out.println(carrosPopulares.keySet());
        System.out.println("Exibindo os consumos: ");
            System.out.println(carrosPopulares.values());

        System.out.println("Exibindo o carro com menor consumo: ");
            Double consumoEficiente = Collections.max(carrosPopulares.values());
            Set<Map.Entry<String,Double>> entries = carrosPopulares.entrySet();
            String modeloMaisEficiente ="";

            for (Map.Entry<String, Double> entry: entries){
                if (entry.getValue().equals(consumoEficiente))
                    modeloMaisEficiente = entry.getKey();
            }
            System.out.println("modelo mais eficiente:"+ modeloMaisEficiente + " - "+consumoEficiente);

        System.out.println("Exibindo modelo menos econômico e seu consumo:");
            Double consumoIneficiente = Collections.min(carrosPopulares.values());
            String modeloIneficiente = "";
            for (Map.Entry<String, Double> entry : carrosPopulares.entrySet()) {
                if (entry.getValue().equals(consumoIneficiente)) {
                    modeloIneficiente = entry.getKey();
                }
            }
            System.out.println("Modelo menos eficiente: "+ modeloIneficiente + " - " + consumoIneficiente);

        System.out.println("Somando os consumos: ");
            //ctrl+alt+v on iterator = carrosPopulares.values().iterator();
            Iterator<Double> iterator = carrosPopulares.values().iterator();
            Double soma = 0d;
            while(iterator.hasNext()){
                //Não precisa do get pois só há o valor
                soma += iterator.next();
            }
            System.out.println("Soma: "+soma);

        System.out.println("Média dos consumos:"+ soma/carrosPopulares.size());
        System.out.println("Removendo modelos com consumo igual a 15,6 km/l: ");
            Iterator<Double> iterator1 = carrosPopulares.values().iterator();
            while(iterator1.hasNext()){
                if(iterator1.next().equals(15.6)) iterator1.remove();
            }
            System.out.println("Atualmente:"+carrosPopulares);

        System.out.println("Exibindo na ordem que foram informados: ");
            //necessário usar o linkedHashMap
            Map<String, Double> carrosPopularesOrdenado = new LinkedHashMap<>(){
                {put("gol",14.4);
                    put("uno",15.6);
                    put("mobi",16.1);
                    put("hb20",14.5);
                    put("kwid",15.6);
                }
            };
            System.out.println(carrosPopularesOrdenado);

        System.out.println("Ordenando dicionário pelo modelo: ");
            Map<String, Double> carrosPopularesModelo = new TreeMap<>(carrosPopularesOrdenado);
            System.out.println(carrosPopularesModelo.toString());

        System.out.println("Apagando dicionário: ");
            carrosPopulares.clear();

        System.out.println("Conferindo se está vazio: "+carrosPopulares.isEmpty());
    }

}
