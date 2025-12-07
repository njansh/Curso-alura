package br.com.nadson.desafiosc8.principal;

import java.util.Scanner;
import br.com.nadson.desafiosc8.modelo.Login;

public class ValidacaoDeLogin {

    public static void main(String[] args) {
        Login usuario = new Login("admin", "1234");
        int tentativas = 0;

        try (Scanner scanner = new Scanner(System.in)) {

            while (true) {

                if (tentativas >= 3) {
                    System.out.println("Número máximo de tentativas excedido. Encerrando o programa.");
                    break;
                }

                System.out.print("Digite o login: ");
                String login = scanner.nextLine();

                System.out.print("Digite a senha: ");
                String senha = scanner.nextLine();

                usuario.logar(login, senha);

                if (!usuario.validateLogin(login, senha)) {
                    tentativas++;
                    System.out.println("Tentativa " + tentativas + " de 3.");
                } else {
                    System.out.println("Bem-vindo ao sistema!");
                    break;
                }

                System.out.print("Deseja tentar novamente? (s/n): ");
                String opcao = scanner.nextLine().trim().toLowerCase();

                if (opcao.equals("n")) {
                    System.out.println("Encerrando o programa.");
                    break;
                }
            }

        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
    }
}
