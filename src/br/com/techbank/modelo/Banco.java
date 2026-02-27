package br.com.techbank.modelo;

import br.com.techbank.excecao.ContaNaoEncontradaException;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nome;
    private List<Conta> contas;

    public Banco(String nome) {
        this.nome = nome;
        this.contas =  new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void removerConta(Conta conta) {
        this.contas.remove(conta);
    }

    public void exibirContas() {
        for (Conta conta : this.contas) {
            conta.imprimirConta();
        }
    }

    public Conta buscarContaPorNumero(int numero) {
        for (Conta conta : this.contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        throw new ContaNaoEncontradaException("Nenhuma conta encontrada com o número: " + numero);
    }
}
