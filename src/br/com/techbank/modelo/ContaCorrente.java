package br.com.techbank.modelo;

public class ContaCorrente extends Conta implements Tributavel {

    public ContaCorrente(int agencia, int numero, String titular) {
        super(agencia, numero, titular);
    }

    private double tarifaMensal = 20;
    private double tarifaSaque = 0.10;
    private double tributo = 0.01;

    public double getTarifaMensal() {
        return tarifaMensal;
    }

    public double getTarifaSaque() {
        return tarifaSaque;
    }

    public double getTributo() {
        return tributo;
    }

    public void cobrarTarifaMensal() {
        sacar(this.tarifaMensal);
    }

    @Override
    public void sacar(double valor) {
        super.sacar(valor + this.tarifaSaque);
    }

    @Override
    public double calcularTributos() {
        return super.getSaldo() *  this.tributo;
    }
}