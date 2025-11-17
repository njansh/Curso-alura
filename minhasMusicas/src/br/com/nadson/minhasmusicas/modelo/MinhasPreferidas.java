package br.com.nadson.minhasmusicas.modelo;

public class MinhasPreferidas {
    public void incluir(Audio audio){
        if(audio.getClassificacao()>8){
            System.out.println(audio.getTitulo()+" Estar nos gostos de todo mundo");

        }else {
            System.out.println(audio.getTitulo()+" Não é tao bom mas da pra curtir ");
        }
    }
}
