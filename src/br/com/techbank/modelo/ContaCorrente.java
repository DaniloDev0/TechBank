package br.com.techbank.modelo;

public class ContaCorrente extends Conta{

    public ContaCorrente(int agencia, int numero, String titular) {
        super(agencia, numero, titular);
    }
    private double tarifaMensal = 20;

    public double getTaxa() {
        return tarifaMensal;
    }

    public void cobrarTarifaMensal(){
        sacar(this.tarifaMensal);
    }
}
