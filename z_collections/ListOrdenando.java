package one.digitalinnovation.classes.z_collections;

/*
Criar uma lista de gatos com:
NOME        IDADE   COR
Andromeda   1       Preto
Baco        10      Branco
Caribdis    5       Tartaruga
 */

import java.util.*;

public class ListOrdenando {
    public static void main(String[] args){
        List<Gato> gatos = new ArrayList<>();
        Gato gato1 = new Gato("Andromeda",1,"Preto");
        Gato gato2 = new Gato("Baco",10,"Branco");
        Gato gato3 = new Gato("Caribdis",5,"Tartaruga");
        gatos.add(gato1);
        gatos.add(gato2);
        gatos.add(gato3);
        System.out.println("Por ordem de inserção: "+gatos);

        Collections.shuffle(gatos);
        System.out.println("Embaralhando gatos: "+gatos);

        System.out.println("Ordenando comparando objetos(Nome): "); //Criar comparable override na classe gato
        Collections.sort(gatos);
        System.out.println(gatos);

        System.out.println("Ordenando por Idade: ");
        Collections.sort(gatos, new AgeComparator());
        //Ou:
        gatos.sort(new AgeComparator());
        System.out.println(gatos);

        System.out.println("Ordenando por Cor: ");
        Collections.sort(gatos, new ColorComparator());
        System.out.println(gatos);

        System.out.println("Ordenando por Nome -> Cor -> Idade: ");
        Collections.sort(gatos, new NameColorAgeComparator());
        System.out.println(gatos);


    }
}

class Gato implements Comparable<Gato>{
    private String nome;
    private Integer idade;
    private String cor;

    //Alt+ins para constructor, getter and setters
    public Gato(String nome, Integer idade, String cor) {
        this.nome = nome;
        this.idade = idade;
        this.cor = cor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                ", cor='" + cor + '\'' +
                '}';
    }

    @Override
    public int compareTo(Gato gato){
        return this.getNome().compareToIgnoreCase(gato.getNome());
    }
}

class AgeComparator implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return Integer.compare(g1.getIdade(),g2.getIdade());
    }
}

class ColorComparator implements Comparator<Gato> {
    @Override
    public int compare(Gato g1, Gato g2){
        return g1.getCor().compareToIgnoreCase(g2.getCor());
    }
}

class NameColorAgeComparator implements Comparator<Gato>{

    @Override
    public int compare(Gato g1, Gato g2){
        int name = g1.getNome().compareToIgnoreCase(g2.getNome());
        if (name != 0) return name;

        int color = g1.getCor().compareToIgnoreCase(g2.getCor());
        if (color != 0) return color;

        return Integer.compare(g1.getIdade(), g2.getIdade());
    }
}