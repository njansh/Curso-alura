# 📘 Praticando Java – Coleções e Streams

**Pacote:** `desafiosc6`
Este módulo aprofunda o uso de listas, coleções e operações funcionais com *Java Streams*, aplicando transformações, filtros e cálculos de forma elegante e eficiente.

---

## 📚 Conteúdos trabalhados

### ✔ Coleções Java

* `List`
* `ArrayList`
* `LinkedList`
* Iteração tradicional e com *for-each*
* Métodos fundamentais:

  * `add()`, `remove()`, `contains()`
  * `sort()`, `size()`, `get()`

### ✔ Introdução a *Streams*

* `stream()` e `parallelStream()`
* `filter()`
* `map()`
* `sorted()`
* `reduce()`
* `collect()`

### ✔ Operações comuns praticadas

* Soma de valores
* Filtragem de elementos por regra
* Remoção de elementos específicos
* Ordenação alfabética e numérica
* Cálculo de totais com `reduce`
* Uso de expressões lambda

---

## 📂 Estrutura do pacote

```
desafiosc6/
 └── principal/     → Classes executáveis (mains)
```

> De acordo com seu repositório atual, este módulo também não possui pasta `modelo`.

---

## 📝 Desafios Desenvolvidos

### ✔ Remoção de Elementos

Manipulação de listas com exclusões condicionais, removendo entradas específicas como nomes duplicados ou indesejados.

### ✔ Ordenação de Listas

Uso de `Comparator`, `sorted()` e ordenação natural de elementos.

### ✔ Cálculo de Totais com `reduce`

Exemplo: somar preços, somar notas, somar valores inteiros.

### ✔ Filtragem e Mapeamento

Filtrar elementos dentro de uma lista e gerar listas transformadas com `map`.

### ✔ Streams em cascata

Combinação de múltiplas operações para processar dados de forma declarativa.

---

## ▶ Como executar

Acesse a pasta:

```
cd praticando_java/src/br/com/nadson/desafiosc6/principal
java NomeDaClassePrincipal
```

---

## 🧩 Objetivos do módulo

* Entender o funcionamento interno das coleções em Java
* Utilizar listas para armazenar dados dinamicamente
* Aplicar a API de *Streams* para processar coleções com menos código e maior expressividade
* Exercitar boas práticas com lambdas e programação funcional

---