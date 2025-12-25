# \# Desafios C8 — Sistemas Simples com Lógica de Negócio

# 

# Este pacote possui sistemas independentes simulando cenários reais como controle bancário, bateria, avaliação de filmes, login e sistema de pontos para alunos. Cada sistema é desenvolvido com foco em \*\*orientação a objetos, validação de dados e regras de negócio\*\*.

# 

# ---

# 

# \## Conteúdos Abordados

# \- Classes orientadas a objetos com responsabilidades claras

# \- Uso de getters e setters para encapsulamento

# \- Regras para depósito e saque

# \- Enumerações (níveis de bateria e níveis de alunos)

# \- Validação de notas e cálculo de média

# \- Limites de entrada de dados (valores negativos, máximo permitido)

# \- Listas para armazenar múltiplos valores (notas, produtos, pontos)

# 

# ---

# 

# \## Exemplos de Mini-Sistemas

# 

# \### Controle de Bateria

# \- Classe: `Bateria`

# \- Funcionalidades:

# &nbsp; - Carregamento e descarga

# &nbsp; - Limites de 0 a 100

# &nbsp; - Exibição de status com enum `NivelCarga` (BAIXO, MÉDIO, ALTO)

# 

# \### Avaliação de Filmes

# \- Classe: `Filme`

# \- Funcionalidades:

# &nbsp; - Armazenamento de notas (0 a 5)

# &nbsp; - Cálculo automático da média

# &nbsp; - Uso de listas e streams

# 

# \### Conta Bancária

# \- Classe: `Conta`

# \- Funcionalidades:

# &nbsp; - Depósito e saque com validação

# &nbsp; - Exibição de saldo formatado

# &nbsp; - Mensagens de erro para valores inválidos

# 

# \### Login de Usuário

# \- Classe: `Login`

# \- Funcionalidades:

# &nbsp; - Validação de login e senha

# &nbsp; - Limite de tentativas

# &nbsp; - Mensagens de erro ou sucesso

# 

# \### Sistema de Pontos para Alunos

# \- Classe: `Aluno` + enum `Nivel`

# \- Funcionalidades:

# &nbsp; - Acumulação e perda de pontos

# &nbsp; - Atualização automática de nível

# &nbsp; - Exibição de status (nome, pontos e nível)

# 

# \### Registro de Notas por Disciplina

# \- Classe: `Diciplina`

# \- Funcionalidades:

# &nbsp; - Armazena notas válidas e inválidas separadamente

# &nbsp; - Cálculo de média apenas das notas válidas

# &nbsp; - Relatório completo com todas as informações

# 

# ---

# 

# \## Como Executar

# 1\. Abra a pasta do Curso 8 em sua IDE Java.

# 2\. Acesse o pacote `principal`.

# 3\. Execute as classes com o método `main` para testar cada sistema.

# 4\. Observe a saída no console para cada mini-sistema.

# 

# ---

# 

# \## Objetivo do Curso

# O Curso 8 — Encapsulamento tem como foco:

# \- Implementação de \*\*encapsulamento\*\* e validações

# \- Aplicação de regras de negócio simples

# \- Uso de enums e listas para organizar informações

# \- Criação de sistemas independentes simulando situações reais



