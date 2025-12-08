# Formação Praticando Java — Resumo Completo

Este repositório reúne todos os cursos e exercícios da formação **Praticando Java** da Alura. Cada pacote segue o padrão `br.com.nadson.desafioscX`, onde **X** representa o curso da formação. Dentro de cada pacote, há desafios que praticam conceitos apresentados nos cursos.

---

## Objetivo do Repositório

Consolidar o aprendizado dos cursos da formação por meio de:

- Implementação de conceitos fundamentais de programação
- Exercícios orientados a objetos
- Manipulação de coleções
- Estruturas de decisão e repetição
- Validações de dados e regras de negócio
- Uso de datas (`LocalDate`), enums e listas
- Simulações de cenários reais (estoque, conta bancária, bateria, filmes, login etc.)

---

## Estrutura Geral do Repositório

```
praticando_java/
└── br/com/nadson/
    ├── desafiosc4/       # Curso 4 — Validação e Entrada de Dados
    ├── desafiosc6/       # Curso 6 — Coleções e Streams
    ├── desafiosc7/       # Curso 7 — Regras de Negócio e Objetos
    ├── desafiosc8/       # Curso 8 — Sistemas Simples com Lógica de Negócio
    └── ...
```

Cada pasta `desafioscX` contém:

- **modelo/** → classes principais  
- **principal/** → classes de execução/testes  
- Exercícios independentes, cada um com regras próprias

---

## Resumo dos Cursos

| Curso | Conteúdo Principal | Exemplos de Desafios | Link do README |
|-------|------------------|--------------------|----------------|
| Curso 4 | Validação e entrada de dados | Senhas com Regex, If/Else, Scanner | README Curso 4 |
| Curso 6 | Coleções e Streams | Manipulação de listas, remoção, redução, soma | README Curso 6 |
| Curso 7 | Regras de negócio e objetos | Estoque, Empréstimos de livros, Aluno com médias | README Curso 7 |
| Curso 8 — Encapsulamento | Lógica de Negócio, classes encapsuladas | Bateria, Conta Bancária, Avaliação de Filmes, Login, Sistema de Pontos | README Curso 8 |

---

## Como Executar os Exercícios

1. Clone o repositório:

```
git clone https://github.com/njansh/Curso-alura.git
```

2. Abra em uma IDE Java.

3. Acesse:

```
praticando_java/src/br/com/nadson/desafioscX/principal/
```

4. Execute qualquer classe com método `main`.

---

## Melhorias Futuras

- Criar READMEs individuais detalhados para cada pacote/curso  
- Adicionar testes unitários  
- Criar documentação JavaDoc  
- Organizar os cursos em módulos Maven ou Gradle para facilitar execução
