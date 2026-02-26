package br.com.techbank.principal;

import br.com.techbank.modelo.*;

public class Main {
    public static void main(String[] args) {
       ContaCorrente cc = new ContaCorrente(1111, 2222, "Danilo");
        ContaCorrente cc2 = new ContaCorrente(1111, 2222, "Teste");
       //cc.depositar(-40);
       cc.transferir(566,cc2);
       //cc.sacar(500);

       // SeguroDeVida seguroDeVida = new SeguroDeVida(42.0);
       // CalculadorDeImpostos calc = new CalculadorDeImpostos();

        //calc.register(cc);
        //calc.register(seguroDeVida);
       // System.out.println("Total de impostos recolhidos: R$ " + calc.getTotalImposto());


    }
}
