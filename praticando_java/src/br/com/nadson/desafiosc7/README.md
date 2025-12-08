# 📘 Praticando Java – Orientação a Objetos

**Pacote:** `desafiosc7`
Este módulo aprofunda os pilares da programação orientada a objetos com foco em modelagem, criação de classes, encapsulamento básico e organização de responsabilidades.

---

## 📚 Conteúdos trabalhados

### ✔ Criação de classes e objetos

* Declaração de classes
* Construtores
* Instanciação de objetos
* Estados internos (atributos)
* Comportamentos (métodos)

### ✔ Estrutura e responsabilidade das classes

* Definição clara de responsabilidades
* Métodos que alteram o estado interno
* Métodos que apenas consultam (getters)

### ✔ Encapsulamento inicial

* Controle sobre modificadores de acesso
* Uso de regras internas para validações (antes do aprofundamento no curso 8)

### ✔ Prática com cenários reais

Cada desafio simula um sistema isolado para fixação dos conceitos.

---

## 📂 Estrutura do pacote

```
desafiosc7/
 ├── modelo/        → Classes principais e regras de negócio
 └── principal/     → Classes executáveis (mains)
```

---

## 📝 Desafios Desenvolvidos

### ✔ Sistema de Controle de Estoque

* Cadastro de itens
* Remoção e baixa de estoque
* Regras de validação para evitar quantidades negativas
* Relatório detalhado do estado do estoque

### ✔ Empréstimo de Livros

* Registro de empréstimo
* Cálculo de atraso usando `LocalDate`
* Sistema de multa progressiva
* Exibição do status completo do empréstimo

### ✔ Outros exercícios menores

* Modelagem de classes simples
* Métodos com parâmetros
* Manipulação de atributos internos
* Impressão estruturada de informações

---

## ▶ Como executar

Acesse:

```
cd praticando_java/src/br/com/nadson/desafiosc7/principal
java NomeDaClassePrincipal
```

---

## 🎯 Objetivos do módulo

* Entender profundamente como classes representam entidades do mundo real
* Dominar a criação e utilização de métodos
* Evoluir no raciocínio orientado a objetos
* Aprender a organizar packages e responsabilidades
* Preparar terreno para o curso seguinte (encapsulamento)

--