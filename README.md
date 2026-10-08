# 🎮 Loja Games API

Backend REST desenvolvido com **Java 17 e Spring Boot** para gerenciamento de produtos e categorias de uma loja de games.

## 🚀 Funcionalidades

### 📂 Categorias
- Criar, listar, buscar, atualizar e excluir categorias
- Buscar categoria por tipo

### 🎮 Produtos
- Criar, listar, buscar, atualizar e excluir produtos
- Buscar produto por nome

## 🧩 Relacionamento

```text
Categoria 1 ──── N Produto
```

## 🛠️ Tecnologias

- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- MySQL
- API REST
- Maven
- Insomnia

## 💾 Banco de Dados

Banco utilizado: **MySQL**

Nome do banco:

```text
db_loja_games
```

Configure as credenciais no arquivo `application.properties`.

## ▶️ Como executar

```bash
git clone https://github.com/phcarneiro9/Loja_Games_API.git
cd Loja_Games_API
```

Configure o banco de dados e execute a aplicação pela IDE ou com Maven.

A API será disponibilizada em:

```text
http://localhost:8080
```

## 🔗 Endpoints principais

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/produtos` | Listar produtos |
| POST | `/produtos` | Criar produto |
| GET | `/produtos/{id}` | Buscar produto |
| GET | `/produtos/nome/{nome}` | Buscar por nome |
| PUT | `/produtos` | Atualizar produto |
| DELETE | `/produtos/{id}` | Excluir produto |
| GET | `/categorias` | Listar categorias |
| POST | `/categorias` | Criar categoria |
| GET | `/categorias/{id}` | Buscar categoria |
| PUT | `/categorias` | Atualizar categoria |
| DELETE | `/categorias/{id}` | Excluir categoria |

## 🎯 Objetivo

Projeto desenvolvido para praticar **APIs REST, CRUD, persistência de dados e relacionamentos entre entidades** com Spring Boot.

## 👨‍💻 Autor

**Patrick Carneiro**

[GitHub](https://github.com/phcarneiro9)

<!-- README refresh -->
