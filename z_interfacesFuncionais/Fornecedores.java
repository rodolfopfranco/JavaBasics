package one.digitalinnovation.classes.z_interfacesFuncionais;

import java.util.function.Supplier;

public class Fornecedores {
    public static void main (String[] args){
        Supplier<Pessoa> suppliers = () -> new Pessoa();
        System.out.println(suppliers.get());
    }
}

class Pessoa {
    private String nome;
    private Integer idade;

    public Pessoa() {
        nome = "Jojo";
        idade = 39;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "nome='" + nome + '\'' +
                ", idade=" + idade +
                '}';
    }
}
