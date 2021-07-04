package one.digitalinnovation.classes.z_interfacesFuncionais;

public class FuncaoAltaOrdem {
    public static void main(String[] args){
        Calculo conta = (a,b) -> a+b;
        Calculo subtracao = (a,b) -> a-b;
        Calculo divisao = (a,b) -> a/b;
        Calculo multiplicacao = (a,b) -> a*b;
        System.out.println(executarOperacao(conta,1,2));
        System.out.println(executarOperacao(subtracao,4,2));
        System.out.println(executarOperacao(divisao,6,3));
        System.out.println(executarOperacao(multiplicacao,5,2));
    }

    public static int executarOperacao(Calculo conta, int a, int b){
        return conta.calcular(a,b);
    }
}

interface Calculo{
    public int calcular(int a,int b);
}