package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.Tarefa;

import java.util.List;

public class ControleDeTarefas {
    public static void main(String[] args) {
        Tarefa tarefa1 = new Tarefa("Estudar Java");
        Tarefa tarefa2 = new Tarefa("Fazer compras");
        Tarefa tarefa3 = new Tarefa("Limpar a casa");
        tarefa1.marcarComoConcluida();
        tarefa2.marcarComoConcluida();

        List<Tarefa>tarefas=List.of(tarefa1, tarefa2, tarefa3);
tarefas.forEach(t-> t.exibirStatus());



    }

}
