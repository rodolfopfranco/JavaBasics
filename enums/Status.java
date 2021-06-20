package one.digitalinnovation.classes.enums;

public enum Status {
    //Enum with a key to a value, also 2 methods to retrieve them
    OPEN(13,"Aberto"),
    CLOSE(02,"Fechado");

    private int cod;
    private String texto;

    //Constructor:
    Status(final int cod, final String texto){
        this.cod=cod;
        this.texto=texto;
    }
    public int getCod(){ return cod; }

    public String getTexto(){ return texto; }
}