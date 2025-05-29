# Projeto DSList - Catálogo de Jogos

Este projeto foi desenvolvido com o objetivo de aprendizado em Java e Spring Boot. A proposta é construir uma API REST para um catálogo de jogos, permitindo listar e organizar jogos por listas, além de reordenar os itens. 
Tudo foi testado via Postman e utiliza banco de dados em memória (H2) para facilitar o desenvolvimento.

## Tecnologias usadas

- Java 17
- Spring Boot
- Spring Data JPA
- Maven (gerenciador de dependências)
- Banco de dados H2
- Postman (para testar a API)

## Estrutura do projeto

O sistema foi desenvolvido seguindo o padrão de camadas:

- **Model (entities):** representa as tabelas do banco.
- **Repository:** responsável por acessar os dados no banco.
- **DTO:** objetos criados pra transferir dados de forma controlada.
- **Projection:** usado em consultas SQL que retornam só alguns campos.
- **Service:** camada com regras de negócio.
- **Controller:** onde ficam os endpoints da API.  

## Endpoints disponíveis

### GET /games  
Lista todos os jogos.

### GET /games/{id}  
Retorna os dados de um jogo pelo seu ID.

### GET /lists  
Retorna todas as listas de jogos cadastradas.

### GET /lists/{id}/games  
Retorna os jogos pertencentes a uma lista específica.

### POST /lists/{id}/replacement  
Reorganiza a ordem dos jogos dentro de uma lista.  
Body esperado (JSON):
```json
{
  "posicaoOrigem": 3,
  "posicaoDestino": 1
}
