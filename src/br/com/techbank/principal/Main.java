package br.com.techbank.principal;

import br.com.techbank.modelo.*;

public class Main {
    public static void main(String[] args) {

        Banco techBank = new Banco("TechBank");
        ContaCorrente cc = new ContaCorrente(1111, 2222, "Danilo");
        ContaCorrente cc2 = new ContaCorrente(1111, 3333, "Teste");

        techBank.adicionarConta(cc);
        techBank.adicionarConta(cc2);

        Conta contaAchada = techBank.buscarContaPorNumero(9999);
        System.out.println("Achei a conta do: " + contaAchada.getTitular());


    }
}
