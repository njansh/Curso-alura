package br.com.nadson.desafiosc6.principal;

import java.util.ArrayList;
import java.util.List;

public class AcessandoElementos {
    public static void main(String[] args) {
        List<String> nomes=new ArrayList<>();

        nomes.add("João");
        nomes.add("Maria");
        nomes.add("Pedro");
        nomes.add("Vitoria");
        nomes.add("Nadson");

        System.out.println("Nome do indice 2: " + nomes.get(1));
        System.out.println("Total de nomes na lista: "+nomes.size());
    }

}
