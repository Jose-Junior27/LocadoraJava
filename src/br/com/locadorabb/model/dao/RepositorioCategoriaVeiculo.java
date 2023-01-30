package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.veiculo.CategoriaVeiculo;

public class RepositorioCategoriaVeiculo extends RepositorioGenerico<CategoriaVeiculo, String> {

    private static CategoriaVeiculo categoriaVeiculo;
    public RepositorioCategoriaVeiculo(CategoriaVeiculo entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioCategoriaVeiculo daoCategoriaVeiculo = new RepositorioCategoriaVeiculo(categoriaVeiculo);
        return daoCategoriaVeiculo;
    }

}
