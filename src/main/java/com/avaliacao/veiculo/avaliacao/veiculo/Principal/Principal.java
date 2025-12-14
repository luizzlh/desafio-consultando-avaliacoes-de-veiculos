package com.avaliacao.veiculo.avaliacao.veiculo.Principal;

import com.avaliacao.veiculo.avaliacao.veiculo.models.Dados;
import com.avaliacao.veiculo.avaliacao.veiculo.models.Modelos;
import com.avaliacao.veiculo.avaliacao.veiculo.models.Veiculo;
import com.avaliacao.veiculo.avaliacao.veiculo.service.ConsumoAPI;
import com.avaliacao.veiculo.avaliacao.veiculo.service.ConverteDados;

import java.util.*;
import java.util.stream.Collectors;

public class Principal {

    private ConsumoAPI consumo = new ConsumoAPI();
    private Scanner scanner = new Scanner(System.in);
    private ConverteDados conversor = new ConverteDados();

    private final String URL = "https://parallelum.com.br/fipe/api/v1/";
    private final String CARROS = "carros/marcas";
    private final String MOTOS = "motos/marcas";
    private final String CAMINHOES = "caminhoes/marcas";

    public void exibeMenu(){
        System.out.println("========================");
        System.out.println("Qual veículo deseja visualizar?");
        System.out.println("Carros");
        System.out.println("Motos");
        System.out.println("Caminhões");
        System.out.print("Sua escolha: ");
        String escolha = scanner.nextLine();
        String endereco;

        if(escolha.toLowerCase().contains("carr")){
            endereco = URL + CARROS;
        } else if(escolha.toLowerCase().contains("mot")){
            endereco = URL + MOTOS;
        } else{
            endereco = URL + CAMINHOES;
        }

        var json = consumo.obterDados(endereco);
        System.out.println(json);
        var marcas = conversor.obterLista(json, Dados.class);
        marcas.stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.print("Informe o código da marca para consulta: ");
        var codigoMarca = scanner.nextLine();

        endereco = endereco + "/" + codigoMarca + "/modelos";
        json = consumo.obterDados(endereco);
        var modeloLista = conversor.obterDados(json, Modelos.class);
        //System.out.println(modeloLista);
        System.out.println("Modelos da Marca: ");
        modeloLista.modelos()
                .stream()
                .sorted(Comparator.comparing(Dados::codigo))
                .forEach(System.out::println);

        System.out.println("Digite um trecho do nome do veículo");
        var nomeVeiculo = scanner.nextLine();

        List<Dados> modelosFiltrados = modeloLista.modelos().stream()
                .filter(m -> m.nome().toLowerCase().contains(nomeVeiculo.toLowerCase()))
                .collect(Collectors.toList());

        System.out.println("\nModelos filtrados: ");
        modelosFiltrados.forEach(System.out::println);

        System.out.println("Digite por favor o código do modelo: ");
        var codigoModelo = scanner.nextLine();

        endereco = endereco + "/" + codigoModelo + "/anos";
        json = consumo.obterDados(endereco);
        List<Dados> anos = conversor.obterLista(json, Dados.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < anos.size(); i++) {
            var enderecoAnos = endereco + "/" + anos.get(i).codigo();
            json = consumo.obterDados(enderecoAnos);
            Veiculo veiculo = conversor.obterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }

        System.out.println("\nTodos os veículos filtrados com avaliações por ano: ");
        veiculos.forEach(System.out::println);



    }

}