import java.util.Scanner;

public class Leitura {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
        System.out.println("Digite o seu filme favorito ");
        String filme=entrada.nextLine();
        System.out.println(filme);
        System.out.println("qual o ano do lancamento");
        int anoDeLancamento=entrada.nextInt();
        System.out.println("Digite a sua avaliação para o filme");
        double nota=entrada.nextDouble();














        entrada.close();
    }
}
