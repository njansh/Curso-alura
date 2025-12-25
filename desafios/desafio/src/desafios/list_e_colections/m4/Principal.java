package desafios.list_e_colections.m4;

import java.sql.Array;
import java.util.*;

public class Principal {
    public static void main(String[] args) {
        List<Titulo> nomes;
        List<Integer>numeros=new ArrayList<>(Arrays.asList(1,5,4,3,5,7,8,2,4,5,8,0));
        Collections.sort(numeros);
        System.out.println(numeros);
        System.out.println("////////////////////////////////////////////////////////////////////");
    Titulo ana =new Titulo("Ana");
    Titulo pedro=new Titulo("Pedro");
    Titulo joana=new Titulo("Joana");
    Titulo matheus=new Titulo("Matheus");
    Titulo maria=new Titulo("Maria");
    Titulo lucas =new Titulo("Lucas");

  nomes=new ArrayList<>(Arrays.asList(ana,pedro,joana,matheus,maria,lucas));

        Collections.sort(nomes);
    for (Titulo titulo:nomes) {


        System.out.println(titulo.getNome());
    }

        System.out.println("///////////////////////////////");
        nomes=new LinkedList<>(Arrays.asList(ana,pedro,joana,matheus,maria,lucas));
        Collections.sort(nomes);
        System.out.println("ArraysList :");

        for (Titulo titulo:nomes) {

            System.out.println(titulo.getNome());
        }
        System.out.println("LinkedList:");
        for (Titulo titulo:nomes) {

            System.out.println(titulo.getNome());
        }

    }

}
