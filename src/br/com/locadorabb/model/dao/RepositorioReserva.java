package br.com.locadorabb.model.dao;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.Service.reserva.ValidaCNHVencida;
import br.com.locadorabb.Service.reserva.ValidaDataEntrega;
import br.com.locadorabb.Service.reserva.ValidaDataOrigem;
import br.com.locadorabb.Service.reserva.ValidaVeiculoDisponivel;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.interfaces.IValidaReservavel;
import br.com.locadorabb.model.reserva.Reserva;

public class RepositorioReserva extends RepositorioGenerico<Reserva, Long>  {
    private static Reserva reserva;
    private  IValidaReservavel validaReserva;

    public RepositorioReserva(Reserva entidade) {
        super(entidade);
    }

    public static IRepositorioCadastravel gerarRepositorio() {

        RepositorioReserva daoReserva = new RepositorioReserva(reserva);
        return daoReserva;
    }

    @Override
    public Reserva incluir(Reserva entity) {
        try {
            if (entity == null) {
                throw new RuntimeException("O Objeto não pode ser nulo para inclusão");
            }

           processarValidacao(entity);

            listaEntidades.add(entity);
            return entidade;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void processarValidacao(Reserva reserva) throws ValidaReservaException {
        validaReserva = new ValidaDataOrigem();
        validaReserva.validarReserva(reserva);

        validaReserva = new ValidaDataEntrega();
        validaReserva.validarReserva(reserva);

        validaReserva = new ValidaCNHVencida();
        validaReserva.validarReserva(reserva);

        validaReserva = new ValidaVeiculoDisponivel();
        validaReserva.validarReserva(reserva);
    }

}
