package desafios.list_e_colections.m3;

import desafios.orientacaoobjetos.java_oo_m3.Animal;

import java.util.ArrayList;
import java.util.List;

public class Principal {
    public static void main(String[] args) {
        List<String>textos=new ArrayList<>();
        textos.add("Ola mundo");
        textos.add("Como vai");
        textos.add("Vamos correr");
        textos.add("Quero comer");
        textos.add("Ta bom ja");
textos.forEach(item-> System.out.println(item));

        System.out.println("========================================================================");
Cachorro c=new Cachorro();
c.setNome("Max");

Animal c2=(Animal)c;

Animal a=new Cachorro();
        if (a instanceof Cachorro) {
Cachorro c1= (Cachorro) a;        }
        System.out.println("========================================================================");

Produto produto1=new Produto(3.2, "Caneta", 54);
Produto produto2=new Produto(22,"caderno",23);
Produto produto3=new Produto(57, "Sapato", 10);
Produto produto4=new Produto(150, "Mochila", 1);

List<Produto>produtos=new ArrayList<>();
produtos.add(produto1);
produtos.add(produto2);
produtos.add(produto3);
produtos.add(produto4);
double soma=0;
        for (int i = 0; i < produtos.size(); i++) {
            soma+=produtos.get(i).getTotal();

        }
        double media=soma/produtos.size();
        System.out.println(media);

    }

}
