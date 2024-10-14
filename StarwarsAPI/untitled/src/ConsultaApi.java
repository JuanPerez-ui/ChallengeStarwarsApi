import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.google.gson.Gson;

public class ConsultaApi {

    public Pelicula buscaPelicula (int numeroDePelicula){

        String direccion = "https://swapi.py4e.com/api/films/" +
                numeroDePelicula+"/";


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(),Pelicula.class);
        } catch (Exception e) {
            throw new RuntimeException("No encontre esa pelicula");
        }
    }
}
