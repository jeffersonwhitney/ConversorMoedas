import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in);
        System.out.println("Digite a moeda de entrada:");
        System.out.println("1-ARS - Peso Argentino        4-CLP - Peso Chileno");
        System.out.println("2-BOB - Boliviano Boliviano   5-COP - Peso Colombiano");
        System.out.println("3-BRL - Real Brasileiro       6-USD - Dolar Americano");
        int selecao = Integer.parseInt(leitura.nextLine());
        String moedaentrada = "";

        Scanner leitura2 = new Scanner(System.in);
        System.out.println("Digite o valor a ser convertido: ");
        double valor = Double.parseDouble(leitura2.nextLine());

        Scanner leitura3 = new Scanner(System.in);
        System.out.println("Digite a moeda de saida:");
        System.out.println("1-ARS - Peso Argentino        4-CLP - Peso Chileno");
        System.out.println("2-BOB - Boliviano Boliviano   5-COP - Peso Colombiano");
        System.out.println("3-BRL - Real Brasileiro       6-USD - Dolar Americano");
        int selecao2 = Integer.parseInt(leitura3.nextLine());
        System.out.println("processando...");
        String moedasaida = "";

        if (selecao == 1)
            moedaentrada = "ARS";
        else if (selecao == 2) {
            moedaentrada = "BOB";
        } else if (selecao == 3) {
            moedaentrada = "BRL";
        } else if (selecao == 4) {
            moedaentrada = "CLP";
        } else if (selecao == 5) {
            moedaentrada = "COP";
        } else if (selecao == 6)
            moedaentrada = "USD";

        if (selecao2 == 1)
            moedasaida = "ARS";
        else if (selecao2 == 2) {
            moedasaida = "BOB";
        } else if (selecao2 == 3) {
            moedasaida = "BRL";
        } else if (selecao2 == 4) {
            moedasaida = "CLP";
        } else if (selecao2 == 5) {
            moedasaida = "COP";
        } else if (selecao2 == 6)
            moedasaida = "USD";


        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + moedaentrada))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());

        Gson gson = new Gson();
        Titulo meuTitulo = gson.fromJson()
    }
}