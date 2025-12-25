package desafios.orientacaoobjetos.java_oo_m2;

public class Produto {
private double preco;
private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double desconto(double desconto){
    return    preco=preco*(desconto/100);
    }
}

class Pricipal1{
    public static void main(String[] args) {
        Produto p=new Produto();
        p.setNome("Caneta");
        p.setPreco(12);
        p.desconto(50);
        System.out.println(p.getPreco());
    }
}
