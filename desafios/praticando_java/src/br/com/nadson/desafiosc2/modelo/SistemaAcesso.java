package br.com.nadson.desafiosc2.modelo;

public class SistemaAcesso {

    private final int codigo;
    private final int nivelPermisssao;
    private final int CODIGO_CORRETO = 2023;

    public SistemaAcesso(int codigo, int nivelPermisssao) {
        this.codigo = codigo;
        this.nivelPermisssao = nivelPermisssao;
    }

    public String verificarAcesso() {
        boolean codigoValido = codigo == CODIGO_CORRETO;
        boolean nivelValido = nivelPermisssao == 1 || nivelPermisssao == 2 || nivelPermisssao == 3;

        if (codigoValido && nivelValido) {
            return "Acesso permitido. Bem-vindo ao sistema!";
        }

        StringBuilder mensagem = new StringBuilder("Acesso negado.\n");

        if (!codigoValido) {
            mensagem.append("Motivo: Código de acesso incorreto.\n");
        }

        if (!nivelValido) {
            mensagem.append("Motivo: Nível de permissão inválido (somente 1, 2 ou 3).");
        }

        return mensagem.toString();
    }
}
