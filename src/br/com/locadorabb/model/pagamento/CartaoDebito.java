package br.com.locadorabb.model.pagamento;

public class CartaoDebito {
    private double valor;
    private String numero;

    public CartaoDebito(double valor, String numero){
        this.valor = valor;
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public String getNumero() {
        return numero;
    }

}
