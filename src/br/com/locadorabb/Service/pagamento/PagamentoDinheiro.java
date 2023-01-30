package br.com.locadorabb.Service.pagamento;

import br.com.locadorabb.interfaces.IGatewayPagavel;
import br.com.locadorabb.model.pagamento.Dinheiro;

public class PagamentoDinheiro implements IGatewayPagavel {

    private Dinheiro dinheiro;
    private double valor;

    public PagamentoDinheiro(double valor){
        this.valor = valor;
    }

    @Override
    public boolean pagar() {
        System.out.println("Pagamento em espécie: " + this.valor);
        return true;
    }

    @Override
    public boolean validar() {
        System.out.println("Valor R$: " + this.valor);
        return true;
    }

    @Override
    public void ColetarDadosPagamento() {
        dinheiro = new Dinheiro(this.valor);
        System.out.println("Valor Pagamento: R$" + valor);
    }

}
