package one.digitalinnovation.classes.z_collections;

/*
    Criar lista de séries com:
    NOME            GENERO      TEMPO_EPISODIO
    Doctor Who      Scifi       45
    Brooklyn 99     Comedia     20
    Mandalorian     Scifi       60
 */
//Lembrar de sobrescrever hashcode e equals no caso de Hashs


import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

public class SetOrdenando {

    public static void main (String[] args){
        System.out.println("Ordem aleatória:");
        Set<Serie> minhasSeries = new HashSet<>(){{
           add(new Serie("Doctor Who","Scifi",45));
           add(new Serie("Brooklyn 99","Comedia",20));
           add(new Serie("Mandalorian","Scifi",60));
        }};
        //Por padrão já é aleatório:
        for (Serie serie : minhasSeries) {
            System.out.println(serie.getNome()+" - "+serie.getGenero()+" - "+serie.getTempoEpisodio());
        }

        System.out.println("Por ordem de iserção:");
        Set<Serie> minhasSeries2 = new LinkedHashSet<>(){{
            add(new Serie("Doctor Who","Scifi",45));
            add(new Serie("Brooklyn 99","Comedia",20));
            add(new Serie("Mandalorian","Scifi",60));
        }};

    }
}


class Serie {
    private String nome;
    private String genero;
    private Integer tempoEpisodio;

    public Serie(String nome, String genero, Integer tempoEpisodio) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEpisodio = tempoEpisodio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getTempoEpisodio() {
        return tempoEpisodio;
    }

    public void setTempoEpisodio(Integer tempoEpisodio) {
        this.tempoEpisodio = tempoEpisodio;
    }

    @Override
    public String toString() {
        return "serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEpisodio=" + tempoEpisodio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEpisodio.equals(serie.tempoEpisodio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEpisodio);
    }
}