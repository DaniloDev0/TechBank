package br.com.techbank.principal;

import br.com.techbank.modelo.Conta;
import br.com.techbank.modelo.ContaCorrente;
import br.com.techbank.modelo.ContaPoupanca;

public class Main {
    public static void main(String[] args) {
        //Conta conta = new Conta(1111, 2222,"Danilo");
       // Conta conta2 = new Conta(1111, 3333,"Maria");
        ContaCorrente contaCorrente = new ContaCorrente(1111, 4444,"Joao");
        ContaPoupanca contaPoupanca = new ContaPoupanca(2222, 4444,"Danilo");

       contaPoupanca.depositar(500);
       contaPoupanca.renderJuros();
       contaPoupanca.imprimirConta();


    }
}
