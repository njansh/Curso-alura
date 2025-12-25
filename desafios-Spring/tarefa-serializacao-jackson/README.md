
# 📋 Serialização e Desserialização com Jackson

## 📌 Descrição

Projeto desenvolvido como parte dos exercícios de **Java – Trabalhando com Serialização, Desserialização e Spring Framework (Alura)**.

O objetivo é praticar o uso da biblioteca **Jackson** para:

* **Serializar** um objeto Java em um arquivo JSON
* **Desserializar** um arquivo JSON, transformando-o novamente em um objeto Java

---

## 🎯 Objetivos do exercício

* Adicionar a dependência do **Jackson** ao projeto
* Criar a classe `Tarefa` com atributos e boas práticas
* Serializar um objeto `Tarefa` em um arquivo `tarefa.json`
* Ler o arquivo `tarefa.json` e transformá-lo novamente em um objeto
* Exibir o conteúdo do objeto desserializado no terminal

---

## 🧩 Classe principal do domínio

```java
public class Tarefa {
    private String descricao;
    private boolean concluida;
    private String pessoaResponsavel;

    // Construtor padrão
    // Construtores com parâmetros
    // Getters
    // toString()
}
```

> A presença do **construtor padrão** e dos **getters** é essencial para o correto funcionamento do Jackson.

---

## 🛠️ Tecnologias utilizadas

* Java
* Spring Boot
* Maven
* Jackson Databind
* Execução via linha de comando (`CommandLineRunner`)
* Manipulação de arquivos (`File`)

---

## 🔁 Funcionalidades implementadas

### ✅ Serialização

* Criação de um objeto `Tarefa`
* Conversão do objeto para JSON
* Escrita do JSON no arquivo `tarefa.json`

### ✅ Desserialização

* Leitura do arquivo `tarefa.json`
* Conversão do conteúdo para um objeto `Tarefa`
* Exibição dos dados no terminal

---

## ▶️ Como executar o projeto

### 1️⃣ Acessar a pasta do projeto

```bash
cd desafios-Spring/tarefa-serializacao-jackson
```

### 2️⃣ Executar a aplicação

```bash
mvn spring-boot:run
```

### 3️⃣ Resultado esperado

* Um arquivo `tarefa.json` será criado no diretório do projeto
* O conteúdo do objeto desserializado será exibido no terminal

---

## 📂 Estrutura do projeto

```text
tarefa-serializacao-jackson/
├── src/
│   └── main/
│       ├── java/
│       │   └── br/com/nadson/
│       └── resources/
├── pom.xml
└── README.md
```

---

## 📚 Finalidade educacional

Projeto com finalidade **exclusivamente educacional**, voltado para:

* Compreensão de serialização e desserialização
* Uso prático da biblioteca Jackson
* Manipulação de arquivos em Java
* Consolidação do uso do Spring Boot fora do contexto web

---

## ✍️ Autor

Projeto desenvolvido por **Nadson Jhony**, durante os estudos na plataforma **Alura**.

---