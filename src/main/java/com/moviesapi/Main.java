package com.moviesapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        //Consumindo a API
        String json = new ImdbApiClient().getBody("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");

        //Parseando o JSON
        List<Movie> movies = new ImdbMovieJsonParser(json).parse();

        //Gerando o HTML
        PrintWriter out = new PrintWriter("index.html");
        HTMLGenerator page = new HTMLGenerator(out);

        page.generate(movies);
        out.close();
    }
}