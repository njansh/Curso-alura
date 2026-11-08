package com.nadson.ScreenSoundMusicas.domain;

import com.nadson.ScreenSoundMusicas.enums.TipoArtista;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.ALL;

@Entity
@Table(name="artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Enumerated(EnumType.STRING)
    private TipoArtista tipo;
    @Column
    private String imagem;
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Musica> musicas = new ArrayList<>();

    public Artista() {
    }

    public Artista(String name, TipoArtista tipo, String imagem, List<Musica> musicas) {
        this.name = name;
        this.tipo = tipo;
        this.imagem = imagem;
        this.musicas = (musicas != null) ? musicas : new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TipoArtista getTipo() {
        return tipo;
    }

    public void setTipo(TipoArtista tipo) {
        this.tipo = tipo;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void adicionarMusica(Musica musica) {
        if (this.musicas == null) {
            this.musicas = new ArrayList<>();
        }
        this.musicas.add(musica);
        musica.setArtista(this);
    }
    @Override
    public String toString() {
        return "Artista: '" + name + '\'' +
                " | Tipo: " + tipo +
                " | Total de Músicas: " + (musicas != null ? musicas.size() : 0);
    }
}
