package one.digitalinnovation.classes.xclasse_exercicios;

import java.util.Objects;

public class Carro {
    private int capacidadeDePassageiros;
    private int passageiros;
    private String marca;
    private String modelo;
    private int ano;
    private String variante;

    public Carro(String marca, String modelo, int ano){
        this.passageiros = 0;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
    }

    private boolean adicionarPassageiro(){
        if (passageiros < capacidadeDePassageiros) {
            this.capacidadeDePassageiros += 1;
            return true;
        } else {
            return false;
        }
    }

    private boolean removePassageiro(){
        if (passageiros > 0) {
            this.capacidadeDePassageiros -= 1;
            return true;
        } else {
            return false;
        }
    }

    public int getCapacidadeDePassageiros() {
        return capacidadeDePassageiros;
    }

    public int getPassageiros() {
        return passageiros;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }
        Carro comparavel;
        if (obj instanceof Carro){
            comparavel = (Carro)obj;
        } else {
            return false;
        }
        if (this.hashCode() == obj.hashCode()) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(modelo, marca, ano);
    }
}