package br.com.locadorabb.Service.pagamento;

import br.com.locadorabb.interfaces.IGatewayPagavel;
import br.com.locadorabb.model.pagamento.CartaoDebito;

public class PagamentoCartaoDebito implements IGatewayPagavel {

    private CartaoDebito cartaoDebito;
    private double valor;
    private String numeroCartao;

    public PagamentoCartaoDebito(double valor, String numeroCartao){
        this.valor = valor;
        this.numeroCartao = numeroCartao;
    }

    @Override
    public boolean pagar() {
        System.out.println("Validando Pagamento Cartão Debito no valor de: " + this.valor);
        return true;
    }

    @Override
    public boolean validar() {
        System.out.println("Validando gateway pagamento Cartão Debito numero: "+ this.numeroCartao);
        return true;
    }

    @Override
    public void ColetarDadosPagamento() {
        cartaoDebito = new CartaoDebito(valor, numeroCartao);
        System.out.println("Coletando Dados Cartão Debito numero: " + numeroCartao);
        System.out.println("Valor Pagamento: R$" + valor);
    }
}
