package br.com.nadson.screeanmatch.enums;

public enum Categoria {
    ACAO("Action", "Ação"),
    ROMANCE("Romance", "Romance"),
    COMEDIA("Comedy", "Comédia"),
    DRAMA("Drama", "Drama"),
    CRIME("Crime", "Crime"),
    TERROR("Horror", "Terror"),
    ANIMACAO("Animation", "Animação"),
    AVENTURA("Adventure", "Aventura"),
    FANTASIA("Fantasy", "Fantasia"),
    SUSPENSE("Thriller", "Suspense"),
    DESCONHECIDO("Unknown", "Desconhecido");

    private String categoriaOmdb;
    private String categoriaPortugues;

    Categoria(String categoriaOmdb, String categoriaPortugues) {
        this.categoriaOmdb = categoriaOmdb;
        this.categoriaPortugues = categoriaPortugues;
    }

    public String getCategoriaPortugues() {
        return categoriaPortugues;
    }

    public static Categoria fromString(String text) {
        if (text == null || text.isBlank()) {
            return DESCONHECIDO;
        }
        String firstCategory = text.split(",")[0].trim();
        for (Categoria categoria : Categoria.values()) {
            if (categoria.categoriaOmdb.equalsIgnoreCase(firstCategory)) {
                return categoria;
            }
            if (categoria.categoriaPortugues.equalsIgnoreCase(firstCategory)) {
                return categoria;
            }
        }
        System.out.println("Categoria não encontrada: " + firstCategory);
        return DESCONHECIDO;
    }
}
