\# Praticando Java — Herança, Polimorfismo e Interfaces



\*\*Pacote:\*\* `desafiosc9`

Este módulo aprofunda os pilares fundamentais da Orientação a Objetos avançada, com foco em \*\*reutilização\*\*, \*\*especialização\*\*, \*\*flexibilidade\*\* e \*\*contratos formais de comportamento\*\*.



---



\## Conteúdos Trabalhados



\### Herança (`extends`)



\* Definição de hierarquias de classes.

\* Reaproveitamento de atributos e métodos.

\* Especialização de comportamento em subclasses.

\* Uso de `super` para acessar a classe base.



\### Polimorfismo



\* Sobrescrita de métodos (`@Override`).

\* Comportamento dinâmico em tempo de execução.

\* Referências do tipo da classe mãe apontando para objetos filhos.

\* Listas e coleções com objetos de múltiplos tipos relacionados.



\### Interfaces



\* Criação de contratos de comportamento.

\* Implementação múltipla.

\* Polimorfismo baseado em interface.

\* Comportamentos padronizados aplicados a classes distintas.



\### Boas práticas aplicadas



\* Uso estratégico de classes abstratas.

\* Redução de duplicação de código.

\* Estruturação clara entre modelo e execução.



---



\## Estrutura do Pacote



```

desafiosc9/

&nbsp;├── modelo/        → classes abstratas, interfaces e subclasses

&nbsp;└── principal/     → classes com método main para testes

```



---



\## Desafios Desenvolvidos



\### Sistema baseado em herança



Exemplos típicos (dependem da sua implementação):



\* `Pessoa` → superclasse com atributos e lógica comum.

\* Subclasses como `Aluno`, `Professor` ou `Funcionario` especializando comportamento.



\### Polimorfismo aplicado



\* Métodos que recebem o tipo genérico (ex.: `Pessoa`) e executam comportamentos específicos das subclasses.

\* Coleções com objetos diversos usando a mesma referência base.



\### Interfaces como contratos



\* Interfaces representando papéis: `Autenticavel`, `Registravel`, `Operavel`, etc.

\* Diferentes classes implementando o mesmo contrato.

\* Demonstração de polimorfismo por interface.



\### Exercícios com sobrescrita de métodos



\* Reescrita de comportamentos herdados para adaptar a lógica.

\* Uso de `super` quando necessário para reaproveitar partes da implementação.



---



\## Como Executar



1\. Acesse o diretório do pacote:



```

praticando\_java/src/br/com/nadson/desafiosc9/principal

```



2\. Execute a classe desejada:



```

java NomeDaClassePrincipal

```



---



\## Objetivos do Módulo



\* Consolidar os princípios avançados da Programação Orientada a Objetos.

\* Criar sistemas flexíveis e expansíveis.

\* Dominar herança, polimorfismo e interfaces na prática.

\* Utilizar abstração para modelar cenários reais.

\* Reforçar boas práticas que tornam o código organizado e sustentável.



---



