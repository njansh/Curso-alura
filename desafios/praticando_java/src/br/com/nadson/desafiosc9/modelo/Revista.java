package br.com.nadson.desafiosc9.modelo;

public class Revista extends Midia {
    private int edicao;

    public Revista(String nome, int dataLancameto, int edicao) {
        super(nome, dataLancameto);
        this.edicao = edicao;
    }
    @Override
    public void exibirInfo() {
        System.out.println(gerarCodigo() + "Revista: " + getNome() + "-" + " Edição: " + this.edicao);
    }
}
