package br.com.locadorabb.Service.reserva;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.interfaces.IValidaReservavel;
import br.com.locadorabb.model.reserva.Reserva;

import java.time.LocalDateTime;

public class ValidaDataOrigem implements IValidaReservavel {
    @Override
    public boolean validarReserva(Reserva reserva) throws ValidaReservaException {
        if (reserva.getDataOrigem().isBefore(LocalDateTime.now())){
            throw new ValidaReservaException("Data inferior a Data Atual");
        }
        return true;
    }
}
