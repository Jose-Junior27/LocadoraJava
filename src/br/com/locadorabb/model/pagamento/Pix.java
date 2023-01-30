package br.com.locadorabb.model.pagamento;

public class Pix {
    private double valor;
    private String chave;

    public Pix(String chave, double valor){
        this.valor = valor;
        this.chave = chave;
    }

    public double getValor() {
        return valor;
    }

    public String getChave() {
        return chave;
    }

}
