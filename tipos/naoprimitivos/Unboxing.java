package one.digitalinnovation.classes.tipos.naoprimitivos;

public class Unboxing {
    public static void main(String[] args) {
        //unboxing an Integer wraper into a primitive variable
        int i = new Integer(3);
        int inteiro = Integer.valueOf(1024);
        //autoboxing:
        boolean b2 = Boolean.TRUE;
        boolean b3 = Boolean.getBoolean("false");
    }
}
