package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.cliente.Cliente;

public class RepositorioClientes extends RepositorioGenerico<Cliente, String> {

    private static Cliente cliente;
    public RepositorioClientes(Cliente entidade) {

        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepostorio(){
        RepositorioClientes daoClientes = new RepositorioClientes(cliente);
        return daoClientes;
    }
}

