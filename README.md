# 🎮 Loja Games API

<p align="center">
  Backend desenvolvido em <strong>Java 17 + Spring Boot</strong> para gerenciamento de produtos e categorias de uma loja de games.
</p>

---

## 🚀 Tecnologias utilizadas

- ☕ Java 17
- 🌱 Spring Boot
- 💾 MySQL
- 🔗 Spring Data JPA
- 🌐 API REST
- 🔍 Insomnia
- 🐙 Git e GitHub

---

## 📌 Sobre o projeto

A **Loja Games API** é uma aplicação backend desenvolvida para gerenciar produtos de uma loja de games.

O sistema permite realizar operações de cadastro, consulta, atualização e exclusão de produtos e categorias através de uma API REST.

A aplicação utiliza o relacionamento **OneToMany** entre Categoria e Produto.

---

## 🎯 Funcionalidades

### 📂 Categoria

- ✅ Criar categoria
- ✅ Listar categorias
- ✅ Buscar categoria por ID
- ✅ Buscar categoria por tipo
- ✅ Atualizar categoria
- ✅ Deletar categoria

### 🎮 Produto

- ✅ Criar produto
- ✅ Listar produtos
- ✅ Buscar produto por ID
- ✅ Buscar produto por nome
- ✅ Atualizar produto
- ✅ Deletar produto

---

## 🔗 Relacionamento entre entidades

A aplicação possui o relacionamento:

```
Categoria (1) -------- (N) Produto
```

Uma categoria pode possuir vários produtos cadastrados.

Exemplo:

```
Console
 ├── Playstation 5
 ├── Xbox Series X
 └── Nintendo Switch
```

---

## 💾 Configuração do Banco de Dados

Banco utilizado:

```
MySQL
```

Nome do banco:

```
db_loja_games
```

Configuração realizada no arquivo:

```
application.properties
```

---

## ▶️ Como executar o projeto

### 1. Clone o repositório

```bash
git clone: https://github.com/phcarneiro9/Loja_Games_API
```

### 2. Configure o banco de dados

Altere as informações no arquivo:

```
src/main/resources/application.properties
```

### 3. Execute a aplicação

A API estará disponível em:

```
http://localhost:8080
```

---

## 🔗 Endpoints da API

### 🎮 Produtos

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/produtos` | Listar todos os produtos |
| POST | `/produtos` | Criar produto |
| GET | `/produtos/{id}` | Buscar produto por ID |
| GET | `/produtos/nome/{nome}` | Buscar produto por nome |
| PUT | `/produtos` | Atualizar produto |
| DELETE | `/produtos/{id}` | Deletar produto |

---

### 📂 Categorias

| Método | Endpoint | Descrição |
|---|---|---|
| GET | `/categorias` | Listar categorias |
| POST | `/categorias` | Criar categoria |
| GET | `/categorias/{id}` | Buscar categoria por ID |
| GET | `/categorias/tipo/{tipo}` | Buscar categoria por tipo |
| PUT | `/categorias` | Atualizar categoria |
| DELETE | `/categorias/{id}` | Deletar categoria |

---

## 📁 Estrutura do Projeto

```
src/main/java

└── com.generation.lojagames

    ├── controller
    │   ├── ProdutoController.java
    │   └── CategoriaController.java
    │
    ├── model
    │   ├── Produto.java
    │   └── Categoria.java
    │
    ├── repository
    │   ├── ProdutoRepository.java
    │   └── CategoriaRepository.java
    │
    └── LojaGamesApplication.java
```

---

## 🔧 Ferramentas utilizadas

- Spring Tool Suite (STS)
- MySQL Workbench
- Insomnia
- GitHub

---

## 👨‍💻 Desenvolvedor

**Patrick Carneiro**

Projeto desenvolvido para prática de desenvolvimento Backend utilizando **Java e Spring Boot**.
