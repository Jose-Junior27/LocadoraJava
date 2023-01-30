package br.com.locadorabb.interfaces;

import br.com.locadorabb.model.reserva.Reserva;

import java.time.LocalDate;

public interface IContratavel<T> {

    public T processarCheckIn();

    public void imprimir();


    public T processarCheckOut(LocalDate dataHora);

}
