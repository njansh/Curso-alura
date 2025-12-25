package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Midia;

import java.util.List;

public class GerenciamentoDeBiblioteca {
    public static void main(String[] args) {
        List<Midia>midias=List.of(
                new br.com.nadson.desafiosc9.modelo.Livro("O Senhor dos Aneis",1954,"J.R.R. Tolkien"),
                new br.com.nadson.desafiosc9.modelo.EBook("Clean Code",2008,"PDF"),
                new br.com.nadson.desafiosc9.modelo.Revista("National Geographic",2021,150)
        );
        for (Midia midia: midias){
           midia.exibirInfo();
        }
    }


}
