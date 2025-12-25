package desafios.consumindoAPI.m3;

import desafios.consumindoAPI.ApiClient;
import desafios.consumindoAPI.m3.excessoes.ErroConsultaGitHubException;

import java.io.IOException;
import java.util.Scanner;

public class ConsultaGitHub {

    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        ApiClient dao=new ApiClient();
        System.out.println("Digite o nome de usuário do GitHub para consultar informações: ");
        String username = leitura.nextLine();

      dao.setEnderecoGit(username);

        try {
dao.consultarGit();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ErroConsultaGitHubException e) {
            System.out.println("\n⚠ Ops! " + e.getMessage());
            System.out.println("Por favor, verifique o nome digitado e tente novamente.");
        }catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }}
