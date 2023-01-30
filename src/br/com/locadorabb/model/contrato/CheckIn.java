package br.com.locadorabb.model.contrato;

import br.com.locadorabb.Service.pagamento.ProcessarFatura;
import br.com.locadorabb.Service.pagamento.ProcessarPagamento;
import br.com.locadorabb.enumerados.StatusCheckIn;
import br.com.locadorabb.interfaces.IContratavel;
import br.com.locadorabb.interfaces.IGatewayPagavel;
import br.com.locadorabb.model.reserva.Reserva;

import java.time.LocalDate;

public class CheckIn implements IContratavel<Reserva> {
    private Reserva reserva;
    private IGatewayPagavel pagamento;
    private boolean pago;
    private StatusCheckIn status;
    private LocalDate dataCheckIn;
    private LocalDate dataCheckOut;

    public CheckIn(Reserva reserva, IGatewayPagavel pagamento){
        this.reserva = reserva;
        this.pagamento = pagamento;
        this.pago = false;
        this.status = StatusCheckIn.ABERTO;
        this.dataCheckIn = LocalDate.now();
        this.dataCheckOut = null;
    }

    public Reserva getReserva() {
        return reserva;
    }

    public IGatewayPagavel getPagamento() {
        return pagamento;
    }

    public boolean isPago() {
        return pago;
    }

    public StatusCheckIn getStatus() {
        return status;
    }

    public LocalDate getDataCheckIn() {
        return dataCheckIn;
    }

    public LocalDate getDataCheckOut() {
        return dataCheckOut;
    }

    @Override
    public Reserva processarCheckIn() {
        this.reserva.setValor( ProcessarFatura.processarFatura(this.reserva) );
        if (! ProcessarPagamento.processarPagamento(pagamento)){
            return null;
        }
        this.pago = true;
        this.status = StatusCheckIn.CONTRATADO;
        reserva.setContratado(true);
        reserva.getVeiculo().setLocado(true);
        return reserva;
    }

    @Override
    public void imprimir() {
        if (reserva.isContratado()) {
            System.out.println("---------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|      CheckIn - RESERVA: " + reserva.getID());
            System.out.println("|");
            System.out.println("| Cliente: " + reserva.getCliente().getNome());
            System.out.println("| CPF: " + reserva.getCliente().getCpf());
            System.out.println("| Data Início: " + reserva.getDataOrigem());
            System.out.println("| Local Início: " + reserva.getLocalOrigem().getNome());
            System.out.println("| Veículo: " + reserva.getVeiculo().getPlaca() + " " + reserva.getVeiculo().getModelo().getNome());
            System.out.println("| Data  Entrega: " + reserva.getDataEntrega());
            System.out.println("| Local Entrega: " + reserva.getLocalDestino().getNome());
            System.out.println("| Categoria: " + reserva.getVeiculo().getModelo().getCategoria().getNome());
            System.out.println("| Valor Diária: R$" + reserva.getVeiculo().getModelo().getCategoria().getValorDiaria());
            System.out.println("| Valor Contrato: R$" + reserva.getValor());
            System.out.println("|---------------------------------------------------------------------------------------------------------------------------");
        } else {
            System.out.println("Não foi possível imprimir - Reserva não efetivada");
        }

    }

    @Override
    public Reserva processarCheckOut( LocalDate dataHora){
       if (this.status == StatusCheckIn.EM_TRANSITO || this.status == StatusCheckIn.CONTRATADO) {
           this.dataCheckOut = LocalDate.now();
           this.status = StatusCheckIn.ENCERRADO;
           reserva.getVeiculo().setLocado(false);
           reserva.getVeiculo().getModelo().setReservado(false);
            return reserva;
       }else{
           return null;
       }

    }

}
