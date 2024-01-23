package com.moviesapi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;

public class ImdbApiClient {

    public String getBody(String api) throws IOException, URISyntaxException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient(); //classe usada para enviar requisições e recuperar as respostas

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI(api))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
