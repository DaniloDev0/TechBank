package br.com.techbank.modelo;

public abstract class Conta {

    private int agencia;
    private int numero;
    private String titular;
    private double saldo;

    public Conta(int agencia, int numero, String titular) {
        this.agencia = agencia;
        this.numero = numero;
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }


    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void imprimirConta() {
        System.out.println("Agencia: " + this.agencia);
        System.out.println("Numero: " + this.numero);
        System.out.println("Titular: " + this.titular);
        System.out.println("Saldo: " + this.saldo);
    }

    public void depositar(double valor) {
        if (valor > 0) {
            this.saldo += valor;
        }else  {
            System.out.println("Valor invalido");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && this.saldo >= valor) {
            this.saldo -= valor;
        }else   {
            System.out.println("Valor invalido");
        }

    }

    public void transferir(double valor, Conta destino) {
        if (valor > 0 && this.saldo >= valor) {
            this.sacar(valor);
            destino.depositar(valor);
        } else {
            System.out.println("Erro na transferência: Saldo insuficiente.");
        }
    }
}
