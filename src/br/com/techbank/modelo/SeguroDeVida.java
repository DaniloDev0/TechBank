package br.com.techbank.modelo;

public class SeguroDeVida implements Tributavel {

    private double tarifaFixa = 42.0;

    public SeguroDeVida(double tarifaFixa) {
        this.tarifaFixa = tarifaFixa;
    }

    public double getTarifaFixa() {
        return tarifaFixa;
    }

    @Override
    public double calcularTributos() {
        return tarifaFixa;
    }
}
