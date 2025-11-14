package br.com.nadson.screenmatch.cauculadora;


import br.com.nadson.screenmatch.modelo.Titulo;

public class CalcularTempo {
    int tempoTotal;

    public int getTempoTotal() {
        return tempoTotal;
    }

    public void inclui(Titulo t){
       tempoTotal+= t.getDuracaoEmMinutos();
    }
}
