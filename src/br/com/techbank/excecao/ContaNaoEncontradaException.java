package br.com.techbank.excecao;

public class ContaNaoEncontradaException extends RuntimeException {

    public ContaNaoEncontradaException(String message) {
        super(message);
    }
}
