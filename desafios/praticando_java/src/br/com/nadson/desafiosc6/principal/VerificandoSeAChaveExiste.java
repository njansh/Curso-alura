package br.com.nadson.desafiosc6.principal;

import java.util.HashMap;
import java.util.Map;

public class VerificandoSeAChaveExiste {
    public static void main(String[] args) {
        Map<Integer, String> clientes = new HashMap<>();
        clientes.put(1, "João");
        clientes.put(2, "Maria");
        clientes.put(3, "Pedro");
        clientes.put(4, "Vitoria");
        clientes.put(5, "Nadson");
        int chave=2;
        if (clientes.containsKey(chave)) {
            System.out.printf("O cliente com a chave %d existe na lista de clientes seu nome é %s%n", chave, clientes.get(chave));
        } else {
            System.out.printf("%n-A chave %d não existe na lista de clientes.", chave);
        }


    }
}
