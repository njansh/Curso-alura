package br.com.nadson.desafiosc9.modelo;

public class Midia {
private String nome;
private int dataLacamento;


public Midia(String nome,int dataLancameto){
    this.nome=nome;
    this.dataLacamento=dataLancameto;
}
public String gerarCodigo(){
return "LIB-"+this.nome.substring(0,3)+this.dataLacamento+" ";
}



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDataLacamento() {
        return dataLacamento;
    }

    public void setDataLacamento(int dataLacamento) {
        this.dataLacamento = dataLacamento;
    }

    public void exibirInfo() {
        System.out.print("");
}
}
