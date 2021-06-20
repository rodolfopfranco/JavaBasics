package one.digitalinnovation.classes.abstratas;

public abstract class FormaGeometrica {
    //can't be instantiated, only inherited
    public abstract String nome();
    public abstract Double area();

    public String desenha(int x, int y){
        return "Desenhando em X=$x e Y=$y";
    }
}
