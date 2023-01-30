package br.com.locadorabb.model.endereco;

import br.com.locadorabb.enumerados.UF;
import br.com.locadorabb.interfaces.IModelavel;

public class Cidade implements IModelavel<String> {
    private long id;
    private String nome;
    private int cepInicial;
    private int cepFinal;
    private UF uf;

    public Cidade(String nome, UF uf, int cepInicial, int cepFinal ){
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.uf = uf;
        this.cepInicial = cepInicial;
        this.cepFinal = cepFinal;
    }

    public String getNome() {
        return nome;
    }

    public int getCepInicial() {
        return cepInicial;
    }

    public int getCepFinal() {
        return cepFinal;
    }

    public UF getUf() {
        return uf;
    }

    @Override
    public String getID() {
        return nome;
    }
}
