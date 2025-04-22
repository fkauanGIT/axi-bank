
# AxiBank API

**AxiBank** é uma aplicação de gerenciamento bancário construída com **Java**, **Spring Boot**, **Docker** e outras tecnologias avançadas de segurança. A API permite gerenciar contas bancárias, transações, cartões, empréstimos e contatos, com autenticação e autorização robustas utilizando **JWT** e **Spring Security**.

---

## Foto da API do Projeto
![Foto 1](docs/Captura%20de%20tela%202025-04-21%20143313.png)
![Foto 2](docs/Captura%20de%20tela%202025-04-21%20142459.png)

## 🚀 Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Boot**: Framework para a construção da API.
- **Spring Security**: Implementação de autenticação e autorização de usuários.
- **JWT**: Tokens JWT para segurança e controle de sessões.
- **Lombok**: Reduz o boilerplate code através de anotações.
- **DevTools**: Ferramentas para facilitar o desenvolvimento e hot-reload.
- **Docker**: Contêineres para garantir consistência no ambiente de desenvolvimento e deploy.
- **SQL Driver**: Conexão com o banco de dados mySQL.

---

## 💡 Funcionalidades

- **Autenticação e Registro**: Registro de novos usuários e login com geração de tokens JWT.
- **Gestão de Contas**: Consulta de detalhes das contas bancárias.
- **Gestão de Cartões**: Exibição dos cartões vinculados ao usuário.
- **Transações Bancárias**: Visualização das transações realizadas nas contas.
- **Empréstimos**: Consulta aos empréstimos disponíveis e gerenciados pelo usuário.
- **Notícias e Contatos**: Gestão de contatos e exibição de anúncios/notícias.

---

## 🛠️ Como Rodar o Projeto

### 1. Clone o Repositório

```bash
git clone https://github.com/seu-usuario/axi-bank.git
cd axi-bank
```

### 2. Utilizando Docker

O projeto já possui um `Dockerfile` configurado, permitindo que você o rode em contêineres, garantindo consistência no ambiente de desenvolvimento e produção.

1. Construa a imagem Docker:

   ```bash
   docker build -t axibank .
   ```

2. Rode o contêiner Docker:

   ```bash
   docker run -p 8080:8080 axibank
   ```

### 3. Executando via IDE

Se preferir rodar localmente sem Docker, basta seguir os passos abaixo:

1. Abra o projeto no seu IDE (IntelliJ IDEA, Eclipse, etc.).
2. Rode a classe principal `AxiBankApplication.java`.

### 4. Banco de Dados

O projeto usa o **mySQL** como banco de dados. Configure uma instância local ou utilize um banco de dados remoto para testar a aplicação.

---

## 🌐 Endpoints

- **POST /register**: Registro de um novo usuário.
- **POST /apiLogin**: Login do usuário (retorna um JWT).
- **GET /myAccount**: Retorna os detalhes da conta bancária do usuário.
- **GET /myBalance**: Retorna o histórico de transações do usuário.
- **GET /myCards**: Retorna os cartões associados ao usuário.
- **GET /myLoans**: Retorna os empréstimos associados ao usuário.
- **GET /notices**: Retorna as últimas notícias e anúncios.

---

## 🏋️‍♂️ Desafios Enfrentados

- **Configuração do Spring Security**: Implementar segurança avançada com **Spring Security** foi um dos maiores desafios, especialmente ao integrar o fluxo de autenticação com **JWT** e a configuração de roles e authorities.

- **Autenticação com JWT**: Garantir que o fluxo de autenticação fosse seguro e sem expor dados sensíveis, além de integrar corretamente com o Spring Security.

- **Gerenciamento de Sessões**: Garantir que os tokens JWT fossem gerenciados corretamente e expirados sem comprometer a experiência do usuário.

- **Integração com Banco de Dados**: Configurar corretamente os relacionamentos entre as entidades e garantir a persistência eficiente no **mySQL** foi um desafio, mas que foi superado com a utilização de repositórios **Spring Data**.

---

## 🚀 Melhorias Futuras

- **OAuth2 e Keycloak**: Integração do OAuth2 para autenticação mais robusta, utilizando **Keycloak** para gerenciamento de identidade e controle de acesso, permitindo login via provedores externos como Google, Facebook, etc.

- **Documentação com Swagger**: Melhorar a documentação da API utilizando **Swagger** para facilitar a integração e o uso por outros desenvolvedores.

- **Escalabilidade**: Implementação de balanceamento de carga e deploy em nuvem para garantir a alta disponibilidade e escalabilidade da aplicação.

- **Notificações em Tempo Real**: Implementação de notificações em tempo real para transações bancárias e alertas importantes, aumentando a interatividade da aplicação.

---

## 🤝 Contribuições

1. **Fork** o repositório e crie uma branch para a sua feature:
   ```bash
   git checkout -b feature/nova-feature
   ```

2. **Faça commit** das suas alterações:
   ```bash
   git commit -am 'Adiciona nova feature'
   ```

3. **Envie a sua branch** para o repositório remoto:
   ```bash
   git push origin feature/nova-feature
   ```

4. Abra um **pull request** explicando as alterações feitas.

---

## 📝 Licença

Distribuído sob a licença **MIT**. Veja o arquivo `LICENSE` para mais informações.
