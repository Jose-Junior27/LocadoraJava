package br.com.locadorabb.Service.pagamento;

import br.com.locadorabb.interfaces.IGatewayPagavel;
import br.com.locadorabb.model.pagamento.CartaoCredito;

public class PagamentoCartaoCredito implements IGatewayPagavel {

    private CartaoCredito cartaoCredito;
    private double valor;
    private String numeroCartao;
    private byte parcelas;

    public PagamentoCartaoCredito(double valor, String numeroCartao, byte parcelas){
        this.valor = valor;
        this.numeroCartao = numeroCartao;
        this.parcelas = parcelas;
    }

    @Override
    public boolean pagar() {
        System.out.println("Validando Pagamento Cartão Crédito no valor de: " + this.valor);
        return true;
    }

    @Override
    public boolean validar() {
        System.out.println("Validando gateway pagamento Cartão Crédito numero: "+ this.numeroCartao);
        return true;
    }

    @Override
    public void ColetarDadosPagamento() {
        cartaoCredito = new CartaoCredito(valor, numeroCartao, parcelas);
        System.out.println("Coletando Dados Cartão Credito numero: " + numeroCartao);
        System.out.println("Valor Pagamento: R$" + valor);
        System.out.println("Parcelas Solicitadas: " + parcelas);
    }
}
