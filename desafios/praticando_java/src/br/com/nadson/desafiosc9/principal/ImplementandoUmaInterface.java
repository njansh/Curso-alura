package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Relatorio;

public class ImplementandoUmaInterface {
    public static void main(String[] args) {
        Relatorio relatorio = new Relatorio("Relatório de Vendas", "Conteúdo do relatório de vendas...");
        relatorio.imprimir();

        Relatorio relatorioFinanceiro = new Relatorio("Relatório Financeiro", "Conteúdo do relatório financeiro...");
        relatorioFinanceiro.imprimir();
    }
}
