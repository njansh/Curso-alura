public enum Nivel {
    Iniciante(1),
    Intermediario(2),
    Avancado(3);

    private int pontuacao;
    Nivel(int pontuacao) {
        this.pontuacao = pontuacao;
    }
}