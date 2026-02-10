# 📚 Sistema Gerenciador de Biblioteca

## 📝 Descrição
O sistema gerenciador de biblioteca é focado na administração de livros, armazenando 
também os seus autores, editoras e gêneros.
Foi construído de forma simples, para que meus estudos acerca da linguagem Java 
e da API JDBC ganhassem forma concreta.

## 🛠️ Tecnologias utilizadas
- Java
- JDBC
- PostgreSQL
- SQL

## 🚀 Funcionalidades
- Cadastrar autor
- Listar autores
- Cadastrar livro
- Listar livros
- Excluir livro
- Atualizar status de livro (disponível/emprestado)
- Cadastrar editora
- Listar editoras
- Cadastrar gênero
- Listar gêneros

## 🧱 Arquitetura
- Separação em camadas (model, dao e service)
- Padrão DAO para acesso a dados
- Regras de negócio no Service
- Uso de ENUM para status do livro 

## 📌 Pré-requisitos
- Java 17 ou superior
- PostgreSQL
- Maven

## ▶️ Como executar
1. Crie o banco de dados
2. Execute o script SQL (`schema.sql`)
3. Configure as credenciais no arquivo de conexão
4. Execute a aplicação pelo método `main`