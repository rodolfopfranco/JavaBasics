package one.digitalinnovation.classes.z_paradigmaFuncional;

import java.util.function.BiPredicate;

public class FuncaoPura {
    public static void main(String[] args){
        BiPredicate<Integer,Integer> verificaSeMaior =
                (parametro,valorComparado) -> parametro > valorComparado;
        System.out.println(verificaSeMaior.test(13,12));
        System.out.println(verificaSeMaior.test(13,12));
    }
}
