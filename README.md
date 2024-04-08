![bibliotech-high-resolution-logo-black-transparent (Personalizado)](https://github.com/andrefernandeslp1/biblioteca-web2/assets/92834067/d0469176-ffd6-47ac-8a5c-cd8fab00e17a)
## Projeto: Sistema para administração de biblioteca.

### Universidade Federal do Rio Grande do Norte

### Disciplina: Desenvolvimento de Sistemas WEB II

#### Professor: Jean Mário Moreira de Lima

#### Aluno: André Augusto Fernandes

## 1. Introdução

O projeto consiste em um sistema web backend para um sistema de administração de biblioteca utilizando o framework Spring, o template engine Thymeleaf para renderização de páginas no lado do servidor e o banco de dados PostgreSQL.

## 2. Objetivo

O objetivo do projeto é desenvolver um sistema web backend, utilizando a arquitetura MVC, para o sistema de administração de uma biblioteca, incluindo persistência de dados em um BD SQL e um front-end simples para interação com o usuário.

## 3. Proposta

Desenvolver um sistema web backend para administração empréstimos em uma biblioteca, utilizando o framework Spring, o template engine Thymeleaf para renderização de páginas no lado do servidor e o banco de dados PostgreSQL.  
Para fazer a persistência dos dados e mapeamento objeto-relacional, foi utilizado o Spring Data JPA com JpaRepository.  

## 4. Mapeamento Objeto-Relacional

Para o mapeamento objeto-relacional, foram criadas as seguintes entidades:  

### IMAGEM do mapeamento

## 5. Operações CRUD

Para as operações CRUD, foram implementadas as seguintes funcionalidades:  

Create: Cadastrar livro, autor, editora, empréstimo ou usuário.  

Read: Listar livros, autores, editoras, empréstimos ou usuários.  

Update: Alterar estado do empréstimo.  

### IMAGEM

Delete: Excluir usuário.  

### IMAGEM

## 6. Arquitetura MVC

Para a arquitetura MVC, foram criados os seguintes pacotes:  

Model: Responsável por representar as entidades do banco de dados.  
### IMAGEM

View: Responsável por renderizar as páginas no lado do servidor.  
Aqui, foram criadas apenas duas páginas:  

menu.html:  
Esta página é criada por padrão pelo Spring Boot e é uma espécie de porta de entrada para a aplicação.  

index.html:  
Esta página é onde a ação acontece. Para exibir as informações do sistema utilizei uma abordagem de página única, na qual o trecho de html a ser exibido é determinado por uma informação passada pelo controller e manipulada pelo Thymeleaf, que utilizando a diretiva th:switch, exibe o código desejado.  

Controller: Responsável pelas requisições e direcionamento das respostas.  
### IMAGEM
Service: Responsável por desacoplar a aplicação das classes repositórios ou de regras de negócio.  
### IMAGEM
Repository: Responsável por fazer a persistência dos dados.  
### IMAGEM

## 7. Personalização e Usabilidade

CSS: para estilizar as páginas, foi utilizado CSS puro.  

JavaScript: o JavaScript foi utilizado apenas para exigir a corfirmação do usuário ao realizar operações de Update e Delete.  

Thymeleaf: esta ferramenta foi bastante utilizada para a manipulação de dados, cominicação com o controller e renderização de páginas.  

## 8. Conclusão

O projeto foi desenvolvido com sucesso, atendendo aos critérios de avaliação propostos, alguns mais desenvolvidos que outros, mas todos presentes.  
O sistema não foi testado a exaustão, então alguns bugs podem ter passado despercebidos.
Não obstante, todos os erros encontrados foram corrigidos e o sistema está funcional.  

## 9. Referências

- [Spring](https://spring.io/)  
- [Thymeleaf](https://www.thymeleaf.org/)  
- [PostgreSQL](https://www.postgresql.org/)  


ATIVIDADE AVALIATIVA: PROJETO DA UNIDADE I
I. Informes
1. O projeto da unidade será em grupo de até 4 pessoas. Recomendo que façam em
grupo para dividir as diversas tarefas!
1. O grupo deve criar um repositório em alguma plataforma git aberta (GitHub, GitLab)
para trabalhar no projeto de maneira colaborativa.
1. APRESENTAÇÃO OBRIGATÓRIA: 09/04/2022. O grupo deverá preparar uma
breve apresentação (.pptx / .pdf) e apresentar o objetivo do projeto, bem como as
funcionalidades, destacando os recursos implementados relativos aos critérios de
avaliação descritos no item III. O tempo de apresentação é de no máximo 8 min. O
grupo que não apresentar, terá a nota zerada.
1. PARTICIPAÇÃO OBRIGATÓRIA: TODOS os componentes do grupo devem estar
presentes e cada um vai explicar a parte que ficou responsável. O componente do
grupo que estiver ausente terá a nota zerada.
1. FORMA DE ENTREGA: Exclusivamente via SIGAA, arquivo com:
a. Nomes e Matrículas dos componentes do grupo.
b. Link do repositório do projeto (Github, GitLab) (certificar-se que há
permissão de acesso)
1. NOTA: 0,00 a 10,00.
a. Obs: Peso de 80% na nota da unidade.
II. Proposta de Projeto
Desenvolver um sistema web backend com páginas renderizadas no lado do servidor por
algum template engine. Utilize o framework de sua preferência - recomendo: SPRING e o
template engine de sua preferência - recomendo: Thymeleaf, Handlebars ou Mustache. O
sistema deve ter funcionalidade explícita. O grupo precisa validar a ideia do projeto, durante
aula, via email ou discord com o professor. Obs: Não serão aceitas propostas iguais às que
foram desenvolvidas em aula ou nos mini-projetos!
III. Critérios de Avaliação
1. O sistema deve estar funcional e com funcionalidade explícita. Deve dividir, de
maneira adequada, componentes importantes da aplicação, criando seus próprios
pacotes e subdiretórios. Apresentação e propostas adequadas (1,00 ponto).
1. O sistema deve fazer extenso uso dos recursos de persistência e mapeamento
objeto-relacional. Recomendo a utilização do Spring Data Jpa com JpaRepository.
Deve fazer uso de, no mínimo, 5 entidades que serão mapeadas em tabelas. Deve
existir relacionamentos entre as tabelas, pelo menos um relacionamento de cada tipo:
um-para-um, um-para-muitos (muitos-para-um), e muitos-para-muitos. Pelo menos
um dos relacionamentos feitos deve ser bidirecional. Sua aplicação deve habilitar
todas as operações de CRUD para pelo menos 4 entidades. (4,00 pontos).
1. Sua aplicação deve seguir a arquitetura MVC. Para cada modelo operacional,
implemente o respectivo controller, que deve ser o responsável pelas requisições e
direcionamento das respostas (páginas carregadas) e os services para desacoplar sua
aplicação das classes repositórios ou de regras de negócio. Pelo menos duas classes de
repositórios devem conter queries de busca personalizadas (2,00 pontos).
1. Personalização e Usabilidade: Utilize recursos de javascript e css para personalizar
sua aplicação. Você pode utilizar frameworks de layout como Bootstrap e Materialize
para personalizar suas páginas. (3,00 pontos).