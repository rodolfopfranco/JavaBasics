package one.digitalinnovation.classes.estaticas;

public class Programa {
    public static void main(String[] args){
        final Cachorro pitbull = new Cachorro();
        pitbull.porte="Medio";
        final Cachorro viraLata = new Cachorro();
        System.out.println(pitbull.porte);
        System.out.println(viraLata.porte);
    }
}
