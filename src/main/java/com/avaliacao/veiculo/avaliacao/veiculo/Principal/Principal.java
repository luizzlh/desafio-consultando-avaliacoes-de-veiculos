package com.avaliacao.veiculo.avaliacao.veiculo.Principal;

import com.avaliacao.veiculo.avaliacao.veiculo.models.DadosMarca;
import com.avaliacao.veiculo.avaliacao.veiculo.service.ConsumoAPI;
import com.avaliacao.veiculo.avaliacao.veiculo.service.ConverteDados;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

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
        var marcas = conversor.obterLista(json, DadosMarca.class);
        marcas.stream()
                .sorted(Comparator.comparing(DadosMarca::codigo))
                .forEach(System.out::println);

    }


}
