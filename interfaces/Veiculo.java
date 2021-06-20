package one.digitalinnovation.classes.interfaces;

public interface Veiculo {
    String registro();

    default void ligar() {
        System.out.println("Ligando o veículo!");
    }
}
