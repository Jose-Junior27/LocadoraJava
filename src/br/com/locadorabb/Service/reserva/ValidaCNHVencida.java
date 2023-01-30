package br.com.locadorabb.Service.reserva;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.interfaces.IValidaReservavel;
import br.com.locadorabb.model.reserva.Reserva;

import java.time.LocalDate;

public class ValidaCNHVencida implements IValidaReservavel {
    @Override
    public boolean validarReserva(Reserva reserva) throws ValidaReservaException {
        if (reserva.getCliente().getVencimentoCNH().isBefore(LocalDate.now())){
            throw new ValidaReservaException("Cliente com CNH Vencida!");
        }
        return true;
    }
}
