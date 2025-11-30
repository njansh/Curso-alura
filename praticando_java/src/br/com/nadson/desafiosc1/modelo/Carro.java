package br.com.nadson.desafiosc1.modelo;

public class Carro {

    private String nome;
    private double consumoMedio;           // km por litro
    private double capacidadeTanque;       // litros
    private double combustivelAtual;       // litros
    private double distanciaViagem;        // km

    public Carro(String nome, double consumoMedio, double capacidadeTanque,
                 double combustivelAtual, double distanciaViagem) {
        this.nome = nome;
        this.consumoMedio = consumoMedio;
        this.capacidadeTanque = capacidadeTanque;
        this.combustivelAtual = combustivelAtual;
        this.distanciaViagem = distanciaViagem;
    }

    public double calcularAutonomiaTotal() {
        return consumoMedio * capacidadeTanque;
    }

    public double calcularAutonomiaAtual() {
        return consumoMedio * combustivelAtual;
    }

    public boolean consegueChegar() {
        return calcularAutonomiaAtual() >= distanciaViagem;
    }

    public String imprimirAnalise() {
        if (consegueChegar()) {
            return "Você conseguirá completar a viagem sem precisar abastecer.";
        } else {
            return "Você NÃO conseguirá completar a viagem com o combustível atual.";
        }
    }

    @Override
    public String toString() {

        return String.format(
                "Tipo: %s%n" +
                        "Autonomia máxima do veículo: %.1f km%n" +
                        "Autonomia atual: %.1f km%n" +
                        "%s",
                nome,
                calcularAutonomiaTotal(),
                calcularAutonomiaAtual(),
                imprimirAnalise()
        );

    }
}