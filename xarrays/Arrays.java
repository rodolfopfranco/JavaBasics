package one.digitalinnovation.classes.xarrays;

public class Arrays {
    //Não mudam de tamanho
    //Começam com os valores 0
    public static void main(String[] args){
        //Formas de declarar:
        String[] nomeDoVetor = new String[2];
        int[] vetorNumerico = new int[3];
        double[] vetorJaDeclarado = {1,2,3,4,5};

        //Alterando valor:
        System.out.println("antes: "+vetorJaDeclarado[1]);
        vetorJaDeclarado[1] = 9;
        System.out.println("depois: "+vetorJaDeclarado[1]);

        //Tamanho:
        System.out.println("Tamanho: "+vetorJaDeclarado.length);

        //Percorrendo:
        for (int i=0; i<5; i++){
            System.out.println(vetorJaDeclarado[i]);
        }

        //Matriz:_______________________________________________________
        int[][] matriz = {{1,2,3},{4,5,6},{7,8,9}};
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println();
        }
    }

}
