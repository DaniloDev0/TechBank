package br.com.techbank.principal;

import br.com.techbank.conexao.ConnectionFactory;
import br.com.techbank.dao.ContaDAO;
import br.com.techbank.modelo.ContaCorrente;

import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1. Abre a conexão
        ConnectionFactory fabrica = new ConnectionFactory();
        Connection conexao = fabrica.recuperarConexao();

        // 2. Cria a cliente (que só existe na memória RAM por enquanto)
        ContaCorrente contaDaMaria = new ContaCorrente(1111, 3333, "Maria (Gerente)");
        contaDaMaria.depositar(500.0);

        ContaDAO dao = new ContaDAO(conexao);
        dao.salvar(contaDaMaria);

        // 4. Fecha a porta
        conexao.close();
    }
}