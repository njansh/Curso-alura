package desafios.orientacaoobjetos.java_oo_m3;

public class Carro {
    private String modelo;
    private double precoAno1, precoAno2, precoAno3;

    public void definirModelo(String modelo) {
        this.modelo = modelo;
    }

    public void definirPrecos(double ano1,double ano2,double ano3){
        this.precoAno1 =ano1;
        this.precoAno2 =ano3;
        this.precoAno3 =ano2;
    }

    public void exibirInfo() {
        System.out.println("Modelo: " + modelo);
        System.out.println("Preço Ano 1: " + precoAno1);
        System.out.println("Preço Ano 2: " + precoAno2);
        System.out.println("Preço Ano 3: " + precoAno3);
        System.out.println("Menor Preço: " + calcularMenorPreco());
        System.out.println("Maior Preço: " + calcularMaiorPreco());
    }

    public double calcularMenorPreco() {
        double menorPreco=precoAno1;
        if(menorPreco>precoAno2){
            menorPreco=precoAno2;
        }else if(menorPreco>precoAno3){
            menorPreco=precoAno3;
        }
        return menorPreco;
    }public double calcularMaiorPreco() {
        double maiorPreco=precoAno1;
        if(maiorPreco<precoAno2){
            maiorPreco=precoAno2;
        }else if(maiorPreco<precoAno3){
            maiorPreco=precoAno3;
        }
        return maiorPreco;
    }




}

class ModeloCarro extends Carro{

}
class Principal{
    public static void main(String[] args) {
        ModeloCarro modeloCarro
                =new ModeloCarro();
        modeloCarro.definirModelo("Macerati");
        modeloCarro.definirPrecos(40000, 50000,80000);
        modeloCarro.exibirInfo();

    }
}