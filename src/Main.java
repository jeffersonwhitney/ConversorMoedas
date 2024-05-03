import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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

        //CONSULTA DA API COM O RESULTADO DO METODO
//        HttpClient client = HttpClient.newHttpClient();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + menu.menuDeMoedas(menu.getMenuSelecao1())))
//                .build();
//        HttpResponse<String> response = client
//                .send(request, HttpResponse.BodyHandlers.ofString());

//        String json = response.body();
//        System.out.println(json);

        String url_str = "https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + menu.menuDeMoedas(menu.getMenuSelecao1());

        URL url = new URL(url_str);
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        request.connect();

        Gson gson = new Gson();

        JsonParser jp = new JsonParser();
        JsonElement root = jp.parse(new InputStreamReader((InputStream) request.getContent()));
        JsonObject jsonobj = root.getAsJsonObject();

        //String req_result = jsonobj.get("result").getAsString();

        //JsonObject jsonObject = gson.fromJson(root, JsonObject.class);
        JsonObject conversionRates = jsonobj.getAsJsonObject("conversion_rates");


        System.out.println(conversionRates);

        if (conversionRates.has("ARS")) {
            moeda.setArs(conversionRates.getAsJsonPrimitive("ARS").getAsDouble());
        } else {
            moeda.setArs(0.0);
        }

        if (conversionRates.has("BOB")) {
            moeda.setBob(conversionRates.getAsJsonPrimitive("BOB").getAsDouble());
        } else {
            moeda.setBob(0.0);
        }

        if (conversionRates.has("BRL")) {
            moeda.setBrl(conversionRates.getAsJsonPrimitive("BRL").getAsDouble());
        } else {
            moeda.setBrl(0.0);
        }

        if (conversionRates.has("CLP")) {
            moeda.setClp(conversionRates.getAsJsonPrimitive("CLP").getAsDouble());
        } else {
            moeda.setClp(0.0);
        }

        if (conversionRates.has("COP")) {
            moeda.setCop(conversionRates.getAsJsonPrimitive("COP").getAsDouble());
        } else {
            moeda.setCop(0.0);
        }

        if (conversionRates.has("DOL")) {
            moeda.setDol(conversionRates.getAsJsonPrimitive("DOL").getAsDouble());
        } else {
            moeda.setDol(0.0);
        }

        System.out.println(moeda.getArs());
        System.out.println(moeda.getBob());
        System.out.println("*********************");
        System.out.println(menu.getMenuSelecao1());
        System.out.println(moeda.getQuantidade());
        System.out.println(moeda.getTipoOrigem());
        System.out.println(moeda.getTipoDestino());
        System.out.println(menu.getMenuSelecao2());


    }
}