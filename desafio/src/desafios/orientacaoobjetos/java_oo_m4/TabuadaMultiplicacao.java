package desafios.orientacaoobjetos.java_oo_m4;

public class TabuadaMultiplicacao implements Tabuada {

    @Override
    public void mostrarTabuada(double valor) {
        for (int i = 1; i < 11; i++) {
            System.out.println(valor+"x "+i+"= "+(valor*i));

        }
    }
}
