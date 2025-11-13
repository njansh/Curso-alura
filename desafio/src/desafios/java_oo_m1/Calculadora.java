package desafios.java_oo_m1;

public class Calculadora {
    public static void main(String[] args) {
        Calculadora calculadora=new Calculadora();
        System.out.println(calculadora.dobrar(2));
    }

           double dobrar(double numero){
            return numero*2;
        }

}
