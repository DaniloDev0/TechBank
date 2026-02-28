# 🏦 TechBank - Sistema Bancário em Java

![Java](https://img.shields.io/badge/Java-21-orange.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.4-blue.svg)
![Maven](https://img.shields.io/badge/Maven-Dependency_Manager-C71A36.svg)

## 📖 Sobre o Projeto
O **TechBank** é um sistema bancário de terminal (Console Application) desenvolvido em Java. O projeto foi construído do zero com o objetivo de aplicar os fundamentos da **Orientação a Objetos**, evoluindo para uma arquitetura de persistência de dados real utilizando **Banco de Dados Relacional (MySQL)**.

Este projeto marca a transição de um sistema que operava apenas na Memória RAM para uma aplicação com um CRUD completo (Create, Read, Update, Delete) gravando fisicamente no disco rígido.

## 🚀 Funcionalidades Principais

* **Gestão de Contas:** Criação de Conta Corrente e Conta Poupança.
* **Operações Bancárias:** Saque, Depósito e Transferência (Simulação de PIX).
* **Regras de Negócio e Polimorfismo:** Aplicação de taxas específicas para saques em Conta Corrente.
* **Segurança e Validações:** Blindagem de métodos e tratamento de erros utilizando **Exceções Customizadas** (ex: tentativa de saque sem saldo, busca por conta inexistente).
* **Persistência de Dados (CRUD):** * `[CREATE]` Abertura de contas salvas direto no MySQL.
    * `[READ]` Resgate de clientes do banco de dados para a memória RAM.
    * `[UPDATE]` Atualização de saldos em tempo real no banco físico após movimentações.
    * `[DELETE]` Encerramento de contas e remoção do banco de dados.

## 🛠️ Tecnologias e Arquitetura

* **Linguagem:** Java 21
* **Banco de Dados:** MySQL 8.4
* **Gerenciador de Dependências:** Maven
* **Interface de Banco de Dados:** DBeaver / JDBC (Java Database Connectivity)

### Padrões de Projeto (Design Patterns) Aplicados:
* **DAO (Data Access Object):** Separação total entre as regras de negócio do banco e os comandos SQL (`ContaDAO`).
* **Factory:** Centralização da criação de conexões com o banco de dados (`ConnectionFactory`).
* **PreparedStatement:** Proteção contra ataques de *SQL Injection* durante a manipulação de dados.

## 🗄️ Estrutura do Banco de Dados

Script SQL utilizado para inicializar o ambiente:

```sql
CREATE DATABASE techbank;
USE techbank;

CREATE TABLE contas (
    numero INT PRIMARY KEY,
    agencia INT NOT NULL,
    titular VARCHAR(100) NOT NULL,
    saldo DECIMAL(10, 2) NOT NULL,
    tipo VARCHAR(30) NOT NULL
);