package desafios.java_oo_m4;

import desafios.java_oo_m2.Produto;

public class PodutoFisico extends Produto implements Calculavel {
    @Override
    public double calcularPrecoFinal() {
        return getPreco()*0.2;
    }
}
