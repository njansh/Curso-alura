package br.com.nadson.desafiosc8.principal;

import java.util.Scanner;

import br.com.nadson.desafiosc8.modelo.Login;

public class ValidacaoDeLogin {

	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			int tentativas = 0;
while (true) {
	
	if( tentativas >3){
		System.out.println("Número máximo de tentativas excedido. Encerrando o programa.");
        break;
	}
			System.out.print("Digite o login: ");
			String login = scanner.nextLine();

			System.out.print("Digite a senha: ");
			String senha = scanner.nextLine();

			Login usuario = new Login("admin", "1234");
			usuario.logar(login, senha);
			if (!usuario.validateLogin(login, senha)) {
				tentativas++;
				System.out.println("Tentativa " + tentativas + " de 3.");
			}
			
			
            System.out.print("Deseja tentar novamente? (s/n): ");
			
		}} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e.getMessage());
		}
	}

}
