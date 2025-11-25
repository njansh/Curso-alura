package desafios.consumindoAPI;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaDao {
    private String endereco;
 private   String chave="ac6db349";

    public String getEndereco() {
        return endereco;
    }

    public String getChave() {
        return chave;
    }

    public void setEnderecoBooks(String busca) {
        endereco="https://www.googleapis.com/books/v1/volumes?q="+busca+"&apikey="+chave;
        this.endereco = endereco;
    }
    public void setEnderecoCripto(String busca) {
        endereco="https://api.coingecko.com/api/v3/simple/price?ids=" + busca + "&vs_currencies=usd";
        this.endereco = endereco;
    }
    public void setEnderecoReceita(String busca) {
        endereco="https://www.themealdb.com/api/json/v1/1/search.php?s=" + busca ;
        this.endereco = endereco;
    }

    public void iniciar() throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(endereco))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println(response.body());
    }

}
