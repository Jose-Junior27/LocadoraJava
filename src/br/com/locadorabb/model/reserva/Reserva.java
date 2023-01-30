package br.com.locadorabb.model.reserva;

import br.com.locadorabb.enumerados.TipoPagamento;
import br.com.locadorabb.interfaces.IModelavel;
import br.com.locadorabb.model.cliente.Cliente;
import br.com.locadorabb.model.endereco.Cidade;
import br.com.locadorabb.model.veiculo.CategoriaVeiculo;
import br.com.locadorabb.model.veiculo.Veiculo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class Reserva implements IModelavel<Long>, Comparable<Reserva> {
    private Long id;
    private Cliente cliente;
    private LocalDateTime dataOrigem;
    private LocalDateTime dataEntrega;
    private Cidade localOrigem;
    private Cidade localDestino;
    private Veiculo veiculo;
    private boolean comSeguro;
    private TipoPagamento tipoPagamento;
    private Double valor;
    private boolean contratado;

    public Reserva(Cliente cliente,
                   LocalDateTime dataOrigem,
                   LocalDateTime dataEntrega,
                   Cidade localOrigem,
                   Cidade localDestino,
                   Veiculo veiculo,
                   boolean comSeguro,
                   TipoPagamento tipoPagamento
                   ){
        this.id = System.currentTimeMillis();
        this.cliente = cliente;
        this.dataOrigem = dataOrigem;
        this.dataEntrega = dataEntrega;
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.veiculo = veiculo;
        this.comSeguro = comSeguro;
        this.tipoPagamento = tipoPagamento;
        this.contratado = false;
        this.valor = 0.0;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDateTime getDataOrigem() {
        return dataOrigem;
    }

    public LocalDateTime getDataEntrega() {
        return dataEntrega;
    }

    public Cidade getLocalOrigem() {
        return localOrigem;
    }

    public Cidade getLocalDestino() {
        return localDestino;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public boolean isComSeguro() {
        return comSeguro;
    }

    public boolean isContratado() {
        return contratado;
    }

    public void setContratado(boolean contratado) {
        this.contratado = contratado;
    }

    public TipoPagamento getTipoPagamento() {
        return tipoPagamento;
    }

    public void setDataEntrega(LocalDateTime dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public void setLocalDestino(Cidade localDestino) {
        this.localDestino = localDestino;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public Long getID() {
        String idCon = this.dataOrigem.format(DateTimeFormatter.ofPattern("yyyyMMdd")) + this.cliente.getCpf();
        return Long.valueOf(idCon);
    }


    @Override
    public int compareTo(Reserva o) {
        Reserva reservaCompare = o;
        String chave = this.dataOrigem + " "+this.cliente.getCpf();
        String chaveCompare = reservaCompare.getDataOrigem() + " " + reservaCompare.getCliente().getCpf();

        return chave.compareTo(chaveCompare);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Reserva){
            Reserva reserva = (Reserva) o;
            if (this.dataOrigem.equals(reserva.getDataOrigem() )
                && (this.getCliente().getCpf().equals(reserva.getCliente().getCpf()))){
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dataOrigem, cliente.getCpf());
    }
}
