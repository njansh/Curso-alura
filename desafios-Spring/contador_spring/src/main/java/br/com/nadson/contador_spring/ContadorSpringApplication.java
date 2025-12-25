package br.com.nadson.contador_spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ContadorSpringApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ContadorSpringApplication.class, args);
	}

	@Override
	public void run(String... args) {
		try (Scanner scanner = new Scanner(System.in)) {
			System.out.print("Digite um número: ");

			if (!scanner.hasNextInt()) {
				System.out.println("Entrada inválida. Digite um número inteiro.");
				return;
			}

			int numero = scanner.nextInt();

			if (numero < 1) {
				System.out.println("O número deve ser maior que zero.");
				return;
			}

			for (int i = 1; i <= numero; i++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}
}
