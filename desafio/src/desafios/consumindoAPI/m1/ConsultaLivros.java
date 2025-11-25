package desafios.consumindoAPI.m1;

import desafios.consumindoAPI.ConsultaDao;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConsultaLivros {
    public static void main (String[] args) throws IOException, InterruptedException {
        Scanner leitura=new Scanner(System.in);
        ConsultaDao dao=new ConsultaDao();
        System.out.println("Diga o nome do livro para a busca");
        var busca=leitura.nextLine();
        dao.setEnderecoBooks(busca);
       dao.iniciar();


    }
}
