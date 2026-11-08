package com.nadson.ScreenSoundMusicas.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id ;
    @Column
    private String titulo;
    @Column
    private Integer duracaoS;
    @Column
    private String album;
    @Column
    private String link;
    @ManyToOne @JoinColumn(name="artista_id")
    private Artista artista;

    public Musica() {
    }

    public Musica(String titulo, Integer duracaoS, String album, String link, Artista artista) {
        this.titulo = titulo;
        this.duracaoS = duracaoS;
        this.album = album;
        this.link = link;
        this.artista = artista;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getDuracaoS() {
        return duracaoS;
    }

    public void setDuracaoS(Integer duracaoS) {
        this.duracaoS = duracaoS;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Música: '" + titulo + '\'' +
                " | Álbum: '" + (album != null ? album : "N/A") + '\'' +
                " | Duração: " + (duracaoS != null ? duracaoS + "s" : "N/A") +
                " | Artista: " + (artista != null ? artista.getName() : "Sem artista") +
                " | Link: " + (link != null ? link : "N/A");
    }
}
