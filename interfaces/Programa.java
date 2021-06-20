package one.digitalinnovation.classes.interfaces;

public class Programa {
    public static void main(String[] args) {
        final Gol gol =new Gol();
        System.out.println("Marca do Gol:"+gol.marca());
        gol.ligar();


        final Trator trator = new Trator();
        //other possible way arround:
        //final Veiculo trator = new Trator();
        System.out.println("Registro do Trator:"+trator.registro());
        trator.ligar();

        //multiple inheritance:
        final Fiesta fiesta = new Fiesta();
        System.out.println("Marca do Fiesta:"+fiesta.marca());
        System.out.println("Registro do Fiesta:"+fiesta.registro());
    }
}
