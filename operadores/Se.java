package one.digitalinnovation.classes.operadores;

public class Se {
    public static void main(String[] args){
        final var condicao = false;

        if (condicao) {
            System.out.println("Verdadeiro");
        } else {
            System.out.println("Falso");
        }

        if (condicao)
            System.out.println("Numa linha");

        final var ternario = condicao ? "É verdadeira" : "é falsa";

        System.out.println(ternario);
    }
}
