package com.avaliacao.veiculo.avaliacao.veiculo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosVeiculo(String marca,
                           String modelo,
                           int ano,
                           double valor,
                           String combustivel) {
}