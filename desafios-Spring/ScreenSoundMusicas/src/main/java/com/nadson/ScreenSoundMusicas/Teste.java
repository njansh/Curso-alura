package com.nadson.ScreenSoundMusicas;

import com.nadson.ScreenSoundMusicas.domain.Artista;
import com.nadson.ScreenSoundMusicas.domain.Musica;
import com.nadson.ScreenSoundMusicas.enums.TipoArtista;

public class Teste {

    public static void main(String[] args) {
        // 1. Criar o Artista
        Artista cidadeNegra = new Artista();
        cidadeNegra.setName("Cidade Negra");
        cidadeNegra.setTipo(TipoArtista.GRUPO);
        cidadeNegra.setImagem("https://link-da-imagem.jpg");

        // 2. Criar a Música
        Musica girassol = new Musica();
        girassol.setTitulo("Girassol (Acústico)");
        girassol.setAlbum("Acústico Cidade Negra");
        girassol.setDuracaoS(249);
        girassol.setLink("https://www.deezer.com/track/137275198");

        // 3. Vincular os dois lados da relação
        cidadeNegra.adicionarMusica(girassol);

        // 4. Testar a impressão com os toString()
        System.out.println("--- Teste do Artista ---");
        System.out.println(cidadeNegra);

        System.out.println("\n--- Teste da Música ---");
        System.out.println(girassol);

        System.out.println("\n--- Músicas na lista do Artista ---");
        cidadeNegra.getMusicas().forEach(m -> System.out.println("- " + m.getTitulo()));
    }
}