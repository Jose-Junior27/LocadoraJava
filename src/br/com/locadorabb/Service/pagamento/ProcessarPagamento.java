package br.com.locadorabb.Service.pagamento;
import br.com.locadorabb.interfaces.IGatewayPagavel;

public class ProcessarPagamento {
    public static boolean processarPagamento(IGatewayPagavel gateway){
       gateway.ColetarDadosPagamento();
       gateway.validar();
       return gateway.pagar();
    }
}
