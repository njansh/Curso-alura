package br.com.nadson.desafiosc3.principal;

public class SomaDeNumeros {
    public static void main(String[] args) {
        int[] numeros ={10, 20, 30, 40, 50};;
        int soma = 0;
    for (int i = 0; i < numeros.length; i++){
        soma += numeros[i];
    }
        System.out.println("A soma dos valores é "+soma);
    }
}
