package br.com.nadson.desafio1.modelo;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Aluno extends Pessoa {
    private int matricula;
    private Set<Diciplina> diciplinasMatriculadas;
    private List<Avaliacao> avaliacoes;
    private StatusAluno status;
    private ResultadoAvaliacao resultadoAvaliacao;

    public Aluno(String nome, int idade, int matricula){
        super(nome, idade);
        this.matricula = matricula;

    }

    public void matricular(Diciplina diciplina){
        if(diciplinasMatriculadas == null){
            diciplinasMatriculadas = new HashSet<>();
        }else if(diciplinasMatriculadas.contains(diciplina)){
            System.out.println("Aluno ja matriculado nessa diciplina");
        }else {
            diciplinasMatriculadas.add(diciplina);
        }
    }

    public void mediaFinal(){
        double media = 0;
        for(Avaliacao avaliacao : avaliacoes){
            media += avaliacao.getNota();

        }
        media /= avaliacoes.size();
        if (media>=5){
            if (media>=7){
                resultadoAvaliacao = ResultadoAvaliacao.APROVADO;
            }else{
                resultadoAvaliacao=ResultadoAvaliacao.RECUPERACAO;
            }
        }else {
            resultadoAvaliacao=ResultadoAvaliacao.REPROVADO;
        }
    }


}