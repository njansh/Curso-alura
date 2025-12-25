package br.com.nadson.desafiosc4.principal;


import java.util.Scanner;

public class ValidandoSenhasComRegex {


    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {

            while (true) {
                System.out.print("Digite a senha (ou 'fim' para encerrar): ");
                String senha = entrada.nextLine().trim();

                if (senha.equalsIgnoreCase("fim")) {
                    System.out.println("Finalizando programa...");
                    break;
                }

                String resultado = ValidadorSenha.validar(senha);

                if (resultado.equals("VÁLIDA")) {
                    System.out.println("Senha valida.");
                } else {
                    System.out.println("Senha invalida. Ela deve conter:");
                    System.out.println("- Pelo menos 1 letra maiuscula");
                    System.out.println("- Pelo menos 1 letra minuscula");
                    System.out.println("- Pelo menos 1 dígito numérico");
                    System.out.println("- Pelo menos 1 caractere especial @$!%*?&");
                    System.out.println("- Tamanho mínimo de 8 caracteres");
                }
            }
        }
    }

    private static class ValidadorSenha {
        private static final String REGEX_SENHA =
                "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$";

        public static String validar(String senha) {
            if (senha == null || senha.isBlank()) {
                return "A senha nao pode estar vazia.";
            }

            return senha.matches(REGEX_SENHA) ? "VÁLIDA" : "INVÁLIDA";
        }

    }
}
