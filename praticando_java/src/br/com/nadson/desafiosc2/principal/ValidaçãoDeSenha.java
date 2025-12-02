package br.com.nadson.desafiosc2.principal;

import java.util.Scanner;

public class ValidaçãoDeSenha {
    public static void main(String[] args) {
        String senha = "123456";
        Scanner entrada = new Scanner(System.in);
        System.out.println("Digite a senha:");
        String tentativa = entrada.nextLine();
        if (tentativa.equals(senha)) {
            System.out.println("Acesso permitdo!!");
        } else {
            System.out.println("Acesso negado!!!");
        }


    }
}
