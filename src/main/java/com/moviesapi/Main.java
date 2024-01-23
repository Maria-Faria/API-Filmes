package com.moviesapi;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        
        String json = new ImdbApiClient().getBody("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json");

        System.out.println("---------------------------------");
        //Extraindo o JSON inteiro de filmes
        //int start = response.body().indexOf("[");
        //int end = response.body().indexOf("]");
        
        //String json = response.body().substring(start, end + 1);
        System.out.println("JSON de filmes: " + json);
        System.out.println("---------------------------------");

        /*UTILIZANDO A BIBLIOTECA JACKSON*/
        ObjectMapper conversor = new ObjectMapper(); 

        List<Movie> movies = conversor.readValue(json, new TypeReference<List<Movie>>() {}); //lista de filmes, com base no json

        PrintWriter out = new PrintWriter("index.html");
        HTMLGenerator page = new HTMLGenerator(out);

        page.generate(movies);
        out.close();
    }
}