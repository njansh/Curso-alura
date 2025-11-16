package desafios.java_oo_m4;

public class CalcucaldoraSalaRetangular implements CalculoGeometrico {
    private double perimetro,area;


    @Override
    public void calcularArea(double altura, double largura) {
        area=altura*largura;
        System.out.println("A area é "+area);
    }

    @Override
    public void calcularPerimetro(double altura, double largura) {
perimetro=2*(altura+largura);
        System.out.println("O perimetro é "+perimetro);
    }
}
