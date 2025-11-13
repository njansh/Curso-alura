package desafios.java_oo_m1;

public class Carro {
    String modelo, cor;
    int anoDeLancamento;

    void fichaTecnica() {
        System.out.printf("O modelo do Carro é %s foi lançado em %d e tem cor %s", modelo, anoDeLancamento, cor);
    }

    double calcularAno(double ano) {
        return ano - anoDeLancamento;
    }
}
    class Pricipal2 {
        public static void main(String[] args) {
            Carro carro = new Carro();
            carro.modelo = "Ferrari";
            carro.cor = "Vermelha";
            carro.anoDeLancamento = 2009;
            carro.fichaTecnica();
            System.out.println(carro.calcularAno(2022));
        }
    }
