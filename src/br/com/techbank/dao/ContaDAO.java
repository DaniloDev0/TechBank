package br.com.techbank.dao;

import br.com.techbank.modelo.Conta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContaDAO {

    private Connection conexao;

    public ContaDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(Conta conta) {
        String sql = "INSERT INTO contas (numero, agencia, titular, saldo, tipo) VALUES (?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            ps.setInt(1, conta.getNumero());
            ps.setInt(2, conta.getAgencia());
            ps.setString(3, conta.getTitular());
            ps.setDouble(4, conta.getSaldo());
            ps.setString(5, conta.getClass().getSimpleName()); // Pega o nome "ContaCorrente" ou "ContaPoupanca"

            ps.execute();
            ps.close();
            System.out.println("Conta do(a) " + conta.getTitular() + " salva com sucesso no MySQL!");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao salvar conta no banco de dados", e);
        }
    }
}