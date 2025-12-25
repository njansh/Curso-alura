package desafios.consumindoAPI.m1;

import desafios.consumindoAPI.ApiClient;

import java.io.IOException;
import java.util.Scanner;

public class ConsultaReceita {
    public static void main(String[] args) throws IOException, InterruptedException {

            Scanner leitura=new Scanner(System.in);
            ApiClient dao=new ApiClient();
            System.out.println("Diga o nome da receita");
            var busca=leitura.nextLine();
            dao.setEnderecoReceita(busca);
            dao.consultar();

        }
}
