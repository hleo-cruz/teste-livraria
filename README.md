# Teste-livraria

### Api construida usando as seguintes tecnologias:
* Java versao 21
* Spring boot versao 3
* banco de dados **H2**
* Documenntação Swagger

### Api com o propósito de apresentar conhecimentos solicitados nas tecnologias acima.
# Lista de endpoints

Verbo Http   | Endpoint             | Funcionalidade   |
--------- |---------------------- |------------------|
GET | **livros/{livroId}** | Buscar um livro por id
GET | **livros**           | Listar todos os livros
Post | **livros**           | Salvar um novo Livro
Put | **livros/{livroId}** | Atualizar os dados de um livro salvo
Delete | **livros/{livroId}** | Apagar um livro salvo

# Instruções de rodar o projeto
1. Clonar o repositório
2. Em uma linha de comando executar os comandos abaixo
3. Executar o comando mvn clean
4. Para executar o projeto mvn spring-boot:run
5. [Clique aqui](http://localhost:8080/swagger-ui/index.html)