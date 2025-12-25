package br.com.nadson.desafiosc1.principal;

import br.com.nadson.desafiosc1.modelo.Temperatura;

public class ConversãoDeTemperatura {
    public static void main(String[] args) {
        Temperatura temp=new Temperatura();
        temp.celsiusParaFahrenheit(20);
        System.out.println("A temperatura em celsius é "+temp.getFahrenheit());
        System.out.println(temp.getCelsius());
    }
}

