package desafios.orientacaoobjetos.java_oo_m4;

public class Produto implements Vendavel{

    private double precoUnitario;

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    @Override
    public double calcularPrecoTotal(int quantidade) {
        return precoUnitario*quantidade;
    }

    @Override
    public void aplicarDesconto(double percentualDesconto) {
        precoUnitario-=precoUnitario*(percentualDesconto/100);
    }
}
