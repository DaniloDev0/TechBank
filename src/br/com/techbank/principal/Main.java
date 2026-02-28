package br.com.techbank.principal;

import br.com.techbank.conexao.ConnectionFactory;
import br.com.techbank.dao.ContaDAO;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        ConnectionFactory fabrica = new ConnectionFactory();
        Connection conexao = fabrica.recuperarConexao();
        ContaDAO dao = new ContaDAO(conexao);

        // Infelizmente, a Maria decidiu encerrar a conta dela no TechBank :(
        // O número da conta da Maria era 3333. Vamos passar apenas o número para o DAO!
        dao.deletar(3333);

        conexao.close();
    }
}