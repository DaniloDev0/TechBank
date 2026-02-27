package br.com.techbank.principal;

import br.com.techbank.modelo.*;

public class Main {
    public static void main(String[] args) {

        Banco techBank = new Banco("TechBank");
        ContaCorrente cc = new ContaCorrente(1111, 2222, "Danilo");
        ContaCorrente cc2 = new ContaCorrente(1111, 3333, "Maria");

        //cc.depositar(500);
        techBank.adicionarConta(cc);
        techBank.adicionarConta(cc2);
        techBank.realizarPix(2222,3333,150);

        techBank.exibirContas();


    }
}
