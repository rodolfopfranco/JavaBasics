package one.digitalinnovation.classes.z_threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class Servicos {
    private static final ExecutorService pessoasParaExecutarAtividade = Executors.newFixedThreadPool(3);

    public static void main(String[] args) {
        Casa casa = new Casa(new Quarto());
        List<? extends Future<?>> futuros =
                new CopyOnWriteArrayList<>(casa.obterAfazeresDaCasa().stream()
                .map(atividade -> pessoasParaExecutarAtividade.submit(() -> {
                    try {
                        atividade.realizar();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }))
                .collect(Collectors.toList()));

        while (!futuros.stream().allMatch(Future::isDone)){
            int atividadesNaoFinalizadas =0;
            for(Future<?> futuro : futuros) {
                if (futuro.isDone()) {
                    try {
                        System.out.println("Parabéns, tarefa terminada: " + futuro.get());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                    futuros.remove(futuro);
                } else {
                    atividadesNaoFinalizadas += 1;
                }
            }
            System.out.println("Número de atividades não finalizadas: "+atividadesNaoFinalizadas);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        pessoasParaExecutarAtividade.shutdown();
    }
}

class Casa{
    private List<Comodo> comodos;

    Casa(Comodo... comodos){
        this.comodos = Arrays.asList(comodos);
    }

    List<Atividade> obterAfazeresDaCasa(){
        return this.comodos.stream().map(Comodo::obterAfazeresDoComodo)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

interface Atividade {
    void realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeresDoComodo();
}

class Quarto extends Comodo {
    @Override
    List<Atividade> obterAfazeresDoComodo() {
        return Arrays.asList(
            this::getArrumarCama,
            this::varrerQuarto,
            this::arrumarGuardaRoupa
            );
    }

    private void arrumarGuardaRoupa() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("Arrumar guarda-roupa");
    }

    private void varrerQuarto() throws InterruptedException {
        Thread.sleep(2000);
        System.out.println("Varrer quarto");
    }

    private void getArrumarCama() throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Arrumar cama");
    }
}