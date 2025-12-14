package com.avaliacao.veiculo.avaliacao.veiculo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Anos(List<Dados> anos) {
}