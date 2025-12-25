import java.util.Scanner;

public class Loop {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
double mediaAvaliacao=0;
double nota=0;

        for (int i = 0; i < 3; i++) {
            System.out.println("Digite sua nota do filme ");
            nota=entrada.nextDouble();
            mediaAvaliacao+=nota;        }
        System.out.println(mediaAvaliacao);
    }
}
