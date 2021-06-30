package one.digitalinnovation.classes.z_collections;

import java.util.*;

public class ListExercicio {
    /* 1 -
    Armazenar em lista a temperatura média dos 6 primeiros meses do ano.
    Calcular a média semestral de temperaturas.
    Mostrar todas as temperaturas acima da média e em que mês (por extenso) ocorreram.
     */

    /* 2 -
    Ter 5 perguntas (s/n) em lista sobre crimes:

    1- Telefonou pra vítima?
    2- Esteve no local do crime?
    3- Mora perto da vítima?
    4- Devia pra vítima?
    5- Já trabalhou/estudou com a vítima?

    Se respondeu sim em:
    1- Incocente
    2- Suspeita
    3,4- Cúmplice
    5- Assassina
     */

    public static void main(String[] args){
        Scanner leitor = new Scanner(System.in);

        //Exercício 1:
        /*
        TemperaturaSemestral exercicio1 = new TemperaturaSemestral();
        exercicio1.cadastraTemperatura(leitor);
        Double media = exercicio1.mediaTemperaturas();
        System.out.println("Média semestral de temperaturas: "+media);
        exercicio1.acimaDaMedia(media);
         */
        //Exercício 2:
        ForularioCriminal exercicio2 = new ForularioCriminal();
        exercicio2.perguntas(leitor);
        System.out.println(exercicio2.veredito());
        leitor.close();
    }

}

class TemperaturaSemestral {
    private List<Double> temperaturas = new ArrayList<>();
    private List<String> meses = new ArrayList<>(Arrays.asList("Janeiro","Fevereiro","Março","Abril","Maio","Junho"));

    public TemperaturaSemestral() {
    }

    public void cadastraTemperatura(Scanner leitor){
        for (int i=1; i<7 ; i++){
            System.out.println("Informe a temperatura média do "+i+"º mês:");
            double temperatura = leitor.nextDouble();
            this.addTemperatura(temperatura);
        }
    }

    public Double mediaTemperaturas(){
        Double soma = 0.0;
        for (Double temperatura : temperaturas){
            soma += temperatura;
        }
        return soma/temperaturas.size();
    }

    public void acimaDaMedia(Double media){
        System.out.println("Meses com temperaturas acima da média:");
        int i = 0;
        for (Double temperatura : temperaturas) {
            if (temperatura > media) {
                System.out.println(meses.get(i)+" - "+temperatura+"º");
                i++;
            }
        }
    }

    public void addTemperatura(Double temperatura){
        this.temperaturas.add(temperatura);
    }

    public List<Double> getTemperaturas() {
        return temperaturas;
    }

    @Override
    public String toString() {
        return "TemperaturaSemestral{" +
                "temperaturas=" + temperaturas +
                '}';
    }
}

class ForularioCriminal {
    private List<String> questoes = new ArrayList<>(Arrays.asList(
            "1- Telefonou pra vítima?",
            "2- Esteve no local do crime?",
            "3- Mora perto da vítima?",
            "4- Devia pra vítima?",
            "5- Já trabalhou/estudou com a vítima?"
    ));

    private List <String> respostas = new ArrayList<>();

    public void perguntas(Scanner leitor){
        String resposta = "";
        System.out.println("Responda com S / N:");
        for (String questao : this.questoes) {
            System.out.println(questao);
            resposta = leitor.next();
            this.respostas.add(resposta.toLowerCase());
        }
    }

    public String veredito(){
        int contagem = (Collections.frequency(this.respostas, "s"));
        switch (contagem){
            case (1):
                return "Inocente";
            case 2:
                return "Suspeita";
            case 3:
                return "Cúmplice";
            case 4:
                return "Cúmplice";
        }
        return "Assassina";
    }

    public void addRespostas(String resposta) {
        this.respostas.add(resposta);
    }
    public List<String> getQuestoes() {
        return questoes;
    }
    public List<String> getRespostas() {
        return respostas;
    }
}