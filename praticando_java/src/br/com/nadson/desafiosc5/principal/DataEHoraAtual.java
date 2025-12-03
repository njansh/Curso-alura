package br.com.nadson.desafiosc5.principal;

import java.time.LocalDate;
import java.time.LocalTime;

public class DataEHoraAtual {
    public static void main(String[] args) {
        String tarefa="Enviar relatorio semanal";
        LocalDate data=LocalDate.now();
        LocalTime hora=LocalTime.now();
        System.out.println("Tarefa: "+tarefa);
        System.out.println("Data atual: "+data);
        System.out.println("Hora atual: "+hora);
          }
}
