package one.digitalinnovation.classes.z_streams;
/*
Classe que não recebe nome
é tanto declarada quanto instanciada em uma única instrução
Recomenda-se se você precisa de uma classe que só será usada apenas uma vez.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Anonima {
    public static void main(String[] args){
        ordenacaoPadrao();
        ordenacaoAnonima();
    }

    static void ordenacaoPadrao(){
        List<Gato> meusGatos = new ArrayList(){{
            add(new Gato("John",12,"preto"));
            add(new Gato("Odie",12,"preto"));
            add(new Gato("Garfield",12,"preto"));
        }};
        meusGatos.sort(new ComparatorIdade());
        System.out.println(meusGatos);
    }

    static void ordenacaoAnonima(){
        List<Gato> meusGatos = new ArrayList(){{
            add(new Gato("John",12,"preto"));
            add(new Gato("Odie",12,"preto"));
            add(new Gato("Garfield",12,"preto"));
        }};
        meusGatos.sort(new Comparator<Gato>() {
            @Override
            public int compare(Gato g1, Gato g2) {
                return Integer.compare(g1.getIdade(), g2.getIdade());
            }
        });
    }
}

class ComparatorIdade implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2) {
        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}