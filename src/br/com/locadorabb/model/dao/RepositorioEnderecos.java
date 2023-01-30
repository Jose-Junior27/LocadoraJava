package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.endereco.Endereco;

public class RepositorioEnderecos extends RepositorioGenerico<Endereco, String> {

    private static Endereco endereco;

    public RepositorioEnderecos(Endereco entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioEnderecos daoEndereco = new RepositorioEnderecos(endereco);
        return daoEndereco;
    }
}
