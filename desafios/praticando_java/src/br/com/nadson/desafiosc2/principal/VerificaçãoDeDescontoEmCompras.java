package br.com.nadson.desafiosc2.principal;

import java.util.Scanner;

public class VerificaçãoDeDescontoEmCompras {
    public static void main(String[] args) {

        Scanner entrada= new Scanner(System.in);
        System.out.println("Digite o valor da compra:");
        double valor= entrada.nextDouble();
        double desconto=valor*0.10;
        if(valor>=100){
            double novo=valor-desconto;
            System.out.println("Desconto de 10% aplicado\n novo valor:"+novo);
        }else{
            System.out.println("nenhum desconto aplicado\nvalor do produto:"+valor);
        }

        entrada.close();
    }
}
