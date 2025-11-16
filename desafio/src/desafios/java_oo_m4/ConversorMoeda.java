package desafios.java_oo_m4;

public class ConversorMoeda implements ConversaoFinanceira{

    private  double cotacao=5;
  private double real;



    @Override
    public void converterDolarParaReal(double dolar) {
         real+=dolar*cotacao;
        System.out.println("convertendo "+dolar+" dolares em reais da "+real+" Reais  ");
    }
}

