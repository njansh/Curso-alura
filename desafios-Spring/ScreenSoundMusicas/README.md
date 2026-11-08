![thumbnail-Desafio Java](https://github.com/jacqueline-oliveira/3355-java-desafio/assets/66698429/4b068d55-5cfc-480c-b94f-7d48b3c91eb3)

# ScreenSound Músicas 🎵

Este projeto foi desenvolvido como solução para o desafio de persistência de dados do curso de **Java e Spring Data JPA** da Alura. O objetivo principal é gerenciar um catálogo de artistas e suas respectivas músicas em um banco de dados relacional, utilizando uma interface interativa via console.

Embora o desafio sugerisse o cadastro manual e o uso do ChatGPT, **este projeto foi além** e implementou automações reais utilizando a **API da Deezer** e a **API da Wikipédia**, tornando a aplicação mais robusta, profissional e 100% gratuita para rodar.

## 🚀 O que foi desenvolvido (Funcionalidades)

- **Menu Interativo via CLI:** Interface de linha de comando operando via `CommandLineRunner` para gerenciar as opções do sistema.
- **Modelagem Relacional (JPA/Hibernate):** Relacionamento bidirecional (`@OneToMany` e `@ManyToOne`) entre as entidades `Artista` e `Musica`, garantindo que uma música só seja salva vinculada a um artista existente.
- **Categorização com Enum:** Artistas classificados automaticamente como `SOLO`, `DUPLA` ou `GRUPO`.
- **Integração com API da Deezer (Extra):** O cadastro de músicas não é feito manualmente. O sistema faz uma busca inteligente (*Fuzzy Search*) na API da Deezer, retorna um "Top 5" para o usuário escolher e extrai automaticamente dados oficiais como duração, álbum, link de reprodução e foto de perfil do artista.
- **Cadastro em Lote (Extra):** Opção exclusiva para ler uma lista de músicas e artistas de uma só vez, pesquisando e persistindo todos no banco em sequência.
- **Integração com API da Wikipédia (Alternativa Inteligente):** Em vez de usar a API paga do ChatGPT, o projeto consome o endpoint oficial da Wikipédia (enviando um `User-Agent` customizado de forma segura) para resgatar e exibir o resumo biográfico dos artistas em português.

## 🛠️ Tecnologias Utilizadas

- **Java 17**
- **Spring Boot** (4.0.1)
- **Spring Data JPA / Hibernate**
- **PostgreSQL** (Banco de dados relacional)
- **Jackson** (Desserialização de JSON via DTOs - *Records*)
- **Java HttpClient** (Consumo de APIs externas HTTP nativo)

## 🗂️ Estrutura do Banco de Dados

O projeto utiliza `CascadeType.ALL` para gerenciar o salvamento em cascata e *Derived Queries* (ex: `findByArtistaNameContainingIgnoreCase`) para evitar duplicações e facilitar a busca de músicas por artistas diretamente no repositório.

## 💻 Como executar o projeto

1. Clone este repositório.
2. Certifique-se de ter o **PostgreSQL** instalado e rodando na porta padrão (`5432`).
3. Crie um banco de dados chamado `screensound`.
4. Configure as variáveis de ambiente `DB_USER` e `DB_PASSWORD` na sua IDE ou substitua os valores no arquivo `application.properties`.
5. Execute a classe `ScreenSoundMusicasApplication`.
6. Interaja com o menu diretamente no console da sua IDE!