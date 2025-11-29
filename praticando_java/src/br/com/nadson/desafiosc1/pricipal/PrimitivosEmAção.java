package br.com.nadson.desafiosc1.pricipal;

import br.com.nadson.desafiosc1.modelo.Notas;

public class PrimitivosEmAção {
    public static void main(String[] args) {
        Notas notas=new Notas( 7.5, 8.0 , 9.0);
        System.out.println("A media das notas é "+notas.getMedia());
    }
}
