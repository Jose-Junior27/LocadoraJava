package br.com.locadorabb;

import br.com.locadorabb.Service.pagamento.PagamentoCartaoCredito;
import br.com.locadorabb.Service.pagamento.ProcessarFatura;
import br.com.locadorabb.Service.repositorio.RepositorioGenerico;
import br.com.locadorabb.enumerados.TipoPagamento;
import br.com.locadorabb.enumerados.UF;
import br.com.locadorabb.interfaces.IRepositorioCadastravel;
import br.com.locadorabb.model.contrato.CheckIn;
import br.com.locadorabb.model.endereco.Cidade;
import br.com.locadorabb.model.cliente.Cliente;
import br.com.locadorabb.model.endereco.Endereco;
import br.com.locadorabb.model.dao.*;
import br.com.locadorabb.model.reserva.Reserva;
import br.com.locadorabb.model.veiculo.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {

        //***** Cidades *****
        System.out.println("******************** Base Cidades ********************");
        Cidade brasilia  = new Cidade("Brasília", UF.DF, 18000000, 19000000 );
        Cidade saoPaulo  = new Cidade("São Paulo", UF.SP, 19000000, 22000000 );
        IRepositorioCadastravel baseCidades = RepositorioClientes.gerarRepostorio();
        baseCidades.incluir(brasilia);
        baseCidades.incluir(saoPaulo);
        baseCidades.listar();

        //***** Cidades *****
        System.out.println("******************** Base Endereços ********************");
        Endereco alamedaDosEucaliptos = new Endereco("Alameda dos Eucaliptos", "53", "Ap 301", brasilia, 18460000);
        Endereco freiCaneca = new Endereco("Rua Frei Caneca", "2525", "casa", saoPaulo, 18469652);
        Endereco saoPedro = new Endereco("Rua São Pedro", "5325", "casa", saoPaulo, 18469874);
        IRepositorioCadastravel baseEnderecos = RepositorioClientes.gerarRepostorio();
        baseEnderecos.incluir(alamedaDosEucaliptos);
        baseEnderecos.incluir(freiCaneca);
        baseEnderecos.incluir(saoPedro);
        baseEnderecos.listar();

        //***** Clientes *****
        System.out.println("******************** Base Clientes ********************");
        Cliente joseJunior = new Cliente();
        joseJunior.setCpf("99999999999");
        joseJunior.setNome("Jose Santos Junior");
        joseJunior.setLetraCNH("AB");
        joseJunior.setNumeroCNH("21154565666");
        joseJunior.setVencimentoCNH(LocalDate.of(2023,05,10));
        joseJunior.setEndereco(alamedaDosEucaliptos);

        Cliente carlosHenrique = new Cliente();
        carlosHenrique.setCpf("88888888888");
        carlosHenrique.setNome("Carlos Henrique Raimundo");
        carlosHenrique.setLetraCNH("AB");
        carlosHenrique.setNumeroCNH("21154565667");
        carlosHenrique.setVencimentoCNH(LocalDate.of(2023,05,10));
        carlosHenrique.setEndereco(freiCaneca);

        Cliente andreMoraes = new Cliente();
        andreMoraes.setCpf("77777777777");
        andreMoraes.setNome("Andre Moraes");
        andreMoraes.setEndereco(saoPedro);


        IRepositorioCadastravel baseClientes = RepositorioClientes.gerarRepostorio();
        baseClientes.incluir(joseJunior);
        baseClientes.incluir(carlosHenrique);
        baseClientes.incluir(andreMoraes);

        //baseClientes.editar(1, cliente3);
        //baseClientes.remover(1);
        baseClientes.listar();


        //***** Veiculos *****
        System.out.println("******************** Base Marca Veiculo ********************");
        MarcaVeiculo ford = new MarcaVeiculo("Ford");
        MarcaVeiculo fiat = new MarcaVeiculo("Fiat");
        IRepositorioCadastravel baseMarcaVeiculo = RepositorioMarcaVeiculo.gerarRepositorio();
        baseMarcaVeiculo.incluir(ford);
        baseMarcaVeiculo.incluir(fiat);
        baseMarcaVeiculo.listar();

        System.out.println("******************** Base Detalhes Veiculo ********************");
        DetalhesVeiculo arCondicionado = new DetalhesVeiculo("Ar Condicionado");
        DetalhesVeiculo cambioAutomatico = new DetalhesVeiculo("Cambio Automatico");
        DetalhesVeiculo airBag = new DetalhesVeiculo("Air Bag");
        DetalhesVeiculo direcaoHidraulica = new DetalhesVeiculo("Direcao Hidraulica");
        IRepositorioCadastravel baseDetalhes = RepositorioDetalhesVeiculo.gerarRepositorio();
        baseDetalhes.incluir(arCondicionado);
        baseDetalhes.incluir(cambioAutomatico);
        baseDetalhes.incluir(airBag);
        baseDetalhes.incluir(direcaoHidraulica);
        baseDetalhes.listar();

        System.out.println("******************** Base Categoria Veículo ********************");
        CategoriaVeiculo basico = new CategoriaVeiculo("Basico", 80.00);
        CategoriaVeiculo compacto = new CategoriaVeiculo("Compacto", 100.00);
        CategoriaVeiculo luxo = new CategoriaVeiculo("Luxo", 120.00);

        basico.addDetalhesVeiculo(direcaoHidraulica);

        compacto.addDetalhesVeiculo(arCondicionado);
        compacto.addDetalhesVeiculo(direcaoHidraulica);

        luxo.addDetalhesVeiculo(arCondicionado);
        luxo.addDetalhesVeiculo(cambioAutomatico);
        luxo.addDetalhesVeiculo(direcaoHidraulica);
        luxo.addDetalhesVeiculo(airBag);

        IRepositorioCadastravel baseCategoria = RepositorioCategoriaVeiculo.gerarRepositorio();
        baseCategoria.incluir(basico);
        baseCategoria.incluir(compacto);
        baseCategoria.incluir(luxo);

        baseCategoria.listar();

        System.out.println("******************** Base Modelo Veículo ********************");
        ModeloVeiculo fiesta = new ModeloVeiculo("Fiesta", ford, compacto);
        ModeloVeiculo toro = new ModeloVeiculo("Toro", fiat, luxo);

        IRepositorioCadastravel baseModelo = RepositorioModeloVeiculo.gerarRepositorio();
        baseModelo.incluir(fiesta);
        baseModelo.incluir(toro);

        baseModelo.listar();


        System.out.println("******************** Base Veículos ********************");
        Veiculo fordFiesta = new Veiculo("EIQ1949", "1255325563", 2022, "Prata", fiesta);
        Veiculo fiatToro = new Veiculo("EWQ8541", "1255325214", 2021, "Preto", toro);
        IRepositorioCadastravel baseVeiculos = RepositorioVeiculos.gerarRepostorio();
        baseVeiculos.incluir(fordFiesta);
        baseVeiculos.incluir(fiatToro);

        baseVeiculos.listar();


        System.out.println("******************** Base Reservas ********************");
        Reserva reservaJose = new Reserva(
                joseJunior,
                LocalDateTime.of(2023, 02, 01, 10, 00, 00),
                LocalDateTime.of(2023, 02, 05, 10, 00, 00),
                saoPaulo,
                saoPaulo,
                fiatToro,
                true,
                TipoPagamento.CARTAO_CREDITO
        );

        Reserva reservaCarlos = new Reserva(
                carlosHenrique,
                LocalDateTime.of(2023, 02, 01, 10, 00, 00),
                LocalDateTime.of(2023, 02, 05, 10, 00, 00),
                saoPaulo,
                saoPaulo,
                fordFiesta,
                true,
                TipoPagamento.CARTAO_CREDITO
        );

        IRepositorioCadastravel baseReservas = RepositorioReserva.gerarRepositorio();
        baseReservas.incluir(reservaJose);
        baseReservas.incluir(reservaCarlos);
        baseReservas.listar();

        //Consultar reserva
        Reserva reserva = (Reserva) baseReservas.consultar(reservaJose);
        if (reserva == null){
            System.out.println("Reserva não encontrada!!!");
        }

        System.out.println("******************** Fazer Check-In ********************");

        if (baseReservas != null && reserva != null) {
            CheckIn checkIn = new CheckIn(reserva, new PagamentoCartaoCredito(ProcessarFatura.processarFatura(reserva) ,"454545", (byte) 3));
            checkIn.processarCheckIn();
            checkIn.imprimir();

            //checkIn.processarCheckOut( LocalDate.of(2023, 02, 05));
        }


        //***** Exemplo Pagamentos *****
        /*ProcessarPagamento.processarPagamento(new PagamentoPix("99999999999", 50));
        ProcessarPagamento.processarPagamento(new PagamentoCartaoCredito(200.00, "454545", (byte) 3));*/

    }
}