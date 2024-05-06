import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {

    public Taxas Consulta(String enderecoAPI){

        String endereco = "https://v6.exchangerate-api.com/v6/d950eb8f18f932c5af797a8e/latest/" + enderecoAPI;
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(endereco))
            .build();
     try {
            HttpResponse<String> response = HttpClient
                    .newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
         //System.out.println(response.body());
         //System.out.println("**************************aa");
         JsonObject jsonObject = new Gson().fromJson(response.body(), JsonObject.class);
         JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");
         double taxaUSD = conversionRates.getAsJsonPrimitive("USD").getAsDouble();
         return new Taxas(conversionRates, taxaUSD);
         //return new Taxas(conversionRates);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter as taxas");
        }


    }
}
