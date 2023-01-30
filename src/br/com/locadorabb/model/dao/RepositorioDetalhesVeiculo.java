package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.veiculo.DetalhesVeiculo;

public class RepositorioDetalhesVeiculo extends RepositorioGenerico<DetalhesVeiculo, String> {

    private static DetalhesVeiculo detalhesVeiculo;

    public RepositorioDetalhesVeiculo(DetalhesVeiculo entidade) {

        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioDetalhesVeiculo daoDetalhesVeiculo = new RepositorioDetalhesVeiculo(detalhesVeiculo);
        return daoDetalhesVeiculo;
    }


}
