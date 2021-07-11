package one.digitalinnovation.classes.z_novidades10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;
/*
Inferência é a identificação facilitada de tipo
var para facilitar ela
Mas pode causar erro de compilação
Serve apenas para variáveis locais
Somente a partir do Java 10
 */

public class Inferencia {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://docs.oracle.com//javase/10/language/");
        URLConnection urlConnection = url.openConnection();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining()).replaceAll(">",">\n"));

        //com var:

        var urlVar = new URL("https://docs.oracle.com//javase/10/language/");
        var urlConnectionVar = urlVar.openConnection();
        var bufferedReaderVar = new BufferedReader(new InputStreamReader(urlConnectionVar.getInputStream()));
        System.out.println(bufferedReaderVar.lines().collect(Collectors.joining()).replaceAll(">",">\n"));

    }

    public void testar(){

    }
}
