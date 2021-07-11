package one.digitalinnovation.classes.z_collections;
/*População de alguns estados do Nordeste:
    Estado      População
    PE          9616621
    AL          3351543
    CE          9187103
    RN          3534265

    Criar dicionário com estado e população
    Substituir população do RN por 3534165
    Conferir se o estado PB está no dicionário. Se não estiver, adicionarPB 4039277
    Exibir população de PE
    Exibir todos os estados e todas suas populações na ordem informada
    Exibir em ordem alfabetica
    Exibir o estado com menor população + quantidade
    Exibir o estado com maior população + quantidade
    exibir a média da população
    Remover estados com população menor de 4000000
    Apagar dicionário
    Conferir se está vazio.
 */

/*
    Fazer programa que simule lançamento de dados.
    Lançar o dado 100 vezes e armazenar.
    Depois mostrar quantas vezes cada valor foi inserido.
 */

import java.util.*;

public class MapExercicios {
    public static void main(String[] args) {

        EstadosNordeste estadosNordestinos = new EstadosNordeste();
        estadosNordestinos.substituiPopulacaoRN();
        estadosNordestinos.confereExistenciaPB();
        estadosNordestinos.exibePopulacaoPE();
        estadosNordestinos.exibeEstadosNaOrdemInformada();
        estadosNordestinos.exibeAlfabeticamente();
        estadosNordestinos.menorPopulacao();
        estadosNordestinos.maiorPopulacao();
        estadosNordestinos.mediaPopulacao();
        estadosNordestinos.removeEstadosComPopulacaoAbaixoDe4M();
        estadosNordestinos.apagaDicionario();

        System.out.println("EXERCICIO 2:");
        Dados dados = new Dados();
        dados.contaCadaValor();
    }
}

class EstadosNordeste {
    private Map<String,Integer> estadosPopulacao;

    public EstadosNordeste() {
        //Criar dicionário com estado e população
        this.estadosPopulacao = new HashMap<>() {
            {
                put("PE", 9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
    }

    public void substituiPopulacaoRN(){
        //Substituir população do RN por 3534165
        estadosPopulacao.put("RN",3534165);
    }

    public void confereExistenciaPB(){
        //Conferir se o estado PB está no dicionário. Se não estiver, adicionarPB 4039277
        if(!this.estadosPopulacao.containsKey("PB")){
            this.estadosPopulacao.put("PB",4039277);
        }
    }

    public void exibePopulacaoPE() {
        //Exibir população de PE
        System.out.println("População de PE: "+this.estadosPopulacao.get("PE"));
    }

    public void exibeEstadosNaOrdemInformada() {
        //Exibir todos os estados e todas suas populações na ordem informada
        Map<String,Integer> estadosOrdenados= new LinkedHashMap<>(){
            {
                put("PE", 123);
                put("PE",9616621);
                put("AL", 3351543);
                put("CE", 9187103);
                put("RN", 3534265);
            }
        };
        System.out.println("Ordem original: "+estadosOrdenados);
    }

    public void exibeAlfabeticamente(){
        //Exibir em ordem alfabetica
        Set<Map.Entry<String, Integer>> estadosAlfabeticamente = new TreeSet<>(new ComparatorEstado());
        estadosAlfabeticamente.addAll(this.estadosPopulacao.entrySet());
        System.out.println("Alfabeticamente: "+estadosAlfabeticamente);
    }

    public void menorPopulacao() {
        //Exibir o estado com menor população + quantidade
        Integer menor = Collections.min(this.estadosPopulacao.values());
        String estado = "";
        for (Map.Entry<String, Integer> entry : this.estadosPopulacao.entrySet()) {
            if (entry.getValue().equals(menor)) {
                estado = entry.getKey();
            }
        }
        System.out.println("Estado com menor população: "+estado+" "+menor);
    }

    public void maiorPopulacao() {
        //Exibir o estado com maior população + quantidade
        Integer maior = Collections.max(this.estadosPopulacao.values());
        String estado = "";
        for (Map.Entry<String, Integer> entry : this.estadosPopulacao.entrySet()) {
            if (entry.getValue().equals(maior)) {
                estado = entry.getKey();
            }
        }
        System.out.println("Estado com maior população: "+estado+" "+maior);
    }

    public void mediaPopulacao(){
        //exibir a média da população
        Double populacaoTotal = 0.0;
        for (Integer populacao : this.estadosPopulacao.values()){
            populacaoTotal += populacao;
        }
        Double mediaPopulacao = populacaoTotal / this.estadosPopulacao.size();
        System.out.println("Média da população: "+mediaPopulacao);
    }

    public void removeEstadosComPopulacaoAbaixoDe4M(){
        //Remover estados com população menor de 4000000
        System.out.println("Estados antes da remoção: "+this.estadosPopulacao);
        Iterator<Integer> iterador = this.estadosPopulacao.values().iterator();
        while(iterador.hasNext()){
            if(iterador.next()<4000000) iterador.remove();
        }
        System.out.println("Estados com mais de 4000000 após a remoção: "+this.estadosPopulacao);
    }

    public void apagaDicionario(){
        //Apagar dicionário,Conferir se está vazio.
        this.estadosPopulacao.clear();
        System.out.println("Dicionário apagado? "+this.estadosPopulacao.isEmpty());
    }

    class ComparatorEstado implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> l1, Map.Entry<String, Integer> l2) {
            return l1.getKey().compareToIgnoreCase(l2.getKey());
        }
    }

}

class Dados{
    private Map<String,Integer> numeros;

    public Dados() {
        this.numeros = new HashMap();
        for (Integer i = 0; i < 100; i++){
            Random atual = new Random();
            this.numeros.put(String.valueOf(i), atual.nextInt(20));
        }
        System.out.println(numeros);
    }

    public void contaCadaValor(){
        Map<String,Integer> numeroSemRepetidos = new HashMap();
        Set<Map.Entry<String,Integer>> entries = this.numeros.entrySet();
        for (Map.Entry<String, Integer> entry: entries) {
            if (!numeroSemRepetidos.containsValue(entry.getValue())) {
                numeroSemRepetidos.put(entry.getKey(), entry.getValue());
            }
        }
        for (Integer numeroContado : numeroSemRepetidos.values()){
            System.out.println("O número "+numeroContado+" aparece "+Collections.frequency(this.numeros.values(),numeroContado)+" vezes.");
        }
    }
}