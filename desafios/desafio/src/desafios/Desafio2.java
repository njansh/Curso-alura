package desafios;

import javax.swing.*;
import java.util.Scanner;

public class Desafio2 {
    public static void main(String[] args) {
        Scanner entrada= new Scanner(System.in);
int numero1=0;
        /*System.out.println("Digite um numero");
         numero1=entrada.nextInt();
        if(numero1 %2==0){
            System.out.println("numero Par");
        }else{
            System.out.println("numero impar");
        }*/
/*
        System.out.println("digite o primero numero");
        numero1=entrada.nextInt();
        System.out.print("Digite o segundo numero");
        int numero2=entrada.nextInt();

        if (numero1==numero2){
            System.out.println("os numeros são iguais");
        }else if (numero1<numero2){
            System.out.println("o numero1 é menor que o numero dois");
        }else {
            System.out.println("o numero 1 é maior que o numero 2");
        }
*/
/*
        System.out.println("""
              digite um se quiser calcular a area do quadrado 
              digite dois se quiser calcular a area do circulo
              """);
        int opcao=entrada.nextInt();

        if(opcao==1){
            System.out.println("calculando area do quadrado");
        }else{
            System.out.println("Calculando a area do circulo");
        }

*/
        System.out.println("Digite um numero");
        numero1=entrada.nextInt();
/*
        String tabuada= String.format("""
                TABUADA DE %d
                %d *1 =%d
                %d *2 =%d
                %d *3 =%d
                %d *4 =%d
                %d *5 =%d
                %d *6 =%d
                %d *7 =%d
                %d *8 =%d
                %d *9 =%d
                %d *10 =%d
                
                """,numero1,numero1,(numero1*1),numero1,(numero1*2),numero1,(numero1*3),numero1,
                (numero1*4),numero1,(numero1*5),numero1,(numero1*6),numero1,(numero1*7),numero1,(numero1*8),
                numero1,(numero1*9),numero1,(numero1*10));

        System.out.println(tabuada);

        //////////////// MANEIRA MAIS SIMPLES DE FAZERF
        import java.util.Scanner;

public class Tabuada {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número: ");
        int numero = scanner.nextInt();

        System.out.println("Tabuada do " + numero + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(numero + " x " + i + " = " + (numero * i));
        }
    }
}
 */
//////

        int fatorial=1;
        for (int i = 1; i <numero1 ; i++) {
           fatorial= fatorial*i;

        }
        System.out.println("o fatoria de "+numero1+" é "+fatorial);



}}
