package desafios.list_e_colections.m2;

import java.util.ArrayList;
import java.util.List;

public class Pricipal {
    public static void main(String[] args) {
        Produto caneta=new Produto("Caderno", 25.6, 12);
        caneta.setNome("Caneta");
        caneta.setPreco(3.5);
        caneta.setQuantidade(12);

 Produto notbook=new Produto("Caderno", 25.6, 12);
        notbook.setNome("Notbook");
        notbook.setPreco(7000);
        notbook.setQuantidade(4);

 Produto geladeira =new Produto("Caderno", 25.6, 12);
        geladeira.setNome("Geladeita");
        geladeira.setPreco(3500.67);
        geladeira.setQuantidade(7);

        List<Produto> produtos=new ArrayList<>();
        produtos.add(caneta);
        produtos.add(geladeira);
        produtos.add(notbook);

        System.out.println(produtos.size());
        System.out.println(produtos.get(1));

        for (int i = 0; i <produtos.size() ; i++) {
            System.out.println(produtos.get(i));
        }

        Produto caderno=new Produto("Caderno",25.6,12);
        Produto armario=new Produto("Armario",2000.54,3);

        produtos.add(caderno);
    produtos.add(armario);
        System.out.println(produtos.get(3));

    ProdutoPerecivel arroz=new ProdutoPerecivel("Arroz", 6.7, 30, "24/03/2026");

        System.out.println(arroz); }
}
