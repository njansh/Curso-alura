package br.com.nadson.screenmatch.cauculadora;

public class FiltroRecomendacao {

    public void filtro(Classificavel classificavel){
        if(classificavel.getClassificacao()>=4){
            System.out.println("Esta entre os preferidos da plataforma");
        }else if(classificavel.getClassificacao()>=2){
            System.out.println("esta na media");
        }else{
            System.out.println("Não são muito assistidos");
        }
    }
}
