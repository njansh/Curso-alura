package desafios.consumindoAPI.m2;

import com.google.gson.Gson;

public class TesteLivro {
    public static void main(String[] args) {
        String jsonLivros= """
               
                  {\"titulo\":\"Aventuras de Pi\",
                  \"autor\":\"Yann Martel\",
                  \"editora\":{
                  \"nome\":\"Nova Fronteira\",
                  \"cidade\":\"São Paulo\"}}
                
                """;

        Gson gson =new Gson();
        Livros livro=gson.fromJson(jsonLivros, Livros.class);
        System.out.println("Esse é o livro"+livro);
    }
}
