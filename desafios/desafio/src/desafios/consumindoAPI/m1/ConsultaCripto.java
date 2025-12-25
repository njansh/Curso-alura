package desafios.consumindoAPI.m1;

import desafios.consumindoAPI.ApiClient;

import java.io.IOException;
import java.util.Scanner;

public class ConsultaCripto {
    public static void main(String[] args) throws IOException, InterruptedException {

            Scanner leitura=new Scanner(System.in);
            ApiClient dao=new ApiClient();
            System.out.println("Diga o nome da moeda para a busca");
            var busca=leitura.nextLine();
            dao.setEnderecoCripto(busca);
            dao.consultar();

        }
}
