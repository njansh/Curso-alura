    package br.com.nadson.desafioslambdastream.m1;

    import java.util.Arrays;
    import java.util.List;
    import java.util.function.Predicate;

    public class FiltradorNomesLambda {
        public static void main(String[] args) {
            List<String> nomes = Arrays.asList("Alice", "Bob", "Ana", "Carlos", "Amanda");
            Predicate<String> iniciaComA = nome -> nome.startsWith("A");
            nomes.stream().filter(iniciaComA).forEach(System.out::println);
        }
    }
