import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner leitura = new Scanner(System.in); // cria um scanner
        MenuSelecao menuEntrada = new MenuSelecao(); // cria um objeto menu
        menuEntrada.mostrarmenu1(); // da print no menu

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + menuEntrada.moedaMenu(Integer.parseInt(leitura.nextLine()))))
                .build();
        //aqui ele vai fazer a requisição da api ja com a resposta da funcao que retorna a moeda de entrada
        System.out.println("processando..."); //aqui eh pra não pensar que ta demorando muito

        Scanner leitura2 = new Scanner(System.in); //cria um novo scanner
        menuEntrada.mostrarmenu2(); //chama o metodo menu 2
        Moeda moedaEntrada = new Moeda(); // cria uma moeda
        moedaEntrada.setQuantidade(Double.parseDouble(leitura2.nextLine())); //seta a quantidade em double na moeda criada
        moedaEntrada.setTipo();

        Scanner leitura3 = new Scanner(System.in);
        menuEntrada.mostrarmenu3();
        int selecao2 = Integer.parseInt(leitura3.nextLine());
        System.out.println("processando...");







        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + menuEntrada.moedaMenu()))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        String json = response.body();

        Gson gson = new Gson();
        Moeda moeda = new Moeda();
        Titulo meuTitulo = gson.fromJson(json, Titulo.class);
    }
}