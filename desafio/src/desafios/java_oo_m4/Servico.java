package desafios.java_oo_m4;

public class Servico implements Vendavel {


    private double precoHora;

    public double getPrecoHora() {
        return precoHora;
    }

    public void setPrecoHora(double precoHora) {
        this.precoHora = precoHora;
    }

    @Override
    public double calcularPrecoTotal(int quantidade) {
        return precoHora *quantidade;
    }

    @Override
    public void aplicarDesconto(double percentualDesconto) {
        precoHora -= precoHora *(percentualDesconto/100);
    }
}
