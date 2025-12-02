package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class MonitorandoTentativasDeLogin {
    private static final String SENHA_CORRETA = "1234";
    private static final int MAX_TENTATIVAS = 3;

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            boolean acessoPermitido = validarAcesso(entrada);

            if (acessoPermitido) {
                System.out.println("Senha correta! Acesso permitido.");
            } else {
                System.out.println("Número de tentativas excedido. Acesso bloqueado.");
            }
        }
    }

    private static boolean validarAcesso(Scanner entrada) {
        int tentativas = 0;

        while (tentativas < MAX_TENTATIVAS) {
            System.out.printf("Digite a senha (%d/%d): ", tentativas + 1, MAX_TENTATIVAS);
            String senhaDigitada = entrada.nextLine();

            if (senhaDigitada.equals(SENHA_CORRETA)) {
                return true;
            }

            System.out.println("Senha incorreta: tente novamente");
            tentativas++;
        }

        return false;
    }
}
