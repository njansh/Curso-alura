package br.com.nadson.desafioslambdastream.m2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PraticandoStreams {
    public static void main(String[] args) {
///filtrar numeros pares --------------------------------------------------------
//        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
//
//        numeros.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
//
///passar todas as letras para maiusculas------------------------------------
//        List<String> palavras = Arrays.asList("java", "stream", "lambda");
//
//        palavras.stream().map(String::toUpperCase).forEach(System.out::println);
///filtre os números ímpares, multiplique cada um por 2 e colete os resultados em uma nova lista. -----------------
//        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6);
//        List<Integer> numerosPX2 = numeros.stream().filter(n -> n % 2 != 0).map(n -> n * 2).collect(Collectors.toUnmodifiableList());
//        numerosPX2.forEach(System.out::println);
/// Filtrar palavras repetidas
//        List<String> palavras = Arrays.asList("apple", "banana", "apple", "orange", "banana");
//palavras.stream().distinct().forEach(System.out::println);
/// 5 - Dada a lista de sublistas de números inteiros abaixo, extraia todos os números primos em uma única lista e os ordene em ordem crescente.
//        List<List<Integer>> listaDeNumeros = Arrays.asList(
//                Arrays.asList(1, 2, 3, 4),
//                Arrays.asList(5, 6, 7, 8),
//                Arrays.asList(9, 10, 11, 12)
//        );
//
//        List<Integer> numerosPrimosOrdenados = listaDeNumeros.stream()
//                .flatMap(List::stream)
//                .filter(PraticandoStreams::isPrimo)
//                .sorted()
//                .collect(Collectors.toList());
//
//        System.out.println("Números primos ordenados: " + numerosPrimosOrdenados);
//    }
//
//    private static boolean isPrimo(int numero) {
//        if (numero <= 1) {
//            return false;
//        }
//        for (int i = 2; i <= Math.sqrt(numero); i++) {
//            if (numero % i == 0) {
//                return false;
//            }
//        }
//        return true;
///    6 - Dado um objeto Pessoa com os campos nome e idade, filtre as pessoas com mais de 18 anos, extraia os nomes e imprima-os em ordem alfabética. A classe Pessoa está definida abaixo.
//
//                List<Pessoa> pessoas = Arrays.asList(
//                        new Pessoa("Alice", 22),
//                        new Pessoa("Bob", 17),
//                        new Pessoa("Charlie", 19)
//                );
//pessoas.stream()
//        .filter(n -> n.getIdade() >= 18)
//        .map(Pessoa::getNome)
//        .sorted()
//        .forEach(System.out::println);
///        7 - Você tem uma lista de objetos do tipo Produto, onde cada produto possui os atributos nome (String),
///        preco (double) e categoria (String). Filtre todos os produtos da categoria "Eletrônicos" com preço menor que R$ 1000,
///           ordene-os pelo preço em ordem crescente e colete o resultado em uma nova lista.
//        List<Produto> produtos = Arrays.asList(
//                new Produto("Smartphone", 800.0, "Eletrônicos"),
//                new Produto("Notebook", 1500.0, "Eletrônicos"),
//                new Produto("Teclado", 200.0, "Eletrônicos"),
//                new Produto("Cadeira", 300.0, "Móveis"),
//                new Produto("Monitor", 900.0, "Eletrônicos"),
//                new Produto("Mesa", 700.0, "Móveis")
//        );
//
//        List<Produto> produtosFiltrados = produtos.stream()
//                .filter(p -> p.getCategoria().equals("Eletrônicos") && p.getPreco() < 1000)
//                .sorted(Comparator.comparingDouble(Produto::getPreco))
//                .collect(Collectors.toList());
//
//        produtosFiltrados.forEach(System.out::println);


    }
}
