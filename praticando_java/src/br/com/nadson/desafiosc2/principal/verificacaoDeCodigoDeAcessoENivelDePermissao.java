package br.com.nadson.desafiosc2.principal;

import br.com.nadson.desafiosc2.modelo.SistemaAcesso;

import java.util.Scanner;

public class verificacaoDeCodigoDeAcessoENivelDePermissao  {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o código de acesso: ");
        int codigo = entrada.nextInt();

        System.out.print("Digite o nível de permissão: ");
        int nivel = entrada.nextInt();

        SistemaAcesso acesso = new SistemaAcesso(codigo, nivel);

        System.out.println(acesso.verificarAcesso());

        entrada.close();
    }}
