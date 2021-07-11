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
        System.out.println(estadosNordestinos.getEstadosPopulacao());
        estadosNordestinos.SubstituiPopulacaoRN();
        estadosNordestinos.ConfereExistenciaPB();
        estadosNordestinos.ExibePopulacaoPE();
        estadosNordestinos.ExibeEstadosNaOrdemInformada();
        estadosNordestinos.ExibeAlfabeticamente();
    }
}

class EstadosNordeste {
    private Map<String,Integer> estadosPopulacao;

    public Map<String, Integer> getEstadosPopulacao() {
        return estadosPopulacao;
    }

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

    public void SubstituiPopulacaoRN(){
        //Substituir população do RN por 3534165
        estadosPopulacao.put("RN",3534165);
    }

    public void ConfereExistenciaPB(){
        //Conferir se o estado PB está no dicionário. Se não estiver, adicionarPB 4039277
        if(!this.estadosPopulacao.containsKey("PB")){
            this.estadosPopulacao.put("PB",4039277);
        }
    }

    public void ExibePopulacaoPE() {
        //Exibir população de PE
        System.out.println("População de PE: "+this.estadosPopulacao.get("PE"));
    }

    public void ExibeEstadosNaOrdemInformada() {
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
        System.out.println(estadosOrdenados);
    }

    public void ExibeAlfabeticamente(){
        //Exibir em ordem alfabetica
        Set<Map.Entry<String, Integer>> estadosAlfabeticamente = new TreeSet<>(new ComparatorEstado());
        estadosAlfabeticamente.addAll(this.estadosPopulacao.entrySet());
        System.out.println(estadosAlfabeticamente);
    }

    class ComparatorEstado implements Comparator<Map.Entry<String, Integer>> {
        @Override
        public int compare(Map.Entry<String, Integer> l1, Map.Entry<String, Integer> l2) {
            return l1.getKey().compareToIgnoreCase(l2.getKey());
        }
    }

}