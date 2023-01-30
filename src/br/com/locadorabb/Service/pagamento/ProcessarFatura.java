package br.com.locadorabb.Service.pagamento;

import br.com.locadorabb.model.reserva.Reserva;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class ProcessarFatura {

    public static Double processarFatura(Reserva reserva){
        LocalDateTime dataInicial;
        LocalDateTime dataFinal;
        Double valorHora;

        dataInicial = reserva.getDataOrigem();
        dataFinal = reserva.getDataEntrega();
        valorHora = (reserva.getVeiculo().getModelo().getCategoria().getValorDiaria()) / 24;
        return valorHora * ( dataInicial.until(dataFinal, ChronoUnit.HOURS) );

    }

}
