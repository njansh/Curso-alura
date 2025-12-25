package desafios;

import java.util.Random;
import java.util.Scanner;

public class JogoDeAdvinhacao {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        int numeroAleatorio=new Random().nextInt(100);
        int tentativas=0;


        int tentando=0;
        while (numeroAleatorio!=tentando){
            System.out.println("Tente adivinhar o numero entre 0 e 100");
            tentativas++;
             tentando=entrada.nextInt();
            if(tentando>numeroAleatorio){
                System.out.println("Errou passou um pouco ");
            }else if(tentando <numeroAleatorio){
                System.out.println("Errou falta  um pouco ");
            }else {
                System.out.println("Acertou /n"+ "numero de tentativas "+tentativas);
            }
        }

    }
}
