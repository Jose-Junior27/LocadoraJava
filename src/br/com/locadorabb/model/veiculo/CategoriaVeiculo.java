package br.com.locadorabb.model.veiculo;

import br.com.locadorabb.interfaces.IModelavel;

import java.util.ArrayList;
import java.util.List;

public class CategoriaVeiculo implements IModelavel<String> {
    private long id;
    private String nome;
    private double valorDiaria;
    private boolean indisponivel;
    private List<DetalhesVeiculo> detalhesVeiculo = new ArrayList<>();

    public CategoriaVeiculo(String nome, double valorDiaria){
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.valorDiaria = valorDiaria;
        this.indisponivel = false;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public List<DetalhesVeiculo> getDetalhesVeiculo() {
        return detalhesVeiculo;
    }

    public void addDetalhesVeiculo(DetalhesVeiculo detalhesVeiculo) {
        this.detalhesVeiculo.add( detalhesVeiculo );
    }

    public boolean isIndisponivel() {
        return indisponivel;
    }

    public void setIndisponivel(boolean indisponivel) {
        this.indisponivel = indisponivel;
    }

    @Override
    public String getID() {
        return this.nome;
    }
}
