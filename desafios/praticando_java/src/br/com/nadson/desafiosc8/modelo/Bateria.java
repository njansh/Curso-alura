package br.com.nadson.desafiosc8.modelo;

public class Bateria {

    private final int capacidade = 100;
    private int nivelCarga;

    public Bateria() {
        this.nivelCarga = 0;
    }

    public void carregar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade de carga inválida: " + quantidade);
        }
        setNivelDeCarga(nivelCarga + quantidade);
    }

    public void usar(int quantidade) {
        if (quantidade < 0) {
            throw new IllegalArgumentException("Quantidade de uso inválida: " + quantidade);
        }
        setNivelDeCarga(nivelCarga - quantidade);
    }

    public void setNivelDeCarga(int valor) {
        if (valor < 0) {
            System.out.println("Valor inválido (" + valor + "). Nível de carga não pode ser negativo. Ajustado para 0.");
            this.nivelCarga = 0;
        } else if (valor > capacidade) {
            System.out.println("Valor inválido (" + valor + "). Nível de carga não pode ultrapassar " + capacidade + ". Ajustado para 100.");
            this.nivelCarga = capacidade;
        } else {
            this.nivelCarga = valor;
        }
    }

    public NivelCarga mostrarNivelDeCarga() {
        if (nivelCarga <= 30) {
            return NivelCarga.BAIXO;
        } else if (nivelCarga <= 70) {
            return NivelCarga.MEDIO;
        } else {
            return NivelCarga.ALTO;
        }
    }

    @Override
    public String toString() {
        return "Bateria [capacidade=" + capacidade + "mAh, nivelCarga=" + nivelCarga + "mAh, nivel=" + mostrarNivelDeCarga() + "]";
    }

    public enum NivelCarga {
        BAIXO, MEDIO, ALTO
    }
}
