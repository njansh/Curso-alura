import java.util.Scanner;

public class OutroLoop {
    public static void main(String[] args) {
        Scanner entrada =new Scanner(System.in);
        double mediaAvaliacao=0;
        double nota=0;
        int totalDeNotas=0;

        while (nota!=-1) {
            System.out.println("Digite sua nota do filme ");
            nota=entrada.nextDouble();
            if (nota!= -1){
            mediaAvaliacao+=nota;
        totalDeNotas++;}

    }
        System.out.println(mediaAvaliacao/totalDeNotas);
}}
