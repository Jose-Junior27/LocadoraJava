package br.com.locadorabb.Service.reserva;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.interfaces.IValidaReservavel;
import br.com.locadorabb.model.reserva.Reserva;

public class ValidaDataEntrega implements IValidaReservavel {
    @Override
    public boolean validarReserva(Reserva reserva) throws ValidaReservaException {
        if (reserva.getDataEntrega().isBefore(reserva.getDataOrigem())){
            throw new ValidaReservaException("Data Entrega inferior a Data de Origem");
        }
        return true;
    }
}
