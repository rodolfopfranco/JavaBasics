package one.digitalinnovation.classes.z_collections;

/*
    Ordenar um dicionário de livros contendo:
    Autor               Livro
    LEE, Harper         Nome: O Sol é para todos. Páginas: 350
    ADAMS, Douglas      Nome: Guia do Mochileiro das Galáxias. Páginas: 160
    BUTLER, Octavia     Nome: Kindred. Páginas: 448
 */

import java.util.*;

public class MapOrdenando {
    public static void main(String[] args){
        System.out.println("Ordem aleatórias: ");
            Map<String, Livro> meusLivros = new HashMap<>(){{
                put("LEE, Harper",new Livro("O Sol é para todos",350));
                put("ADAMS, Douglas",new Livro("Guia do Mochileiro das Galáxias",160));
                put("BUTLER, Octavia",new Livro("Kindred",448));
            }};
            for(Map.Entry<String,Livro> livro : meusLivros.entrySet())
                System.out.println(livro.getKey()+" - "+ livro.getValue().getNome());

        System.out.println("Ordem de inserção: ");
            Map<String, Livro> meusLivros2 = new LinkedHashMap<>(){{
                put("LEE, Harper",new Livro("O Sol é para todos",350));
                put("ADAMS, Douglas",new Livro("Guia do Mochileiro das Galáxias",160));
                put("BUTLER, Octavia",new Livro("Kindred",448));
            }};
            for(Map.Entry<String, Livro> livro : meusLivros2.entrySet())
                System.out.println(livro.getKey()+" - "+livro.getValue().getNome());

        System.out.println("Por ordem alfabética de autores: ");
            Map<String, Livro> meusLivros3 = new TreeMap<>(meusLivros);
            System.out.println(meusLivros3);

        System.out.println("Ordem alfabética de nome dos livros");
            Set<Map.Entry<String, Livro>> meusLivros4 = new TreeSet<>(new ComparatorNome());
            //passa todos os de um map pro outro:
            meusLivros4.addAll(meusLivros.entrySet());
            for (Map.Entry<String, Livro> livro : meusLivros3.entrySet())
                System.out.println(livro.getKey()+" - "+livro.getValue().getNome());
    }
}

class Livro {
    private String nome;
    private Integer paginas;

    public Livro(String nome, Integer paginas) {
        this.nome = nome;
        this.paginas = paginas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getPaginas() {
        return paginas;
    }

    public void setPaginas(Integer paginas) {
        this.paginas = paginas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livro livro = (Livro) o;
        return nome.equals(livro.nome) && paginas.equals(livro.paginas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, paginas);
    }

    @Override
    public String toString() {
        return "Livro{" +
                "nome='" + nome + '\'' +
                ", paginas='" + paginas + '\'' +
                '}';
    }
}

class ComparatorNome implements Comparator<Map.Entry<String, Livro>>{
    //Alt+ins >> Implement Methods
    @Override
    public int compare(Map.Entry<String, Livro> l1, Map.Entry<String, Livro> l2) {
        return l1.getValue().getNome().compareToIgnoreCase(l2.getValue().getNome());
    }
}