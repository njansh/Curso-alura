package br.com.nadson.desafiosc6.principal;

import java.util.HashMap;
import java.util.Map;

public class CriandoUmMapDeClientes {
    public static void main(String[] args) {
        Map<Integer,String> clientes=new HashMap<>();
        clientes.put(1,"Predo");
        clientes.put(2,"João");
        clientes.put(3,"Ygor");

        System.out.println("Cliente de ID de numero 2: "+clientes.get(2));

    }
}
