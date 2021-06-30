package one.digitalinnovation.classes.z_paradigmaFuncional;

import java.util.function.UnaryOperator;

public class Imutabilidade {
    public static void main(String[] args){
        int valor = 20;
        UnaryOperator<Integer> retornarDobro = v->v*2;
        //Errado:
        //UnaryOperator<Integer> retornarDobro = valor = 30 v->v*2;
        System.out.println(retornarDobro.apply(valor));
        System.out.println(valor);
    }
}
