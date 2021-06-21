package one.digitalinnovation.classes.xexcecoes;

import one.digitalinnovation.classes.xclasse_exercicios.Carro;

public class ExcpetionsExamples {
    public static void main(String[] args) throws Exception {
        //Checked Exception:
        try{
            new java.io.FileInputStream("arquivo.txt");
        } catch (java.io.FileNotFoundException e){
            System.out.println("Não foi possível abrir o arquivo");
        }

        //Unchecked Exception:

        try {
            Carro carro = new Carro("Nissan","2021-ABC",2021);
            carro.getPassageiros();
        } catch (Exception e){
            throw new Exception("Erro na criação do objeto");
        } finally {
            System.out.println("Informe o próximo");
        }

    }

}
