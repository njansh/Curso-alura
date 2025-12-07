# Praticando Java -- Formação Alura

Este diretório faz parte da formação Java da Alura e reúne uma coleção
de pacotes contendo exercícios, desafios e pequenos projetos
desenvolvidos ao longo dos cursos. Cada *package* segue o padrão
`br.com.nadson.desafioscX`, onde **"X" representa o curso da formação**.
Dentro de cada pacote, há desafios que praticam os conceitos
apresentados na trilha.

------------------------------------------------------------------------

## Objetivo do Repositório

Consolidar o aprendizado dos cursos da formação Java por meio de:

-   Implementação de conceitos fundamentais de programação.
-   Exercícios orientados a objetos.
-   Manipulação de coleções.
-   Estruturas de decisão e repetição.
-   Prática com datas (`LocalDate`), enums e validações.
-   Simulações de cenários reais (estoque, conta bancária, bateria,
    filmes etc.).

Cada desafio reforça um tema específico, evoluindo a complexidade
gradualmente.

------------------------------------------------------------------------

## Estrutura Geral

    praticando_java/
    └── br/com/nadson/
        ├── desafiosc4/
        ├── desafiosc6/
        ├── desafiosc7/
        ├── desafiosc8/
        └── ...

### `desafioscX`

Cada pasta representa um curso da formação.\
Dentro de cada uma há:

-   **modelo/** → classes principais\
-   **principal/** → classes de execução/testes\
-   Desafios independentes, cada um com regras próprias

------------------------------------------------------------------------

## Exemplos de Desafios

### 1. Controle de Estoque (desafiosc7)

-   Classe `Estoque`
-   Validação de quantidades\
-   Processamento de venda\
-   Exibição detalhada de operações

### 2. Empréstimo de Livros com Multa (desafiosc7)

-   Classe `EmprestimoDeLivro`
-   Uso de `LocalDate`
-   Cálculo de dias em atraso\
-   Multa progressiva

### 3. Bateria (desafiosc8)

-   Classe `Bateria` com enum `NivelCarga`
-   Limites de carga (0 a 100)
-   Validação de entradas
-   Indicador de nível (BAIXO, MÉDIO, ALTO)

### 4. Avaliação de Filmes (desafiosc8)

-   Classe `Filme`
-   Lista de notas de 0 a 5\
-   Média automática\
-   Streams para cálculo

### 5. Conta Bancária (desafiosc8)

-   Classe `Conta`
-   Depósitos, saques e validações
-   Saldo formatado

------------------------------------------------------------------------

## Como Executar

1.  Clone o repositório:

```{=html}
<!-- -->
```
    git clone https://github.com/njansh/Curso-alura.git

2.  Abra em uma IDE Java.

3.  Acesse:

```{=html}
<!-- -->
```
    praticando_java/src/br/com/nadson/desafioscX/principal/

4.  Execute qualquer classe com método `main`.

------------------------------------------------------------------------

## Melhorias Futuras

-   Criar READMEs individuais para cada pacote.
-   Adicionar testes unitários.
-   Criar documentação JavaDoc.
-   Organizar em módulos Maven/Gradle.

------------------------------------------------------------------------
