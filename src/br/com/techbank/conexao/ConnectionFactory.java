package br.com.techbank.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public Connection recuperarConexao() {
        try {
            // Aqui é o endereço do seu banco, o usuário e a senha!
            // ATENÇÃO: Troque "sua_senha_aqui" pela senha que você usa no DBeaver/MySQL
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/techbank", "root", "59784636");
        } catch (SQLException e) {
            // Se der erro de senha errada ou banco fora do ar, paramos o programa
            throw new RuntimeException("Erro ao conectar com o banco de dados do TechBank!", e);
        }
    }
}