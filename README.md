# tech-challenge-fiap
Repositório destinado ao desafio da pós-tech da Fiap, com simulação de um restaurante

# 📘 API de Usuários - Tech Challenge

Esta API RESTful permite gerenciar usuários no sistema.

Funções disponíveis:

- Criar usuários
- Atualizar dados do usuário
- Alterar senha
- Deletar usuários
- Buscar usuário por ID
- Listar todos os usuários

---

## 🔗 Base URL

```
/api/v1/usuarios
```

---

## 🧾 Modelo de Dados: Usuario

A entidade `Usuario` possui os seguintes campos:

| Campo              | Tipo           | Descrição                          |
|--------------------|----------------|------------------------------------|
| `id`               | Long           | Identificador único do usuário     |
| `nome`             | String         | Nome completo do usuário           |
| `email`            | String         | E-mail do usuário                  |
| `userLogin`        | String         | Nome de login                      |
| `senha`            | String         | Senha do usuário (criptografada)   |
| `ultimaAlteracao`  | LocalDate      | Data da última alteração           |
| `endereco`         | Endereco       | Endereço associado (1:1)           |

---

## 🚀 Endpoints

### 📌 Criar Usuário

**POST** `/api/v1/usuarios`

Cria um novo usuário.

#### 🔸 Request Body

```json
{
  "nome": "João da Silva",
  "email": "joao@email.com",
  "userLogin": "joaosilva",
  "senha": "senhaSegura123",
  "endereco": {
    "rua": "Rua Exemplo",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01001-000"
  }
}
```

### 📌 Atualizar Usuário

**PUT** `/api/v1/usuarios/{id}`

Atualiza os dados de um usuário existente.

#### 🔸 Path Variable

- `id`: ID do usuário.

#### 🔸 Request Body

```json
{
  "nome": "João Atualizado",
  "email": "joao.novo@email.com",
  "userLogin": "joaonovo",
  "endereco": {
    "rua": "Nova Rua",
    "numero": "456",
    "bairro": "Novo Bairro",
    "cidade": "Rio de Janeiro",
    "estado": "RJ",
    "cep": "20000-000"
  }
}
```

---

### 🔐 Atualizar Senha

**PATCH** `/api/v1/usuarios/updateSenha/{id}`

Atualiza a senha de um usuário.

#### 🔸 Path Variable

- `id`: ID do usuário.

#### 🔸 Request Body

```json
{
  "senhaAtual": "senhaAntiga123",
  "novaSenha": "novaSenha456"
}
```

### 🗑️ Deletar Usuário

**DELETE** `/api/v1/usuarios/deleteUsuario/{id}`

Remove um usuário do sistema.

#### 🔸 Path Variable

- `id`: ID do usuário.

---

### 🔍 Buscar Usuário por ID

**GET** `/api/v1/usuarios/buscarUsuario/{id}`

Retorna os dados de um usuário específico.

#### 🔸 Path Variable

- `id`: ID do usuário.

```json
{
  "id": 1,
  "nome": "João da Silva",
  "email": "joao@email.com",
  "userLogin": "joaosilva",
  "ultimaAlteracao": "2024-10-01",
  "endereco": {
    "rua": "Rua Exemplo",
    "numero": "123",
    "bairro": "Centro",
    "cidade": "São Paulo",
    "estado": "SP",
    "cep": "01001-000"
  }
}
```

---

### 📋 Buscar Todos os Usuários

**GET** `/api/v1/usuarios/buscarTodos`

Retorna uma lista com todos os usuários cadastrados.

## 📦 Tecnologias Utilizadas

- Java
- Spring Boot
- JPA / Hibernate
- Lombok
- Maven
- Docker
- Swagger

---
