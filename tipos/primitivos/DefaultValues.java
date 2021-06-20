package one.digitalinnovation.classes.tipos.primitivos;

public class DefaultValues {
    public static void main(String[] args) {
        //shows default values for int and boolean
        final Default d = new Default();
        System.out.println(d.getI());
        System.out.println(d.isActive());
    }
}

class Default {
    int i;
    boolean active;
    public int getI(){return i;}
    public boolean isActive() {return active;}
}