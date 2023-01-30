package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.veiculo.ModeloVeiculo;

public class RepositorioModeloVeiculo extends RepositorioGenerico<ModeloVeiculo, String> {

    private static ModeloVeiculo modeloVeiculo;

    public RepositorioModeloVeiculo(ModeloVeiculo entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioModeloVeiculo daoModeloVeiculo = new RepositorioModeloVeiculo(modeloVeiculo);
        return daoModeloVeiculo;
    }
}
