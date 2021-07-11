package one.digitalinnovation.classes.z_novidades11;
/*
Multiplexação a partir do HTTP 2, onde envia várias requisições de 1 vez.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ProxySelector;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class ClienteHttp {

    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            System.out.println("Nova Thread criada"+(thread.isDaemon() ? "daemon" : "")+ "Thread Group :: "+thread.getThreadGroup());
            return thread;
        }
    });

    public static void main(String[] args) throws IOException, InterruptedException {
        //connectAndPrintURLJavaOracle();
        //connectWithClientHTTP();
        //connectHttp1Client();
        connectHttp2Client();
    }

    public static void connectAndPrintURLJavaOracle() {
        try{
            var url = new URL("https://docs.oracle.com/javase/10/language");
            var urlConnection = url.openConnection();
            var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void connectWithClientHTTP() throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .GET().uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        //Executa request e chama o tipo:
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status code: "+response.statusCode());
        System.out.println("Headers response: "+response.headers());
        System.out.println(response.body());
    }

    public static void connectHttp1Client() throws IOException, InterruptedException {
        System.out.println("Exemplo com HTTP 1:");
        try{
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_1_1)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();
            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: "+response.statusCode());
            System.out.println("Response headers: "+ response.headers());
            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> futuro = new ArrayList<>();

            responseBody
                    .lines()
                    //busca as imagens:
                    .filter(line -> line.trim().startsWith("<img height"))
                    //busca a tag:
                    .map(line -> line.substring(line.indexOf("src='")+5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            //compõe o endereço completo da imagem:
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com"+image))
                                    .build();
                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem Carregada: "+image+", status code: "+imageResponse.statusCode());
                                /*Isso:
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pode virar isso:
                                 */
                            } catch (IOException|InterruptedException e) {
                                System.out.println("Erro ao requisitar imagem "+image);
                            }
                        });
                        futuro.add(imgFuture);
                        System.out.println("Imagens futuras enviadas: "+image);
                    });
            futuro.forEach(f ->
            {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao carregar imagem do futuro");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: "+(end-start));
        } finally {
            executor.shutdown();
        }
    }

    public static void connectHttp2Client() throws IOException, InterruptedException {
        System.out.println("Exemplo com HTTP 2:");
        try{
            HttpClient httpClient = HttpClient.newBuilder()
                    .version(HttpClient.Version.HTTP_2)
                    .proxy(ProxySelector.getDefault())
                    .build();

            long start = System.currentTimeMillis();
            HttpRequest mainRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                    .build();

            HttpResponse<String> response = httpClient.send(mainRequest, HttpResponse.BodyHandlers.ofString());

            System.out.println("Status code: "+response.statusCode());
            System.out.println("Response headers: "+ response.headers());
            String responseBody = response.body();
            System.out.println(responseBody);

            List<Future<?>> futuro = new ArrayList<>();

            responseBody
                    .lines()
                    //busca as imagens:
                    .filter(line -> line.trim().startsWith("<img height"))
                    //busca a tag:
                    .map(line -> line.substring(line.indexOf("src='")+5, line.indexOf("'/>")))
                    .forEach(image -> {
                        Future<?> imgFuture = executor.submit(() -> {
                            //compõe o endereço completo da imagem:
                            HttpRequest imgRequest = HttpRequest.newBuilder()
                                    .uri(URI.create("https://http2.akamai.com"+image))
                                    .build();
                            try {
                                HttpResponse<String> imageResponse = httpClient.send(imgRequest, HttpResponse.BodyHandlers.ofString());
                                System.out.println("Imagem Carregada: "+image+", status code: "+imageResponse.statusCode());
                                /*Isso:
                            } catch (IOException e) {
                                e.printStackTrace();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            pode virar isso:
                                 */
                            } catch (IOException|InterruptedException e) {
                                System.out.println("Erro ao requisitar imagem "+image);
                            }
                        });
                        futuro.add(imgFuture);
                        System.out.println("Imagens futuras enviadas: "+image);
                    });
            futuro.forEach(f ->
            {
                try {
                    f.get();
                } catch (InterruptedException | ExecutionException e) {
                    System.out.println("Erro ao carregar imagem do futuro");
                }
            });

            long end = System.currentTimeMillis();
            System.out.println("Tempo de carregamento total: "+(end-start));
        } finally {
            executor.shutdown();
        }
    }

}
