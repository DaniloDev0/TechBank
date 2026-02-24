package br.com.techbank.modelo;

public class ContaPoupanca extends Conta{

    public ContaPoupanca(int agencia, int numero, String titular) {
        super(agencia, numero, titular);
    }

    private double rendimento =  0.005;

    public double getRendimento() {
        return rendimento;
    }

    public void renderJuros() {
        depositar(getSaldo() * this.rendimento);
    }
}
