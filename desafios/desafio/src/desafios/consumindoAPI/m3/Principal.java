package desafios.consumindoAPI.m3;

import desafios.consumindoAPI.m3.excessoes.SenhaInvalidaException;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        System.out.println("Vamos fazer uma divisao:\ndiga qual o primeiro numero:");
//        int dividendo = entrada.nextInt();
//        System.out.println("Agora diga o segundo numero:");
//        int divisor = entrada.nextInt();
//        double divisao = (double) dividendo / divisor;
//        System.out.println(
//                divisao
//        );

        try {
            System.out.println("__________________________________________________________________________\n" +
                    "Digite a senha");
            String senhaVerdadeira="12345678";
            String senha =entrada.nextLine();

            if(!senha.equalsIgnoreCase(senhaVerdadeira)|| !(senha.length() ==senhaVerdadeira.length())){
                throw new SenhaInvalidaException("Senha invalida tente novamente");

            }
        } catch (SenhaInvalidaException e) {
            throw new RuntimeException(e);
        }
    }

}
