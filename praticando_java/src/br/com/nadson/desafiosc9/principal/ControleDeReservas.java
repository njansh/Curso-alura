package br.com.nadson.desafiosc9.principal;

import br.com.nadson.desafiosc9.modelo.Reserva;
import br.com.nadson.desafiosc9.modelo.ReservaVip;

public class ControleDeReservas {
    public static void main(String[] args) {
        Reserva reserva= new Reserva();
        reserva.reservar();
        reserva.reservar("12/12/2024");
reserva.reservar("12/12/2024", 2);

Reserva vip=new ReservaVip();
        System.out.println("-----------------");
vip.reservar();



    }
}
