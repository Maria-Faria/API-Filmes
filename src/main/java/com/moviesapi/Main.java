package com.moviesapi;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Main {

    public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException{
        HttpClient client = HttpClient.newHttpClient(); //classe usada para enviar requisições e recuperar as respostas

        HttpRequest request = HttpRequest
            .newBuilder()
            .uri(new URI("https://raw.githubusercontent.com/alura-cursos/imersao-java-2-api/main/TopMovies.json"))
            .GET()
            .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        //System.out.println(response.body());
        //System.out.println(response.statusCode());

        System.out.println("---------------------------------");
        //Extraindo o JSON inteiro de filmes
        int start = response.body().indexOf("[");
        int end = response.body().indexOf("]");
        
        String json = response.body().substring(start, end + 1);
        System.out.println("JSON de filmes: " + json);
        System.out.println("---------------------------------");

        /*UTILIZANDO A BIBLIOTECA JACKSON*/
        ObjectMapper conversor = new ObjectMapper(); 

        List<Movie> movies = conversor.readValue(json, new TypeReference<List<Movie>>() {}); //lista de filmes, com base no json

        //separando os atributos
        List<String> titles = parseTitles(movies);         
        List<String> urlImages = parseUrlImage(movies);
        List<String> years = parseYear(movies);
        List<String> rating = parseRating(movies);

        System.out.println("---- TITLES ----");
        titles.forEach(System.out::println);

        System.out.println("\n---- URL IMAGES ----");
        urlImages.forEach(System.out::println);

        System.out.println("\n---- YEARS ----");
        for(String year : years) {
            System.out.println(year);
        }

        System.out.println("\n---- RATING ----");
        rating.forEach(System.out::println);

    }

    public static List<String> parseTitles(List<Movie> movies) {
        List<String> movieTitles = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            movieTitles.add(movies.get(i).getTitle());
        }

        return movieTitles;
    }

    public static List<String> parseRating(List<Movie> movies) {
        List<String> movieRating = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            movieRating.add(movies.get(i).getImDbRating());
        }

        return movieRating;
    }

    public static List<String> parseYear(List<Movie> movies) {
        List<String> movieYear = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            movieYear.add(movies.get(i).getYear());
        }

        return movieYear;
    }

    public static List<String> parseUrlImage(List<Movie> movies) {
        List<String> movieImages = new ArrayList<>();

        for(int i = 0; i < movies.size(); i++) {
            movieImages.add(movies.get(i).getImage());
        }

        return movieImages;
    }
}