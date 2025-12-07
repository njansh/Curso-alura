package br.com.nadson.desafiosc7.modelo;

public class Colaborador{
    String nome, cargo;
    int nivelAcesso;

    public Colaborador(String nome, String cargo, int nivelAcesso){
        this.nome = nome;
        this.cargo = cargo;
        this.nivelAcesso = nivelAcesso;
    }

    public void atualizarDados(String novoCargo,  int novoNivel){
        System.out.println("Informações antes da atualização:");
        System.out.printf("nome: %s%nCargo:%s%nNível: %d%n",nome,cargo, nivelAcesso);
        
        cargo=novoCargo;
        nivelAcesso=novoNivel;
        System.out.println("Informações após a atualização:");
        System.out.printf("nome: %s%nCargo:%s%nNível: %d%n",nome,cargo, nivelAcesso);
    }


}
