package br.com.nadson.desafiosc9.modelo;

public class Reserva {

    public void reservar(){
        System.out.println("Reserva Realizada");
    }
    public void reservar(String data){
        System.out.println("Reserva feita para o dia: "+data);
    }

    public void reservar(String data, int pessoas){
        System.out.printf("Reserva feita para dia %s para %d pessoas",data,pessoas);
    }

}
