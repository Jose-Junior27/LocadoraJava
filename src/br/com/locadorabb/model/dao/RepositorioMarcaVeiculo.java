package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.veiculo.MarcaVeiculo;

public class RepositorioMarcaVeiculo extends RepositorioGenerico<MarcaVeiculo, String> {
    private static MarcaVeiculo marcaVeiculo;

    public RepositorioMarcaVeiculo(MarcaVeiculo entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioMarcaVeiculo daoMarcaVeiculo = new RepositorioMarcaVeiculo(marcaVeiculo);
        return daoMarcaVeiculo;
    }
}
