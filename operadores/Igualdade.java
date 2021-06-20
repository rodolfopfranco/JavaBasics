package one.digitalinnovation.classes.operadores;

public class Igualdade {
    public static void main(String[] args) {
        final var numero = 11;

        if (numero == 10) {
            System.out.println("O número é 10");
        } else {
            System.out.println("Não é 10");
        }

        if (numero != 10) {
            System.out.println("Não é 10");
        } else {
            System.out.println("É 10");
        }

        final var letra = "B";

        if ("A".equals(letra)) {
            System.out.println("É a letra A");
        } else {
            System.out.println("Não é a letra A");
        }
    }
}
