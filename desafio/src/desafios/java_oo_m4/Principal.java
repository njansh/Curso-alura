package desafios.java_oo_m4;

import desafios.java_oo_m1.Calculadora;

public class Principal{
    public static void main(String[] args) {
        //--------------------convertendo moedas-----------------
        System.out.println("        //--------------------convertendo moedas-----------------\n");
        ConversorMoeda conveter=new ConversorMoeda();
        conveter.converterDolarParaReal(55);

        //--------------------Calculando area e perimetro-----------------
        System.out.println(" //--------------------Calculando area e perimetro-----------------");

        CalcucaldoraSalaRetangular cg=new CalcucaldoraSalaRetangular  () ;
        cg.calcularArea(33, 21);
    cg.calcularPerimetro(33,21);

        //--------------------------Tabuada------------------------
        System.out.println("        //--------------------------Tabuada------------------------\n");
TabuadaMultiplicacao t=new TabuadaMultiplicacao();
t.mostrarTabuada(3);

//--------------------------Convertendo temperatura------------------------
        System.out.println("        //--------------------------Convertendo temperatura------------------------\n");
ConversorTemperaturaPadrao ct=new ConversorTemperaturaPadrao();
ct.celsiusParaFahrenheit(44);
ct.fahrenheitParaCelsius(55);
    }

}
