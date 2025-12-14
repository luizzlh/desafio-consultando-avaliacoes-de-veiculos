package com.avaliacao.veiculo.avaliacao.veiculo.service;

public interface IConverteDados {

    <T> T obterDados(String json, Class<T> classe);

}