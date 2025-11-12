package desafios;

public class Desafio1 {
    public static void main(String[] args) {
        // d--------------------------------------------desfio do modolu---------------------------------
        double mediaDeNotas=(8.2+9.1+5.2)/3;
        System.out.println(" a media com pontos flutuantes é :"+mediaDeNotas);
        int media=(int)mediaDeNotas;
        System.out.println(" a media sem pontos flutuantes é" +media);

        String nome="Nadson jhony ";
        char o='O';
        System.out.println(o+" meu nome é "+nome);

        double produto=50.67;
        double quantidadeDePedido=5;
        double  valorTotal=produto*quantidadeDePedido;
        System.out.println(valorTotal);

        double dolars=23;
        double reais=dolars *4.94;
        System.out.printf("Eu tenho %2f Reais /n", reais);

        double precoInicial=500;
        double percentualDeDesconto=0.1;
        double valorDeDesconto=precoInicial*percentualDeDesconto;
        double valorReal=precoInicial-valorDeDesconto;
        System.out.printf("você teve %.2f reais de desconto e o preco total ficou de %.2f reais ",valorDeDesconto,valorReal);

    }
}
