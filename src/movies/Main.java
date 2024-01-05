package movies;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
        System.out.println(response.statusCode());
    }

}