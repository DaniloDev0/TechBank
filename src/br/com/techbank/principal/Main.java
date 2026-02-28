package br.com.techbank.principal;

import br.com.techbank.conexao.ConnectionFactory;
import br.com.techbank.dao.ContaDAO;
import br.com.techbank.modelo.Conta;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
        // 1. Abre a porta do cofre
        ConnectionFactory fabrica = new ConnectionFactory();
        Connection conexao = fabrica.recuperarConexao();

        // 2. Chama o DAO e pede para ele trazer todo mundo do MySQL
        ContaDAO dao = new ContaDAO(conexao);
        List<Conta> clientesDoBanco = dao.listarTodas();

        // 3. Imprime no console para provar que o Java conseguiu ler o banco físico!
        System.out.println("--- CLIENTES RESGATADOS DO DISCO RÍGIDO ---");
        for (Conta conta : clientesDoBanco) {
            conta.imprimirConta();
            System.out.println("-------------------------");
        }

        // 4. Tranca a porta
        conexao.close();
    }
}