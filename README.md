# Projeto Gestão Locação Veículos

## Descrição do projeto (Documento ainda em edição de recursos e passo a passo)...

Projeto Java 11 - aplicativo básico de gerenciamento de locações com recursos CRUD:

### Funcionarios
- Listar | GET | `/api/v1/funcionarios` | Status Code (200 (OK)) | Busca todos os funcionários
- Criar | POST | `/api/v1/funcionarios` | Status Code (201 (OK)) | criar um novo funcionário
- Buscar | GET | `/api/v1/funcionarios/{id}` | Status Code (200 (OK)) | Buscar funcionário
- Editar | PUT | `/api/v1/funcionarios/{id}` | Status Code (200 (OK)) | Atualizar funcionário
- Excluir | DELETE | `/api/v1/funcionarios/{id}` | Status Code (204 (No Content)) | Deletar funcionário

## Antes de iniciar

Verifique o ambiente com os seguintes parâmetros:

- Instalação Java 11+;
- Eclipse IDE ou Spring Tool Suite [STS];
- Verifique o projeto backend - script de criação do banco de dados;
- PostgreSQL 13;
- Conexão API Rest;

## Ferramentas e tecnologias do lado do servidor usadas

- Spring Boot 2 +
- SpringData JPA (Hibernate)
- Maven 3.2 +
- JDK 11+
- Tomcat 9+ / JBoss Wildfly
- Banco de dados PostgreSQL

Bora ao projeto, entra na pasta frontend e execute:

Clone o projeto em um local com permissões, abra-o no eclipse e aguarde 
as dependências serem baixadas, qualquer dúvida só enviar mensagem.
