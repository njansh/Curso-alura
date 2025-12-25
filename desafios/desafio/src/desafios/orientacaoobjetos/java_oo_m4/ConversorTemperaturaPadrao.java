package desafios.orientacaoobjetos.java_oo_m4;

public class ConversorTemperaturaPadrao implements ConversorTemperatua{
    private double celsius,fahrenheit;

    @Override
    public void celsiusParaFahrenheit(double celsius) {
        celsius= (celsius * 9 / 5) + 32;
        System.out.println("Temperatura é "+celsius+" Cº");

    }

    @Override
    public void fahrenheitParaCelsius(double fahrenheit) {
        fahrenheit= (fahrenheit - 32) * 5 / 9;
        System.out.println("Temperatura é "+fahrenheit+" Fº");

    }
}
