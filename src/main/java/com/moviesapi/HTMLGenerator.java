package com.moviesapi;

import java.io.PrintWriter;
import java.util.List;

public class HTMLGenerator {
    private PrintWriter out;

    public HTMLGenerator(PrintWriter out) {
        this.out = out;
    }

    public void generate(List<Movie> movies) {
        String head = """
            <!DOCTYPE html>
            <html lang="pt-br">
            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>Movies</title>
                <link rel="website icon" type="png" href="iconMovie.png">
                <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
            </head>

            <body style="background: #87CEEB;">
                <h1 style="font-family: fantasy; text-align: center; margin-top: 10px; justify-content: space-around;">Top Movies</h1> 
                <div class="card-deck" style="display: grid; grid-template-columns: 1fr 1fr 1fr 1fr; margin-top: 25px; margin-left: 2%">            
        """;

        String body = """
                    <div class="card text-white bg-dark mb-3" style="max-width: 18rem;">
                        <h4 class="card-header">%s</h4>
                        <div class="card-body">
                            <img class="card-img" src="%s" alt="%s">
                            <p class="card-text mt-2">Nota: %s - Ano: %s</p>
                        </div>
                    </div>
        """;

        out.print(head);

        for(int i = 0; i < movies.size(); i++) {
            out.print(String.format(body, movies.get(i).getTitle(), movies.get(i).getImage(), "image", movies.get(i).getImDbRating(), movies.get(i).getYear()));
        }

        out.print("""
                </div>
            </body>
        </html>
        """);
    }
     
}