package br.com.nadson.desafiosc7.modelo;

public class SensorDeTemperatura {
    private String localizacao;
    private double temperaturaAtual;

    public SensorDeTemperatura(String localizacao, double temperaturaAtual) {
        this.localizacao = localizacao;
        this.temperaturaAtual =temperaturaAtual;
    }
    
    public void apresentarRelatporio() {
        System.out.println("Localização: " + localizacao);
        System.out.println("Temperatura Atual: " + temperaturaAtual + "°C");
    if(temperaturaAtual > 37.5) {
        System.out.println("Alerta: Temperatura alta!");
    } else if (temperaturaAtual < 15) {
        System.out.println("Alerta: Temperatura baixa!");
    } else {
        System.out.println("Temperatura dentro do intervalo normal.");
    }
    
}}
