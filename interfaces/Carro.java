package one.digitalinnovation.classes.interfaces;

public interface Carro {
    //Defining a method which will be needed
    String marca();

    //Default method on interface auto inherited:
    default void ligar() {
        System.out.println("Ligando carro!");
    }
}
