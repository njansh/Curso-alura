package br.com.nadson.desafiosc9.modelo;

public class Livro extends  Midia{
    private String autor;

    public Livro(String nome, int dataLancameto, String autor){
        super(nome, dataLancameto);
        this.autor=autor;
    }
@Override
    public void exibirInfo(){
        System.out.println(gerarCodigo()+"Livro: "+getNome()+"-"+" Autor: "+this.autor);

}
    }