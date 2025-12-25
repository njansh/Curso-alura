package br.com.nadson.desafiosc4.modelo;

public class ValidadorCPF {

    private static final String PADRAO_CPF = "^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$";

    public static String validarCPF(String cpf) {
        if (cpf == null || cpf.isBlank()) {
            return "CPF não pode estar vazio.";
        }

        if (cpf.matches(PADRAO_CPF)) {
            return "VÁLIDO";
        } else {
            return "Formato inválido. Use XXX.XXX.XXX-XX";
        }
    }
}
