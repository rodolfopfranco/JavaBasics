package one.digitalinnovation.classes.z_interfacesFuncionais;

import java.util.function.Consumer;

//Recebe um parâmetro e não precisa de return pois não retorna nada
public class Consumidor {
    public static void main(String[] args){
        Consumer<String> imprimirUmaFrase = frase -> System.out.println(frase);
        imprimirUmaFrase.accept("Hello World");
    }
}
