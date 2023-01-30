package br.com.locadorabb.Service.pagamento;

import br.com.locadorabb.interfaces.IGatewayPagavel;
import br.com.locadorabb.model.pagamento.Pix;

public class PagamentoPix implements IGatewayPagavel {
    private Pix pix;
    private double valor;
    private String chave;

    public PagamentoPix(String chave, double valor){
        this.chave = chave;
        this.valor = valor;
    }

    @Override
    public boolean pagar() {
        System.out.println("Validando Pagamento via PIX no valor de: " + this.valor);
        return true;
    }

    @Override
    public boolean validar() {
        System.out.println("Validando chave Pix: " + chave);
        return true;
    }

    @Override
    public void ColetarDadosPagamento() {
        pix = new Pix(this.chave, this.valor);
        System.out.println("Coletando Dados Pix chave: " + chave);
        System.out.println("Valor Pagamento: R$" + valor);
    }
}
