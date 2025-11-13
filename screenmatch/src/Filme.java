public class Filme {
    String nome;
    int anoDeLancamento;
    double somaDasAvaliacoes;
    boolean incluidoNoPlano;
    int totalDeAvaliacoes;
    int duracaoEmMinutos;

    void exibeFichaTecnica(){
        System.out.println("o nome do filme é "+nome);
        System.out.println("Ao ano de lancamento é "+anoDeLancamento);
    }

    void avalia(double nota){
        somaDasAvaliacoes+=nota;
        totalDeAvaliacoes++;
    }

    double pegaMedia(){
        double media=(somaDasAvaliacoes/totalDeAvaliacoes);
        return media;
    }
}
