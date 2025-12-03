package br.com.nadson.desafiosc4.principal;

import br.com.nadson.desafiosc4.modelo.ValidadorCPF;

import java.util.Scanner;

public class ValidandoCPF {
    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)){
            while (true){
                System.out.println("Digite o CPF:");
                String cpf = entrada.nextLine().trim();
                if (cpf.equalsIgnoreCase("fim")){
                    System.out.println("Finalizando programa...");
                    break;
                }
                String resultado = ValidadorCPF.validarCPF(cpf);
                if (resultado.equals("VÁLIDO")) {
                    System.out.println("O CPF está válido.");
                } else {
                    System.out.println(resultado);
                }
            }
        }
    }
}
