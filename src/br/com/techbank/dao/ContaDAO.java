package br.com.techbank.dao;

import br.com.techbank.modelo.Conta;
import br.com.techbank.modelo.ContaCorrente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

    public List<Conta> listarTodas() {
        List<Conta> contasResgatadas = new ArrayList<>();
        String sql = "SELECT * FROM contas";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);
            // Diferente do salvar (execute), para buscar nós usamos executeQuery (executar consulta)
            ResultSet rs = ps.executeQuery();

            // O 'while' vai passar linha por linha na tabela do banco até acabar
            while (rs.next()) {
                // 1. Pegamos os dados da coluna específica daquela linha
                int numero = rs.getInt("numero");
                int agencia = rs.getInt("agencia");
                String titular = rs.getString("titular");
                double saldo = rs.getDouble("saldo");

                // 2. Reconstruímos o objeto Java
                ContaCorrente conta = new ContaCorrente(agencia, numero, titular);

                // Só depositamos se houver saldo, para não estourar a sua validação de depósito zero!
                if (saldo > 0) {
                    conta.depositar(saldo);
                }

                // 3. Guardamos na nossa lista do Java
                contasResgatadas.add(conta);
            }

            rs.close();
            ps.close();

            return contasResgatadas;

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao buscar as contas no banco", e);
        }
    }

    public void atualizar(Conta conta) {
        String sql = "UPDATE contas SET saldo = ? WHERE numero = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            // 1. Trocamos a primeira interrogação pelo novo saldo
            ps.setDouble(1, conta.getSaldo());
            // 2. Trocamos a segunda interrogação pelo número da conta que queremos alterar
            ps.setInt(2, conta.getNumero());

            ps.execute();
            ps.close();

            System.out.println("Saldo da conta " + conta.getNumero() + " atualizado com sucesso no MySQL!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar a conta no banco", e);
        }
    }

    public void deletar(int numeroConta) {
        // "Delete da tabela contas ONDE o número for igual a X"
        String sql = "DELETE FROM contas WHERE numero = ?";

        try {
            PreparedStatement ps = conexao.prepareStatement(sql);

            // Trocamos a interrogação pelo número da conta que queremos apagar
            ps.setInt(1, numeroConta);

            ps.execute();
            ps.close();

            System.out.println("Conta número " + numeroConta + " encerrada e apagada do banco com sucesso!");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar a conta no banco", e);
        }
    }
}