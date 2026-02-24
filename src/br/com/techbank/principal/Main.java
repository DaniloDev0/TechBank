package br.com.techbank.principal;

import br.com.techbank.modelo.Conta;

public class Main {
    public static void main(String[] args) {
        Conta conta = new Conta(1111, 2222,"Danilo");
        Conta conta2 = new Conta(1111, 3333,"Maria");

       // conta.depositar(-500);
        //conta.transferir(200,conta2);
        //conta.imprimirConta();
        conta.sacar(10000);
        conta.imprimirConta();
       // conta2.imprimirConta();


    }
}
