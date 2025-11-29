package br.com.nadson.desafiosc1.modelo;

public class Temperatura {
    private int celsius;
    private double fahrenheit;


    public void fahrenheitParaCelsius(double fahrenheit) {
        this.fahrenheit=fahrenheit;

        celsius= (int) ((fahrenheit - 32) * 5.0 / 9.0);
    }
    public void celsiusParaFahrenheit(int celsius) {
       this.celsius=celsius;
        fahrenheit= celsius * 9.0 / 5.0 + 32;
    }


    public int getCelsius() {
        return celsius;
    }

    public double getFahrenheit() {
        return fahrenheit;
    }
}
