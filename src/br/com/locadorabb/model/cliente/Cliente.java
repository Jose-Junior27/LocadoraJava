package br.com.locadorabb.model.cliente;

import br.com.locadorabb.interfaces.IModelavel;
import br.com.locadorabb.model.endereco.Endereco;

import java.time.LocalDate;

public class Cliente implements IModelavel<String> {

    private long id;
    private String cpf;
    private String nome;
    private Endereco endereco;
    private String fone;
    private String celular;
    private String email;
    private LocalDate nascimento;
    private String numeroCNH;
    private String letraCNH;
    private LocalDate vencimentoCNH;

    public Cliente(){

        this.id = System.currentTimeMillis();
    };

    public Cliente(String cpf,
                   String nome,
                   Endereco endereco,
                   String fone,
                   String celular,
                   String email,
                   LocalDate nascimento,
                   String numeroCNH,
                   String letraCNH,
                   LocalDate vencimentoCNH){
        this.id = System.currentTimeMillis();
        this.cpf = cpf;
        this.nome = nome;
        this.endereco = endereco;
        this.fone = fone;
        this.celular = celular;
        this.email = email;
        this.nascimento = nascimento;
        this.numeroCNH = numeroCNH;
        this.letraCNH = letraCNH;
        this.vencimentoCNH = vencimentoCNH;

    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getLetraCNH() {
        return letraCNH;
    }

    public void setLetraCNH(String letraCNH) {
        this.letraCNH = letraCNH;
    }

    public LocalDate getVencimentoCNH() {
        return vencimentoCNH;
    }

    public void setVencimentoCNH(LocalDate vencimentoCNH) {
        this.vencimentoCNH = vencimentoCNH;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public String getFone() {
        return fone;
    }

    public String getCelular() {
        return celular;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String getID() {
        return this.cpf;
    }
}
