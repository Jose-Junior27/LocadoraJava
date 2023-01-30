package br.com.locadorabb.model.veiculo;

import br.com.locadorabb.interfaces.IModelavel;

public class MarcaVeiculo implements IModelavel<String> {
    private long id;
    private String nome;

    public MarcaVeiculo(String nome){
        this.id = System.currentTimeMillis();
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String getID() {
        return this.nome;
    }
}
