package br.com.locadorabb.model.veiculo;

import br.com.locadorabb.interfaces.IModelavel;

public class ModeloVeiculo implements IModelavel<String> {
    private long id;
    private String nome;
    private MarcaVeiculo marca;
    private CategoriaVeiculo categoria;
    private boolean reservado;

    public ModeloVeiculo(String nome, MarcaVeiculo marca, CategoriaVeiculo categoria){
        this.id = System.currentTimeMillis();
        this.nome = nome;
        this.marca = marca;
        this.categoria = categoria;
        this.reservado = false;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public MarcaVeiculo getMarca() {
        return marca;
    }

    public CategoriaVeiculo getCategoria() {
        return categoria;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void setReservado(boolean reservado) {
        this.reservado = reservado;
    }

    @Override
    public String getID() {
        return nome;
    }
}
