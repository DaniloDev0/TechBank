package br.com.techbank.modelo;

public class CalculadorDeImpostos {

    private double totalImposto;

    public double getTotalImposto() {
        return totalImposto;
    }

    public void register(Tributavel item) {
        totalImposto += item.calcularTributos();
    }
}
