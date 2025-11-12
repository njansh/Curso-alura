package desafios;

import java.util.Scanner;

public class ContaBancaria {
    public static void main(String[] args) {
        Scanner entrada=new Scanner(System.in);
        String nome="Nadson Jhony";
        double saldo=2500;

        System.out.printf("""
                *********************************************************************************
                Dados inicias do cliente
                
                
                nome:                                       %s
                Tipo conta:                                 Corrente
                Saldo inicial:                              %.2f
                *********************************************************************************
                """,nome,saldo);




        while(true){
            System.out.println("""
                
                
                Operações
                
                
                1 - Consultar saldos
                2 - Receber valor
                3 - Transferir valor
                4 - Sair
                
                digite a opçao desejada:
                """);
            int escolha=entrada.nextInt();
            if(escolha==1){
                System.out.println("O saldo é: "+saldo);
            }else if(escolha==2){
                System.out.println("Quanto você ira receber: ");
                double valor=entrada.nextDouble();
                saldo=saldo+valor;
            }else if(escolha==3){
                System.out.println("Quanto você ira tranferir: ");
                double valor=entrada.nextDouble();
                if(valor<=saldo){
                saldo=saldo-valor;}else{
                    System.out.println("Saldo insuficiente");
                }
            } else if (escolha==4) {
                System.out.println("Saindo ....");
                break;
            }else{
                System.out.println("Opção invalida");

            }

        }
    }
}
