package one.digitalinnovation.classes.interfaces;

//MULTIPLE INHERITANCE ON THE RUN:
public class Fiesta implements Carro, Veiculo{
    @Override
    public String marca(){ return "Ford"; }

    @Override
    public String registro() { return "129730ABNT"; }

    @Override
    public void ligar() {
        Carro.super.ligar();
        Veiculo.super.ligar();
    }
}
