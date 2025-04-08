
# 🏦 AxiBank API

API RESTful desenvolvida em Java com Spring Boot para gerenciar um sistema bancário simples. O projeto permite criar e consultar **clientes**, **contas bancárias** e **transferências**.

---

## 🚀 Tecnologias Utilizadas

- Java 17+
- Spring Boot 3+
- Spring Web
- Spring Data JPA
- PostgreSQL
- Lombok
- Swagger (Springdoc OpenAPI)

---

## ⚙️ Como rodar o projeto

### 1. Clone o repositório

```bash
git clone https://github.com/seu-usuario/axibank.git
cd axibank
```

### 2. Configure o banco de dados

No arquivo `src/main/resources/application.properties`, insira sua configuração:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/axibank
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

💡 Certifique-se de que o banco PostgreSQL esteja rodando.

### 3. Rode o projeto com Maven

```bash
mvn spring-boot:run
```

---

## 📖 Documentação Swagger

Acesse a documentação automática da API:

- 🔗 http://localhost:8080/swagger-ui.html
- 🔗 http://localhost:8080/swagger-ui/index.html

---

## 🔄 Endpoints

### 👤 Clientes

| Método | Endpoint          | Descrição              |
|--------|-------------------|------------------------|
| POST   | `/customers`      | Criar novo cliente     |
| GET    | `/customers/{id}` | Buscar cliente por ID  |

### 🏦 Contas

| Método | Endpoint         | Descrição              |
|--------|------------------|------------------------|
| POST   | `/accounts`      | Criar nova conta       |
| GET    | `/accounts/{id}` | Buscar conta por ID    |

### 💸 Transferências

| Método | Endpoint           | Descrição                  |
|--------|--------------------|----------------------------|
| POST   | `/transfers`       | Realizar transferência     |
| GET    | `/transfers/{id}`  | Buscar transferência por ID|

---

## 🧪 Exemplo de Requisições

### Criar Conta (`POST /accounts`)

```json
{
  "customerId": 1,
  "accountType": "CHECKING"
}
```

### Criar Transferência (`POST /transfers`)

```json
{
  "sourceAccountId": 1,
  "destinationAccountId": 2,
  "amount": 150.00
}
```

---

## 📬 Testando a API

Você pode testar os endpoints usando:

- Swagger
- Postman
- Insomnia
- Curl

---

## 🔮 Melhorias Futuras

- Autenticação com JWT
- Validações personalizadas
- Deploy na nuvem (Railway, Render, etc)
