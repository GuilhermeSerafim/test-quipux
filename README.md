
```markdown
# Test Quipux - Backend

Este é o repositório do backend para o projeto **Test Quipux**, desenvolvido utilizando **Spring Boot**.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para construção da aplicação.
- **H2 Database**: Banco de dados em memória para testes.
- **JWT (JSON Web Tokens)**: Para autenticação e autorização.

## Como Executar
```
1. Clone este repositório:
   ```bash
   git clone https://github.com/GuilhermeSerafim/test-quipux-back.git
   ```

2. Navegue até o diretório do projeto:
   ```bash
   cd test-quipux-back
   ```

3. Compile e execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```

4. A aplicação estará disponível em:
   ```
   http://localhost:8080
   ```

## Endpoints Disponíveis

- **GET** `/lists` - Retorna todas as listas de reprodução.
- **POST** `/lists` - Adiciona uma nova lista de reprodução.
- **DELETE** `/lists/{listName}` - Remove uma lista de reprodução pelo nome.

## Configuração do Token de Autenticação

Para acessar os endpoints protegidos, será necessário fornecer um token JWT no cabeçalho de autenticação.

## Contribuição

Sinta-se à vontade para abrir issues ou enviar pull requests.
