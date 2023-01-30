package br.com.locadorabb.interfaces;

public interface IGatewayPagavel {

    boolean pagar();

    boolean validar();

    void ColetarDadosPagamento();

}
