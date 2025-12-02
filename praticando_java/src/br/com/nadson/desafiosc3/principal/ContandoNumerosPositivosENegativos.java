package br.com.nadson.desafiosc3.principal;

import java.util.Scanner;

public class ContandoNumerosPositivosENegativos {
    public static void main(String[] args) {
        try(Scanner entrada = new Scanner(System.in)) {
            int numeroPositivo=0;
            int numeroNegativo=0;
            while(true){
                System.out.println("Digite um numero: (Ou digite fim para sair)");
                String digtado=entrada.nextLine();
 
                if(digtado.equalsIgnoreCase("fim")){
                    System.out.println("Finalizando programa...");
                    break;
                }

                try {
                    int numero = Integer.parseInt(digtado);
                    if (numero >= 0) {
                        numeroPositivo++;
                    } else {
                        numeroNegativo++;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("'" + digtado + "' é um dado inválido. Por favor, digite apenas números inteiros.");
                }

            }

            System.out.println("Quantidade de numeros positivos: "+numeroPositivo);
            System.out.println("Quantidade de numeros negativos: "+numeroNegativo);

        }
    }
}
