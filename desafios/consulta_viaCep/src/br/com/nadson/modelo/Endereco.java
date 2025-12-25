package br.com.nadson.modelo;



public record Endereco(String cep, String logradouro, String complemento, String bairro, String localidade, String uf) {
    @Override
    public String toString() {
        return String.format(
                "CEP: %s, Logradouro: %s, Complemento: %s, Bairro: %s, Cidade: %s, UF: %s",
                cep, logradouro, complemento, bairro, localidade, uf
        );
    }
}
