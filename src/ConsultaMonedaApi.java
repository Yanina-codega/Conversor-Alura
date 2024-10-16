import com.google.gson.Gson;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMonedaApi {

    public Moneda busquedaMoneda(String tipoDeMoneda){
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/2b8d08aa1a9a262966882cde/latest/"+tipoDeMoneda);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), Moneda.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre ese valor de moneda :( ");
        }
    }
}
