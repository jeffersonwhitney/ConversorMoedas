import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public double Consulta(String moedaOrigem, String moedaDestino, double Quantidade){

        String endereco = "https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/pair/" + moedaOrigem + "/" + moedaDestino + "/" + Quantidade;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            String json = response.body();

            Gson gson = new Gson();
            Resultado responseObj = gson.fromJson(json, Resultado.class);
            return responseObj.getConversion_result();

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter as taxas");
        }

    }

}
