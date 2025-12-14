package com.avaliacao.veiculo.avaliacao.veiculo.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosModelo(int codigo,
                          String modelo) {
}
