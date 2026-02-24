package br.com.techbank.principal;

import br.com.techbank.modelo.Conta;
import br.com.techbank.modelo.ContaCorrente;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta(1111, 2222,"Danilo");
        Conta conta2 = new Conta(1111, 3333,"Maria");
        ContaCorrente contaCorrente = new ContaCorrente(1111, 4444,"Joao");

       contaCorrente.depositar(500);
        //conta.transferir(200,conta2);
        //conta.imprimirConta();
        contaCorrente.cobrarTarifaMensal();
        contaCorrente.tarifaMensal();
        contaCorrente.imprimirConta();
       // conta2.imprimirConta();


    }
}
