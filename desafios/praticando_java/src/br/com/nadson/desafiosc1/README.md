
# Praticando Java — Encapsulamento

**Pacote:** `desafiosc8`
Este módulo aprofunda o uso de **encapsulamento**, controle de acesso, validação interna de estado e construção de classes robustas com regras de negócio claras.

---

## Conteúdos Trabalhados

### Encapsulamento e Modificadores de Acesso

* Atributos privados para proteção do estado.
* Métodos de acesso (`get`) e modificação (`set`) com validações.
* Regras de negócio implementadas dentro das próprias classes.
* Ocultação da complexidade interna.

### Boas Práticas de Modelagem

* Coesão e responsabilidade única.
* Evitar estados inválidos.
* Métodos que preservam a integridade dos dados.
* Separação clara entre **modelo** e **execução**.

### Enumerações (`enum`)

* Representação de valores fixos: níveis, estados, categorias etc.
* Mapeamento simples e seguro para regras de negócio.

---

## Estrutura do Pacote

```
desafiosc8/
 ├── modelo/        → classes encapsuladas e enums
 └── principal/     → classes com métodos main para testes
```

---

## Desafios Desenvolvidos

### 1. Controle de Bateria com Enum

* Classe `Bateria` com valor entre 0 e 100.
* Métodos `carregar()` e `consumir()` com validação.
* Enum `NivelCarga` definindo níveis: BAIXO, MÉDIO, ALTO.
* Prevenção de valores inválidos.

### 2. Conta Bancária

* Classe `Conta` com saldo privado.
* Métodos `depositar()` e `sacar()`.
* Bloqueio de operações incorretas.
* Exibição formatada do saldo.

### 3. Avaliação de Filmes

* Classe `Filme` com lista de notas.
* Validação de notas (0 a 5).
* Média automática.
* Listas e operações com streams (quando aplicável).

### 4. Sistema de Pontos para Alunos

* Classe `Aluno` controlando pontos do aluno.
* Ganho e perda de pontos com limite mínimo.
* Exibição de status com regras internas.

### 5. Gerenciamento de Notas de Disciplina

* Classe `Disciplina` com notas válidas e inválidas.
* Cálculo de média apenas das válidas.
* Registro automático das notas inválidas.
* Relatório completo da disciplina.

---

## Como Executar

1. Acesse:

```
praticando_java/src/br/com/nadson/desafiosc8/principal
```

2. Execute a classe que deseja testar:

```
java NomeDaClassePrincipal
```

---

## Objetivos do Módulo

* Criar classes seguras, evitando estados inválidos.
* Praticar encapsulamento com regras internas.
* Trabalhar enums como parte da modelagem.
* Estruturar responsabilidades dentro das próprias classes.
* Preparar base sólida para herança e polimorfismo (curso 9).

---
