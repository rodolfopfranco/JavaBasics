package one.digitalinnovation.classes.z_interfacesFuncionais;

import java.util.function.Predicate;

public class Predicados {
    //Recebem um parâmetro e retornam boolean
    public static void main (String[] args){
        Predicate<String> estaVazio = valor -> valor.isEmpty();
        System.out.println(estaVazio.test(""));
        System.out.println(estaVazio.test("Jojo"));
    }
}
