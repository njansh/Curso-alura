package br.com.nadson.desafiosc7.principal;

import br.com.nadson.desafiosc7.modelo.SensorDeTemperatura;

public class ControleDeTemperatura {
    public static void main(String[] args) {
        SensorDeTemperatura sensor1 = new SensorDeTemperatura("Sala de Servidores", 40.2);
        SensorDeTemperatura sensor2 = new SensorDeTemperatura("Escritório", 22.5);
        SensorDeTemperatura sensor3 = new SensorDeTemperatura("Armazém", 10.0);

        sensor1.apresentarRelatporio();
        System.out.println();
        sensor2.apresentarRelatporio();
        System.out.println();
        sensor3.apresentarRelatporio();

    }
}

