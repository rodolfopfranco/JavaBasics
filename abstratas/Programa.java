package one.digitalinnovation.classes.abstratas;

public class Programa {
    public static void main(String[] args){
        //Abstract class can't be instantiated:
        //final FormaGeometrica = new FormaGeometrica();
        final FormaGeometrica quadrado = new Quadrado("quadrado",2.0);
        System.out.println(quadrado);
        System.out.println(quadrado.desenha(12,34));
        System.out.println(quadrado.nome());
        System.out.println(quadrado.area());
    }
}
