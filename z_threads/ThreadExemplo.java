package one.digitalinnovation.classes.z_threads;

public class ThreadExemplo {
    public static void main(String[] args) {
        //Forma extendendo Thread:
        BarraDeThread2 barra2 = new BarraDeThread2();
        BarraDeThread3 barra3 = new BarraDeThread3();
        barra2.start();
        barra3.start();

        //Forma implementando Runnable:
        Thread runnable2 = new Thread(new BarraDeRunnable2());
        runnable2.run();
        System.out.println(runnable2.getName());
        Thread runnable3 = new Thread(new BarraDeRunnable3());
        runnable3.run();
        System.out.println(runnable3.getName());

        //Verificando execução de Thread:
        GeradorPDF iniciarGerarPdf = new GeradorPDF();
        BarraDeCarregamento iniciarBarraDeCarregamento = new BarraDeCarregamento(iniciarGerarPdf);
        iniciarGerarPdf.start();
        iniciarBarraDeCarregamento.start();

    }
}

class GeradorPDF extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("PDF Gerado");
    }
}

class BarraDeCarregamento extends Thread {
    private Thread geradorPDF;

    public BarraDeCarregamento(Thread geradorPDF) {
        this.geradorPDF = geradorPDF;
    }

    @Override
    public void run(){
        try {
            while(true){
                Thread.sleep(1000);
                if(!this.geradorPDF.isAlive()){
                    break;
                }
                System.out.println("Carregando...");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}

class BarraDeThread2 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            //Trava por um determinado tempo:
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Rodando via Thread 2: "+this.getName());
    }
}

class BarraDeThread3 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            //Trava por um determinado tempo:
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Rodando via Thread 3: "+this.getName());
    }
}

class BarraDeRunnable2 implements Runnable{
    @Override
    public void run() {
        try {
            //Trava por um determinado tempo:
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Rodando via Runnable 2: ");
    }
}

class BarraDeRunnable3 extends Thread{
    @Override
    public void run() {
        super.run();
        try {
            //Trava por um determinado tempo:
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Rodando via Runnable 3: ");
    }
}