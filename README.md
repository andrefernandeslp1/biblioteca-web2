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

Desenvolver um sistema web backend para administração empréstimos em uma biblioteca, utilizando o framework Spring, o template engine Thymeleaf para renderização de páginas e o banco de dados PostgreSQL.  
Para fazer a persistência dos dados e mapeamento objeto-relacional, foi utilizado o Spring Data JPA com JpaRepository.  

## 4. Mapeamento Objeto-Relacional

Para o mapeamento objeto-relacional, foram criadas as seguintes entidades:  

![mapeamento](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/mapeamento-bd.PNG)  

## 5. Arquitetura MVC

Para a arquitetura MVC, foram criados os seguintes pacotes:  

**Model:** Responsável por representar as entidades do banco de dados.  
![model](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/model.PNG)  

**View:** Responsável por renderizar as páginas no lado do servidor.  
Aqui, foram criadas apenas duas páginas:  
![view](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/html.PNG)  

**`menu.html`**  
![menu](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20at%2001.51.51-fullpage.png)  
Esta página (ver imagem acima) é criada por padrão pelo Spring Boot e é uma espécie de porta de entrada para a aplicação.  

**`index.html`**  
![index](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20at%2001.48.43-fullpage.png)  
Esta página (ver imagem acima) é onde a ação acontece. Para exibir as informações do sistema utilizei uma abordagem de página única, na qual o trecho de html a ser exibido é determinado por uma informação passada pelo controller e manipulada pelo Thymeleaf, que utilizando a diretiva th:switch, exibe o código desejado.  

**Controller:** Responsável pelas requisições e direcionamento das respostas.  
![controller](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/controller.PNG)  

**Service:** Responsável por desacoplar a aplicação das classes repositórios ou de regras de negócio.  
![service](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/service.PNG)  

**Repository:** Responsável por fazer a persistência dos dados.  
![repository](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/repository.PNG)  

## 6. Operações CRUD

Para as operações CRUD, foram implementadas as seguintes funcionalidades:  

**Create:** Cadastrar livro, autor, editora, empréstimo ou usuário.  
![create](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20%20at%209.59.23-fullpage.png)  

**Read:** Listar livros, autores, editoras, empréstimos ou usuários.  
![read](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20at%2009.59.46-fullpage.png)  

**Update:** Alterar estado do empréstimo.  
Ao clicar o botão devolver (ver imagem abaixo), o sistema atualiza o estado do empréstimo para devolvido.  

![update](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20at%2001.51.12-fullpage.png)  

**Delete:** Excluir usuário.  
Ao clicar em excluir (ver imagem abaixo), o sistema excluirá o usuário do banco de dabos e todos os empréstimos associados a ele.  

![delete](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Screen%20Shot%202024-04-08%20at%2001.51.31-fullpage.png)  

## 7. Queries personalizadas
1 - Listar autores cadastrados:  
![query1](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Query1.PNG)  

2 - Listar empréstimos ativos:  
![query2](https://raw.githubusercontent.com/andrefernandeslp1/biblioteca-web2/main/src/main/resources/static/imgs/Query2.PNG)  

## 8. Personalização e Usabilidade

**CSS:** CSS puro foi utilizado para estilizar as páginas.  

**JavaScript:** o JavaScript foi utilizado apenas para exigir a corfirmação do usuário ao realizar operações de Update e Delete.  

**Thymeleaf:** esta ferramenta foi bastante utilizada para a manipulação de dados, comunicação com o controller e renderização de páginas.  

## 9. Conclusão

O projeto foi desenvolvido com sucesso, atendendo aos critérios de avaliação propostos, alguns mais desenvolvidos que outros, mas todos presentes.  
O sistema não foi testado a exaustão, então alguns bugs podem ter passado despercebidos.
Não obstante, todos os erros encontrados foram corrigidos e o sistema está funcional.  

## 10. Referências

- [Spring](https://spring.io/)  
- [Thymeleaf](https://www.thymeleaf.org/)  
- [PostgreSQL](https://www.postgresql.org/)  

