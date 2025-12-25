package br.com.nadson.desafiosc6.principal;

import java.util.List;
import java.util.stream.Collectors;

public class CalculandoOQuadradoDosNumeros {
    public static void main(String[] args) {
        List<Integer>numeros= List.of(2,4,6,7,8,9,11,22);
        List<Integer>quadrados=numeros.stream().map(f->f*f).collect(Collectors.toUnmodifiableList());
        System.out.println("O quadrado dos numeros é: "+quadrados);
    }
}
