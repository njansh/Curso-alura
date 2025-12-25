package br.com.nadson.desafiosc2.principal;

import br.com.nadson.desafiosc2.modelo.Doador;
import br.com.nadson.desafiosc2.modelo.SistemaAcesso;

import java.util.Scanner;

public class VerificaçãoDeCompatibilidadeDeDoaçãoDeSangue {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o nome do doador: ");
        String nome = entrada.nextLine();

        System.out.print("Digite a idade do doador: ");
        int idade = entrada.nextInt();

        System.out.print("Digite o peso do doador (em kg): ");
        double peso = entrada.nextDouble();

        Doador doador = new Doador(nome, idade, peso);

        System.out.println();
        doador.podeDoar();

        entrada.close();
    }
}

