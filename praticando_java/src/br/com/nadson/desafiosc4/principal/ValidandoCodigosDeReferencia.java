package br.com.nadson.desafiosc4.principal;

import br.com.nadson.desafiosc4.modelo.ValidadorCodigoReferencia;

import java.util.Scanner;

public class ValidandoCodigosDeReferencia {
        public static void main(String[] args) {


            try (Scanner entrada = new Scanner(System.in)) {
                while(true){
                System.out.print("Digite o código de referência: ");
                String codigo = entrada.nextLine().trim();
                if (codigo.equalsIgnoreCase("fim")){
                    System.out.println("Finalizando programa...");
                    break;
                }

                String resultado = ValidadorCodigoReferencia.validarCodigo(codigo);

                if (resultado.equals("VÁLIDO")) {
                    System.out.println("O código de referência está válido.");
                } else {
                    System.out.println(resultado);
                }
            }}
        }
    }


