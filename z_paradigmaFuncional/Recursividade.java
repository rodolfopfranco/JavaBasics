package one.digitalinnovation.classes.z_paradigmaFuncional;

import java.util.HashMap;
import java.util.Map;

public class Recursividade {
    static Map<Integer,Integer> MAPA_FATORIAL = new HashMap<>();

    public static void main(String[] args){
        System.out.println(fatorial(5));
    }

    public static int fatorial (int valor){
        if (valor ==1){
            return valor;
        } else{
            return valor*fatorial((valor-1));
        }
    }

    public static Double fatorialComTailCall (double valor, double numero){
        if (valor==0){
            return numero;
        }
        return fatorialComTailCall(valor-1, numero*valor);
    }

    public static Integer fatorialComMemorization(Integer valor){
        if (valor==1){
            return valor;
        } else {
            if (MAPA_FATORIAL.containsKey(valor)){
                return MAPA_FATORIAL.get(valor);
            } else {
                Integer resultado = valor * fatorialComMemorization(valor-1);
                MAPA_FATORIAL.put(valor,resultado);
                return resultado;
            }
        }
    }
}