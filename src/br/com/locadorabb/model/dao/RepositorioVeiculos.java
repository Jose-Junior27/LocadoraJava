package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.veiculo.Veiculo;

public class RepositorioVeiculos extends RepositorioGenerico<Veiculo, String> {

    private static Veiculo veiculo;
    public RepositorioVeiculos(Veiculo entidade) {

        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepostorio(){
        RepositorioVeiculos daoVeiculos = new RepositorioVeiculos(veiculo);
        return daoVeiculos;
    }
}
