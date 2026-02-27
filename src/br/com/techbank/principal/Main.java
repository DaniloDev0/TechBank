package br.com.techbank.principal;

import br.com.techbank.conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {

        System.out.println("Testando a conexão com o banco de dados...");

        ConnectionFactory fabrica = new ConnectionFactory();
        Connection conexao = fabrica.recuperarConexao();

        System.out.println("Conexão aberta com sucesso! O Java entrou no MySQL!");

        // Regra de ouro: abriu a porta, tem que fechar depois!
        conexao.close();
    }
}