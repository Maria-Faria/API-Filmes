package com.moviesapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;

public class ImdbMovieJsonParser {

    private String json;

    public ImdbMovieJsonParser(String json) {
        this.json = json;
    }

    public List<Movie> parse() {
        int start = this.json.indexOf("[");
        int end = this.json.indexOf("]");

        String newJson = json.substring(start, end + 1);

        /*UTILIZANDO A BIBLIOTECA JACKSON*/
        /*ObjectMapper mapper = new ObjectMapper();

        try {
            List<Movie> movies = mapper.readValue(newJson, new TypeReference<List<Movie>>(){}); //lista de filmes, com base no json
            return movies;

        } catch (JsonMappingException e) {
            e.printStackTrace();

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }*/

        /*UTILIZANDO A BIBLIOTECA GSON*/
        Gson gson = new Gson();
        List<Movie> movies = new ArrayList<Movie>();

        Movie movieArray[] = gson.fromJson(newJson, Movie[].class);

        movies = Arrays.asList(movieArray);

        return movies;
    }
}
