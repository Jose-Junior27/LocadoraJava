package br.com.locadorabb.model.pagamento;

public class CartaoCredito {
    private double valor;
    private String numero;
    private byte parcelas;

    public CartaoCredito(double valor, String numero, byte parcelas){
        this.valor = valor;
        this.numero = numero;
        this.parcelas = parcelas;
    }

    public double getValor() {
        return valor;
    }

    public String getNumero() {
        return numero;
    }

    public short getParcelas() {
        return parcelas;
    }

}
