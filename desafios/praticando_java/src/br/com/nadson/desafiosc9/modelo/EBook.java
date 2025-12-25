package br.com.nadson.desafiosc9.modelo;

public class EBook extends Midia {
    private String formato;

    public EBook(String nome, int dataLancameto, String formato) {
        super(nome, dataLancameto);
        this.formato = formato;
    }
    @Override
public void exibirInfo(){
    System.out.println(gerarCodigo()+"EBook: "+getNome()+"-"+" Formato: "+this.formato);
}}
