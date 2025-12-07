package br.com.nadson.desafiosc7.modelo;

public class Estoque {
    private String nomeDoProduto;
    private int estoqueDisponivel;

    public Estoque(String nomeDoProduto, int estoqueDisponivel) {
        this.nomeDoProduto = nomeDoProduto;
        this.estoqueDisponivel = estoqueDisponivel;
    }

    public boolean processarVenda(int quantidadeVendida) {
        System.out.printf(
                "Estoque de %s antes da venda de %d unidades: %d%n",
                nomeDoProduto, quantidadeVendida, estoqueDisponivel
        );

        if (quantidadeVendida <= 0) {
            System.out.println("Quantidade inválida para venda.");
            return false;
        }

        if (quantidadeVendida <= estoqueDisponivel) {
            estoqueDisponivel -= quantidadeVendida;
            System.out.printf("Venda de %d unidades realizada com sucesso.%n", quantidadeVendida);
        } else {
            System.out.println("Estoque insuficiente para realizar a venda.");
            return false;
        }

        System.out.printf("Estoque de %s após a venda: %d%n", nomeDoProduto, estoqueDisponivel);
        return true;
    }

    public void adicionarEstoque(int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida para reposição.");
            return;
        }
        estoqueDisponivel += quantidade;
        System.out.printf("%d unidades adicionadas ao estoque de %s. Estoque atual: %d%n",
                quantidade, nomeDoProduto, estoqueDisponivel);
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public int getEstoqueDisponivel() {
        return estoqueDisponivel;
    }
}
