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
        Scanner leitura2 = new Scanner(System.in); //cria um novo scanner
        Scanner leitura3 = new Scanner(System.in);
        MenuSelecao menu = new MenuSelecao(); // cria um objeto menu
        Moeda moeda = new Moeda(); // cria uma moeda

        //PRIMEIRA ETAPA
        menu.mostrarTexto1(); // Printa primeiro texto
        menu.opcoesDeMoedas(); // Printa as opções de moedas
        menu.setMenuSelecao1((Integer.parseInt(leitura.nextLine())));// Armazena a primeira seleção

        //CONSULTA DA API COM O RESULTADO DO METODO
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + menu.menuDeMoedas(menu.getMenuSelecao1())))
                .build();

        //SEGUNDA ETAPA
        menu.mostrarTexto2(); // Printa segundo texto
        moeda.setQuantidade(Double.parseDouble(leitura2.nextLine())); // Armazena a quantidade da moeda em Double
        moeda.setTipoOrigem(menu.menuDeMoedas(menu.getMenuSelecao1())); // Usa o metodo menuDeMoedas para retornar e armazenar a moeda Origem

        //TERCEIRA ETAPA
        menu.mostrarTexto3(); //mostra a opcao de saida
        menu.opcoesDeMoedas(); //mostra o menu novamente
        menu.setMenuSelecao2(Integer.parseInt(leitura3.nextLine()));
        moeda.setTipoDestino(menu.menuDeMoedas(menu.getMenuSelecao2()));
        System.out.println("processando..."); //aqui eh pra não pensar que ta demorando muito

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();
        System.out.println(json);
        Gson gson = new Gson();


        System.out.println(menu.getMenuSelecao1());
        System.out.println(moeda.getQuantidade());
        System.out.println(moeda.getTipoOrigem());
        System.out.println(moeda.getTipoDestino());
        System.out.println(menu.getMenuSelecao2());


    }
}