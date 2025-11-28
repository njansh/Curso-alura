package br.com.nadson.screenmatch.principal;

import br.com.nadson.screenmatch.excessao.ErroConvertenderAnoExcepion;
import br.com.nadson.screenmatch.modelo.Titulo;
import br.com.nadson.screenmatch.modelo.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileFilter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import java.util.Scanner;

public class PrincipalComBusca {
    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner leitura=new Scanner(System.in);
        String busca = "";
        List<Titulo> tituloList=new ArrayList<>();
        Gson gson=new GsonBuilder().
                setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();;

        String chaveGoogle = System.getenv("API_KEY_GOOGLE");
        while(!busca.equalsIgnoreCase("SAir")){
        System.out.println("Diga o nome do filme para a busca");
         busca=leitura.nextLine();

         if(busca.equalsIgnoreCase("sair")){
             break;
         }
        String endereco="https://www.omdbapi.com/?t="+busca.replace(" ", "+")+"&apikey="+chaveGoogle;
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endereco))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json=response.body()
                    ;

            System.out.println(json);

//Titulo meuTitulo=     gson.fromJson(json, Titulo.class);
            TituloOmdb meuTituloOmdb =     gson.fromJson(json, TituloOmdb.class);

            System.out.println("Titulo no Omdb"+meuTituloOmdb);
            //   try {
            Titulo meuTitulo=new Titulo(meuTituloOmdb);
            System.out.println("MEu titulo normal"+meuTitulo);
tituloList.add(meuTitulo);

        } catch (NumberFormatException e) {
            System.out.println("Aconteceu um erro \n "+e.getMessage());
        } catch (ErroConvertenderAnoExcepion e) {
            System.out.println(e.getMessage());
        }

        catch (Exception e){
            System.out.println("Algum erro ocorreu, verifique o endereco");
            System.out.println(e.getMessage());

        }}
            FileWriter escrita =new FileWriter("filmes.txt");
        escrita.write(gson.toJson(tituloList));
escrita.close();

        System.out.println("fim de tudo");
    }
}
