package br.com.locadorabb.interfaces;

import java.util.List;

public interface IRepositorioCadastravel<T extends IModelavel<I>, I> {

    public T incluir(T entity);

    public T consultar(T entity);

    public T editar(I id, T t);

    public T remover(I id);

    public List<T> listar();

}
