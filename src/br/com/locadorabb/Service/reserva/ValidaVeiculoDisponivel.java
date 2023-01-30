package br.com.locadorabb.Service.reserva;

import br.com.locadorabb.Service.exceptions.ValidaReservaException;
import br.com.locadorabb.interfaces.IValidaReservavel;
import br.com.locadorabb.model.reserva.Reserva;

public class ValidaVeiculoDisponivel implements IValidaReservavel {
    @Override
    public boolean validarReserva(Reserva reserva) throws ValidaReservaException {
        if (reserva.getVeiculo().getModelo().getCategoria().isIndisponivel()){
            throw new ValidaReservaException("Veículo Indisponível para locação");
        }
        return true;
    }
}
