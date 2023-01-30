package br.com.locadorabb.model.endereco;
import br.com.locadorabb.interfaces.IModelavel;
import br.com.locadorabb.model.endereco.Cidade;

public class Endereco implements IModelavel<String> {

    private long id;
    private String logradouro;
    private String numero;
    private String complemento;
    private Cidade cidade;
    private int cep;


    public Endereco(String logradouro, String numero, String complemento, Cidade cidade, int cep){
        this.id = System.currentTimeMillis();
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
        this.cep = cep;

    }

    public long getId() { return id; }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public String getID() {
        return this.logradouro;
    }
}
