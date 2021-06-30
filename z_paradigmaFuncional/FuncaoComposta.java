package one.digitalinnovation.classes.z_paradigmaFuncional;

import java.util.Arrays;

public class FuncaoComposta {
    public static void main(String[] args){
        int[] valores = {1,2,3,4};
        Arrays.stream(valores)
                .filter(numero -> numero % 2 ==0)               //busca pares
                .map(numero -> numero*2)                        //adiciona a multiplicação por 2
                .forEach(numero -> System.out.println(numero)); //itera nos valores da Stream

        //É o mesmo que:

        for (int i=0; i< valores.length; i++){
            int valor = 0;
            if(valores[i]%2 ==0){
                valor = valores[i]*2;
                if (valor!=0){
                    System.out.println(valor);
                }
            }
        }
    }
}
