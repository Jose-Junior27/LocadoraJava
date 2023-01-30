package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.endereco.Cidade;

public class RepositorioCidades extends RepositorioGenerico<Cidade, String> {

    private static Cidade cidade;

    public RepositorioCidades(Cidade entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        RepositorioCidades daoCidades = new RepositorioCidades(cidade);
        return daoCidades;
    }
}
