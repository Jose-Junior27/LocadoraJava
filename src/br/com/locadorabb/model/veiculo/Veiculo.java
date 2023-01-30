package br.com.locadorabb.model.veiculo;

import br.com.locadorabb.interfaces.IModelavel;
import br.com.locadorabb.model.reserva.Reserva;

import java.util.Objects;

public class Veiculo implements IModelavel<String> {
    private long id;
    private String placa;
    private String numeroDocumento;
    private int ano;
    private String cor;
    private ModeloVeiculo modelo;

    private boolean locado;

    public Veiculo(String placa,
                   String numeroDocumento,
                   int ano,
                   String cor,
                   ModeloVeiculo modelo){
      this.id = System.currentTimeMillis();
      this.placa = placa;
      this.numeroDocumento = numeroDocumento;
      this.ano = ano;
      this.cor = cor;
      this.modelo = modelo;
      this.locado = false;
    }
    public String getPlaca() {
        return placa;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public int getAno() {
        return ano;
    }

    public String getCor() {
        return cor;
    }

    public ModeloVeiculo getModelo() {
        return modelo;
    }

    public boolean isLocado() {
        return locado;
    }

    public void setLocado(boolean locado) {
        this.locado = locado;
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Veiculo) {
            Veiculo veiculo = (Veiculo) o;
            if (this.placa.equals(veiculo.getPlaca())) {
                return true;
            } else
                return false;
        } else
            return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(placa);
    }

    @Override
    public String getID() {
        return this.placa;
    }


}
