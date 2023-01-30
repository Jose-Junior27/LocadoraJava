package br.com.locadorabb.Service.repositorio;

import br.com.locadorabb.interfaces.IModelavel;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;

import java.util.ArrayList;
import java.util.List;

public abstract class RepositorioGenerico<T extends IModelavel<I>, I> implements IRepositorioCadastravel<T, I> {

    protected List<T> listaEntidades = new ArrayList<>();
    protected T entidade;

    public RepositorioGenerico(T entidade){

        this.entidade = entidade;
    }

    @Override
    public T incluir(T entity) {
        try {
            if (entity == null) {
               throw new RuntimeException("O Objeto não pode ser nulo para inclusão");
            }

            listaEntidades.add(entity);
            return entidade;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T consultar(T entity) {
        if (entity == null) {
            throw new RuntimeException("O Objeto não pode ser nulo para inclusão");
        }

        try {
            int index = listaEntidades.indexOf(entity);
            return listaEntidades.get(index);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public T editar(I id, T t) {
        try {
            if (t == null) {
                throw new RuntimeException("O objeto não pode ser nulo para edição");
            }

            listaEntidades.set( (Integer) id, t);
            return listaEntidades.get( (Integer) id);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public T remover(I id) {
        T ent;
        int index = (Integer)id;
        try {

            ent = listaEntidades.get(index);
            if (ent == null) {
                throw new RuntimeException("O Objeto não pode ser nulo para exclusão");
            }

            listaEntidades.remove(index);
            return listaEntidades.get( index);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<T> listar() {
        listaEntidades.forEach((n) -> System.out.println(n.getID()));
        return listaEntidades;
    }

    public static IRepositorioCadastravel gerarRepositorio() {
        return null;
    }

}
