package br.com.locadorabb.interfaces;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.model.reserva.Reserva;

public interface IValidaReservavel {

    public boolean validarReserva(Reserva reserva) throws ValidaReservaException;

}
