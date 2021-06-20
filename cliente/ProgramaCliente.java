package one.digitalinnovation.classes.cliente;

public class ProgramaCliente {
    public static void main(String[] args){
        final var cliente = new Cliente(18);
        cliente.getIdade();
        cliente.getPeso();
        //can't access relatorio because it's a protected method from another package
        //System.out.println(cliente.relatorio());
    }
}
