package br.com.nadson.desafiosc6.principal;

import java.util.HashSet;
import java.util.Set;

public class ElementosUnicosEmUmaLista {
    public static void main(String[] args) {
        Set<String>eventos=new HashSet<>();
        eventos.add("IA Conference Brasil");
        eventos.add("AI Summit");
        eventos.add("DevFest");
        eventos.add("Cloud Expo");
        eventos.add("IA Conference Brasil");
        eventos.add("DevFest");

        System.out.println("Lista de eventos: "+eventos);
    }
}
